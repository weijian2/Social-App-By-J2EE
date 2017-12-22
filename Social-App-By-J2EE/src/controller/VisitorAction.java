package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import databean.UserBean;
import databean.PostBean;
import model.CommentDAO;
import model.Model;
import model.PostDAO;
import model.UserDAO;

public class VisitorAction extends Action {
	private PostDAO postDAO;
	private CommentDAO commentDAO;
	private UserDAO userDAO;
	
    public VisitorAction(Model model) {
		postDAO = model.getPostDAO();
		commentDAO = model.getCommentDAO();
		userDAO = model.getUserDAO();
    }
    
    public String getName() {
        return "visitor.do";
    }
    
    public String performGet(HttpServletRequest request) {
        return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        String email = request.getParameter("email");
        
        
        
        try {
        		PostBean[] posts = postDAO.getPosts(email);
        		UserBean user = userDAO.read(email);
        		request.setAttribute("posts", posts);
        		request.setAttribute("currentUser", user);
        		request.setAttribute("comments", commentDAO.getComments(request));
            request.setAttribute("users", userDAO.getUsers());
        		
            return "VisitorPage.jsp";
        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
        
    }
}
