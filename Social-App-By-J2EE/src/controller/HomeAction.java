package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import databean.UserBean;
import model.Model;
import model.PostDAO;
import model.CommentDAO;
import model.UserDAO;

public class HomeAction extends Action {
	private PostDAO postDAO;
	private CommentDAO commentDAO;
	private UserDAO userDAO;
	
    public HomeAction(Model model) {
    		postDAO = model.getPostDAO();
    		commentDAO = model.getCommentDAO();
    		userDAO = model.getUserDAO();
    }
    
    public String getName() {
        return "home.do";
    }
    
    public String performGet(HttpServletRequest request) {
        return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        if (user == null) {
            return "login.jsp";
        }
        
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        try {
            request.setAttribute("posts", postDAO.getPosts(request));
            request.setAttribute("comments", commentDAO.getComments(request));
            request.setAttribute("users", userDAO.getUsers());
            
            return ("HomePage.jsp");
        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
