package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import databean.CommentBean;
import databean.UserBean;
import formbean.CommentForm;
import model.Model;
import model.UserDAO;

public class LogoutAction extends Action {
	private UserDAO userDAO;
	
    public LogoutAction(Model model) {
    		userDAO = model.getUserDAO();
    }
    
    public String getName() {
        return "logout.do";
    }
    
    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.setAttribute("user", null);
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            request.setAttribute("users", userDAO.getUsers());
            return "login.jsp";

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
        
    }
}
