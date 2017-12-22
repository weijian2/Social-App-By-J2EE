<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row comment">
    <div class="col-md-2"></div>
    <div class="col-md-10">
        <textarea class="form-control post" rows="5" readonly>${param.commentContent}</textarea>
        <p>Comment by <a href="#">${param.commentEmail} </a> at ${param.commentDate}</p>
        
<%-- <%
		if (request.getParameter("commentEmail").equals(request.getParameter("loggedEmail"))) {
%>
			<form method="POST" action="deleteComment.do">
				<button type="submit" class="btn btn-primary a-btn-slide-text deleteBtn setMargin">
					<span><strong>Delete</strong></span>
				</button>
				<input type="hidden" name="id" value="<%= request.getParameter("commentId") %>">
			</form>
<%
		}
%>	 --%>	

		<c:if test="${ param.commentEmail eq param.loggedEmail }">
			<form method="POST" action="deleteComment.do">
				<button type="submit" class="btn btn-primary a-btn-slide-text deleteBtn setMargin">
					<span><strong>Delete</strong></span>
				</button>
				<input type="hidden" name="id" value="<%= request.getParameter("commentId") %>">
			</form>
      	</c:if>
		
		
    </div>
</div>