<%@ page import="databean.UserBean" %>
<%@ page import="databean.PostBean" %>
<%@ page import="databean.CommentBean" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Visitor</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles/mycss.css">
</head>
<body>


<%
		UserBean user = (UserBean) session.getAttribute("user");
		String userName = null;
		String loggedEmail = null;
		if (user != null) {
			userName = user.getFirstName();
			loggedEmail = user.getEmail();
		}
		UserBean currentUser = (UserBean) request.getAttribute("currentUser");
		String currentUserName = currentUser.getFirstName();
		UserBean[] users = (UserBean[]) request.getAttribute("users");
%>		
	

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="home.do">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home.do"> My Profile <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">People</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
<% 
					if (users != null) {
						for (UserBean otherUser : users) {
							String UserName = otherUser.getFirstName();
							String email = otherUser.getEmail();
%>
							
							<form method="POST" action="visitor.do">
								<button class="dropdown-item" type="submit"><%=UserName %></button>
								<input type="hidden" name="email" value="<%=email %>">
							</form>
<%
						}
					}
%>
                </div>
            </li>
        </ul>
        <a class="navbar-brand" href="home.do"><%= userName %></a>
        <form class="form-inline my-2 my-lg-0" action="logout.do" method="post">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
        </form>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <h1 class="setMargin myPage"> <%=currentUserName %>'s posts </h1>
        </div>
        <div class="col-md-3"></div>
    </div>
    
    <div class="row"> 
        <div class="col-md-2"></div>
        <div class="col-md-8">
        		<%
        				PostBean[] posts = (PostBean[]) request.getAttribute("posts");
			        for (int i = 0; i < posts.length; i++) {
			            PostBean post = posts[i];
			            String content = post.getContent();
			            Date date = post.getDate();
			            int id = post.getId();
			%>
			            <jsp:include page="VisitorPostedNews.jsp">
			            		<jsp:param name="userName" value="<%=currentUserName %>" />
			            		<jsp:param name="content" value="<%=content %>" />
			            		<jsp:param name="date" value="<%=date %>" />
			            </jsp:include>
			            
			            <jsp:include page="Comment.jsp">
			            		<jsp:param name="id" value="<%=id %>" />
			            </jsp:include>
			            
			<%
						CommentBean[] comments = (CommentBean[]) request.getAttribute("comments");
						if (comments != null) {
							for (CommentBean comment : comments) {
								if (comment.getPostId() == id) {
									String commentContent = comment.getContent();
									Date commentDate = comment.getDate();
									String commentEmail = comment.getEmail();
									
									int commentId = comment.getId();
			%>
									<jsp:include page="VisitorComment.jsp">
										<jsp:param name="commentContent" value="<%=commentContent %>" />
										<jsp:param name="commentDate" value="<%=commentDate %>" />
										<jsp:param name="commentEmail" value="<%=commentEmail %>" />
										<jsp:param name="loggedEmail" value="<%=loggedEmail %>" />
										<jsp:param name="commentId" value="<%=commentId %>" />
									</jsp:include>
			<%
								}
							}
						}
			        }
			%>
			
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<jsp:include page="FooterTemplate.html" />

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>