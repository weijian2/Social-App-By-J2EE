package model;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databean.PostBean;
import databean.UserBean;

public class PostDAO extends GenericDAO<PostBean> {
    public PostDAO(ConnectionPool cp, String tableName) throws DAOException {
        super(PostBean.class, tableName, cp);
    }
    
	public PostBean[] getPosts(HttpServletRequest request) throws RollbackException {

		// Calls GenericDAO's match() method.
		// This no match constraint arguments, match returns all the Post beans
		
		// only show current logged in user's posts
		UserBean currentUser = (UserBean) request.getSession().getAttribute("user");
		String email = currentUser.getEmail();
		PostBean[] posts = match(MatchArg.equals("email", email));
		
		Arrays.sort(posts, (PostBean post1, PostBean post2) -> post2.getDate().compareTo(post1.getDate()));

		return posts;
	}
	
	public PostBean[] getPosts(String email) throws RollbackException {

		// Calls GenericDAO's match() method.
		// This no match constraint arguments, match returns all the Post beans
		
		// only show current logged in user's posts
		PostBean[] posts = match(MatchArg.equals("email", email));
		
		Arrays.sort(posts, (PostBean post1, PostBean post2) -> post2.getDate().compareTo(post1.getDate()));

		return posts;
	}
}
