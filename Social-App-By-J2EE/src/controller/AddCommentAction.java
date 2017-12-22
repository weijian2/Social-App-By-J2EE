package controller;

import model.Model;
import model.PostDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databean.PostBean;
import databean.UserBean;
import databean.CommentBean;
import formbean.CommentForm;
import formbean.PostForm;
import model.CommentDAO;
import model.UserDAO;

public class AddCommentAction extends Action {
    private PostDAO postDAO;
    private CommentDAO commentDAO;
    private UserDAO userDAO;

    public AddCommentAction(Model model) {
    		postDAO = model.getPostDAO();
    		commentDAO = model.getCommentDAO();
    		userDAO = model.getUserDAO();
    }

    public String getName() {
        return "addComment.do";
    }
    
    public String performPost(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            // Fetch the posts/comments now, so that in case there is no form or there are errors
            // We can just dispatch to the JSP to show the post/comment list (and any errors)
            request.setAttribute("comments", commentDAO.getComments(request));
            request.setAttribute("posts", postDAO.getPosts(request));

            CommentForm form = new CommentForm(request);
            request.setAttribute("form", form);

            errors.addAll(form.getValidationErrors());
            if (errors.size() > 0) {
                return "HomePage.jsp";
            }

            CommentBean bean = new CommentBean();
            bean.setContent(form.getContent());
            bean.setDate(new Date());
            bean.setEmail(((UserBean) request.getSession().getAttribute("user")).getEmail());
            bean.setPostId(Integer.parseInt(form.getPostId()));

            commentDAO.create(bean);

            // Fetch the comments again, since we modified the list
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
