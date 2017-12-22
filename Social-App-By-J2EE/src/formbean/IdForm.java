package formbean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class IdForm {
    private String id;

    public IdForm(HttpServletRequest request) {
        id = request.getParameter("id");
    }

    public String getId() {
        return id;
    }

    public int getIdAsInt() {
        // Be sure to first call getValidationErrors() to ensure
        // that NullPointer exception or NumberFormatException will not be
        // thrown!
        return Integer.parseInt(id);
    }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (id == null || id.length() == 0) {
            errors.add("Id is required");
            return errors;
        }

        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            errors.add("Id is not an integer");
        }

        return errors;
    }
}
