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
import databean.CommentBean;

public class CommentDAO extends GenericDAO<CommentBean> {
    public CommentDAO(ConnectionPool cp, String tableName) throws DAOException {
        super(CommentBean.class, tableName, cp);
    }
    
	public CommentBean[] getComments(HttpServletRequest request) throws RollbackException {

		// Calls GenericDAO's match() method.
		// This no match constraint arguments, match returns all the Comment beans
		
		String postId = request.getParameter("id");

		//CommentBean[] comments = match(MatchArg.equals("postId", Integer.parseInt(postId)));
		CommentBean[] comments = match();
		
		Arrays.sort(comments, (CommentBean comment1, CommentBean comment2) -> comment1.getDate().compareTo(comment2.getDate()));

		return comments;
	}
}
