package formbean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class CommentForm {
	private String content;
	private String button;
	private String postId;

	public CommentForm(HttpServletRequest request) {
		content = request.getParameter("comment");
		button = request.getParameter("button");
		postId = request.getParameter("id");
	}
	
    public String getContent() {
        return content;
    }

    public String getButton() {
        return button;
    }
    
    public String getPostId() {
    		return postId;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (content == null || content.length() == 0) {
            errors.add("comment cannot be empty");
        }
        
        if (postId == null || postId.length() == 0) {
            errors.add("post id cannot be empty");
        }
        
        
        if (button == null) {
            errors.add("Action is required");
        }

        if (errors.size() > 0) {
            return errors;
        }

        if (!button.equals("commentButton")) {
            errors.add("Invalid action");
        }
        
        return errors;
    }
}
