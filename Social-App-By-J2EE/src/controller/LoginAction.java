package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import databean.UserBean;
import formbean.LoginForm;
import model.Model;
import model.UserDAO;

public class LoginAction extends Action {
	private UserDAO userDAO;
	
    public LoginAction(Model model) {
        userDAO = model.getUserDAO();
    }
    
    public String getName() {
        return "login.do";
    }
    
    public String performGet(HttpServletRequest request) {
        // If user is already logged in, redirect to home.do
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "home.do";
        }
        
        // Otherwise, just display the login page.
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
    
    public String performPost(HttpServletRequest request) {
        // If user is already logged in, redirect to home.do
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "home.do";
        }
        
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
        try {
            LoginForm form = new LoginForm(request);
            request.setAttribute("form", form);
            // pass all registered UserBean to nav bar
            request.setAttribute("users", userDAO.getUsers());
            
            // first, get validation errors
            errors.addAll(form.getValidationErrors());
            // if exists errors, we redirect to login page and show errors
            if (errors.size() != 0) {
            		return "login.jsp";
            }
            // for here, there has no validation error in Login Form
            // if clicked button is register, we redirect user to Register Servlet
            if (form.getButton().equals("Register")) {
                return "register.do";
            }
            // for here, we make sure that clicked button is Login, we now need to get email from database
            UserBean user = userDAO.read(form.getEmail()); // get user information
            if (user == null) {
                errors.add("No such user, please register first");
                return "login.jsp";
            }

            if (!form.getPassword().equals(user.getPassword())) {
                errors.add("Incorrect password");
                return "login.jsp";
            }
            // for here, we can login this user, set session and redirect user to Home Servlet
            session.setAttribute("user", user);
            return "home.do";

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
