<form class="form-signin" method="POST" action="addComment.do">
	<div class="row comment">
	    <div class="col-md-2"></div>
	    <div class="col-md-10">
	        <textarea class="form-control post" rows="5" name="comment"></textarea>
	        <div class="setMargin">
	    			<button id="CommentButton" class="btn btn-outline-success my-2 my-sm-0" type="submit" name="button" value="commentButton">Comment</button>
			</div>
	    </div>
	</div>
	<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
</form>