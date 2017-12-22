<textarea class="form-control post" rows="5" readonly>${param.content}</textarea>
<p>Post by <a href="#">${param.userName}</a> at ${param.date}</p>
<form method="POST" action="deletePost.do">
	<button type="submit" class="btn btn-primary a-btn-slide-text deleteBtn setMargin">
		<span><strong>Delete</strong></span>
	</button>
	<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
</form>