package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import formbean.IdForm;
import model.Model;
import model.PostDAO;
import model.CommentDAO;
import model.UserDAO;
import databean.UserBean;

public class DeletePostAction extends Action {
    private PostDAO postDAO;
    private CommentDAO commentDAO;
    private UserDAO userDAO;

    public DeletePostAction(Model model) {
    		postDAO = model.getPostDAO();
    		commentDAO = model.getCommentDAO();
    		userDAO = model.getUserDAO();
    }

    public String getName() {
        return "deletePost.do";
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
            
            postDAO.delete(form.getIdAsInt());

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
