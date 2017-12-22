package controller;

import model.Model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import formbean.IdForm;
import model.CommentDAO;
import model.PostDAO;
import model.UserDAO;

public class DeleteCommentAction extends Action {
    private CommentDAO commentDAO;
    private PostDAO postDAO;
    private UserDAO userDAO;

    public DeleteCommentAction(Model model) {
    		commentDAO = model.getCommentDAO();
    		postDAO = model.getPostDAO();
    		userDAO = model.getUserDAO();
    }

    public String getName() {
        return "deleteComment.do";
    }
    
    public String performPost(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            IdForm form = new IdForm(request);
            errors.addAll(form.getValidationErrors());
            if (errors.size() > 0) {
                return "error.jsp";
            }
            //UserBean currentUser = (UserBean) request.getSession().getAttribute("user");
            
            commentDAO.delete(form.getIdAsInt());

            request.setAttribute("posts", postDAO.getPosts(request));
            request.setAttribute("comments", commentDAO.getComments(request));
            request.setAttribute("users", userDAO.getUsers());
            return "HomePage.jsp";

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
