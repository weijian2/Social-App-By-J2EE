<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>MyBlog -- Error Page</title>
    </head>
    
	<body>
	
		<h2>Error</h2>
<%-- <%
		List<String> errors = (List<String>) request.getAttribute("errors");
		if (errors != null) {
			for (String error : errors) {
%>		
				<h3 style="color:red"> <%= error %> </h3>
<%
			}
		}
		
		if (session.getAttribute("user") == null) {
%>
			Click <a href="login.do">here</a> to login.
<%
		} else {
%>
			Click <a href="home.do">here</a> to return to the home page.
<%
		}
%>	 --%>
	
        <c:if test="${!(empty errors)}">
                <c:forEach var="error" items="${ errors }">
                    <h3 style="color:red"> ${ error } </h3>
                </c:forEach>
        </c:if>
        
        	<c:choose>
			<c:when test="${ (empty user) }">
				Click <a href="login.do">here</a> to login.
			</c:when>
			<c:otherwise>
				Click <a href="home.do">here</a> to return to the home page.
			</c:otherwise>
		</c:choose>
		
	</body>
</html>