package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;

import databean.UserBean;
import formbean.RegisterForm;
import model.Model;
import model.UserDAO;

public class RegisterAction extends Action {
	private UserDAO userDAO;
	
    public RegisterAction(Model model) {
        userDAO = model.getUserDAO();
    }
    
    public String getName() {
        return "register.do";
    }
    
    public String performGet(HttpServletRequest request) {
        // If user is already logged in, redirect to home.do
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "home.do";
        }
        
        // Otherwise, just display the register page.
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        try {
            request.setAttribute("users", userDAO.getUsers());
            return "Register.jsp";
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
            RegisterForm form = new RegisterForm(request);
            request.setAttribute("form", form);
            // pass all registered UserBean to nav bar
            request.setAttribute("users", userDAO.getUsers());
            // first, get validation errors
            errors.addAll(form.getValidationErrors());
            // if exists errors, we redirect to register page and show errors
            if (errors.size() != 0) {
                return "Register.jsp";
            }
            // try to create a new user
            UserBean user = new UserBean();
            user.setEmail(form.getEmail());
            user.setPassword(form.getPassword1());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            try {
                userDAO.create(user);
                session.setAttribute("user", user);
                return ("home.do");
            } catch (DuplicateKeyException e) {
                errors.add("A user with this email already exists");
                return "Register.jsp";
            }

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
