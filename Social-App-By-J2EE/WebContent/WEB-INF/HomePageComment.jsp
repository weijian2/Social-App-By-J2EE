<div class="row comment">
    <div class="col-md-2"></div>
    <div class="col-md-10">
        <textarea class="form-control post" rows="5" readonly>${param.commentContent}</textarea>
        <p>Comment by <a href="#">${param.email} </a> at ${param.commentDate}</p>
		<form method="POST" action="deleteComment.do">
			<button type="submit" class="btn btn-primary a-btn-slide-text deleteBtn setMargin">
				<span><strong>Delete</strong></span>
			</button>
			<input type="hidden" name="id" value="<%= request.getParameter("commentId") %>">
		</form>
    </div>
</div>