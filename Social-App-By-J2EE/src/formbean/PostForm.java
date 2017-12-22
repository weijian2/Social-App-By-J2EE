package formbean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PostForm {
	private String content;
	private String button;

	public PostForm(HttpServletRequest request) {
		content = request.getParameter("post");
		button = request.getParameter("button");
	}
	
    public String getContent() {
        return content;
    }

    public String getButton() {
        return button;
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (content == null || content.length() == 0) {
            errors.add("content cannot be empty");
        }
        
        
        if (button == null) {
            errors.add("Action is required");
        }

        if (errors.size() > 0) {
            return errors;
        }

        if (!button.equals("postButton")) {
            errors.add("Invalid action");
        }
        
        return errors;
    }
}
