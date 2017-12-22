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

public class UserDAO extends GenericDAO<UserBean> {
    public UserDAO(ConnectionPool cp, String tableName) throws DAOException {
        super(UserBean.class, tableName, cp);
    }
    
	public UserBean[] getUsers() throws RollbackException {

		// Calls GenericDAO's match() method.
		// This no match constraint arguments, match returns all the User beans
		
		UserBean[] users = match();
		
		return users;
	}
}


//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import databean.UserBean;
//
//
//
//
//
//public class UserDAO {
//    private List<Connection> connectionPool = new ArrayList<Connection>();
//
//    private String jdbcDriver;
//    private String jdbcURL;
//    private String tableName;
//
//    public UserDAO(String jdbcDriver, String jdbcURL, String tableName)
//            throws MyDAOException {
//        this.jdbcDriver = jdbcDriver;
//        this.jdbcURL = jdbcURL;
//        this.tableName = tableName;
//
//        if (!tableExists())
//            createTable();
//    }
//    
//    public void create(UserBean user) throws MyDAOException {
//        Connection con = null;
//        try {
//            con = getConnection();
//            PreparedStatement pstmt = con.prepareStatement("INSERT INTO "
//                    + tableName + " (email,password,firstName,lastName) VALUES (?,?,?,?)");
//
//            pstmt.setString(1, user.getEmail());
//            pstmt.setString(2, user.getPassword());
//            pstmt.setString(3, user.getFirstName());
//            pstmt.setString(4, user.getLastName());
//            int count = pstmt.executeUpdate();
//            if (count != 1)
//                throw new SQLException("Insert updated " + count + " rows");
//
//            pstmt.close();
//            releaseConnection(con);
//
//        } catch (Exception e) {
//            try {
//                if (con != null)
//                    con.close();
//            } catch (SQLException e2) { /* ignore */
//            }
//            throw new MyDAOException(e);
//        }
//    }
//    
//    public UserBean read(String email) throws MyDAOException {
//        Connection con = null;
//        try {
//            con = getConnection();
//
//            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "
//                    + tableName + " WHERE email=?");
//            pstmt.setString(1, email);
//            ResultSet rs = pstmt.executeQuery();
//
//            UserBean user;
//            if (!rs.next()) {
//                user = null;
//            } else {
//                user = new UserBean();
//                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("password"));
//                user.setFirstName(rs.getString("firstName"));
//                user.setLastName(rs.getString("lastName"));
//            }
//
//            rs.close();
//            pstmt.close();
//            releaseConnection(con);
//            return user;
//
//        } catch (Exception e) {
//            try {
//                if (con != null)
//                    con.close();
//            } catch (SQLException e2) { /* ignore */
//            }
//            throw new MyDAOException(e);
//        }
//    }
//    
//    private boolean tableExists() throws MyDAOException {
//        Connection con = null;
//        try {
//            con = getConnection();
//            DatabaseMetaData metaData = con.getMetaData();
//            ResultSet rs = metaData.getTables(null, null, tableName, null);
//
//            boolean answer = rs.next();
//
//            rs.close();
//            releaseConnection(con);
//
//            return answer;
//
//        } catch (SQLException e) {
//            try {
//                if (con != null)
//                    con.close();
//            } catch (SQLException e2) { /* ignore */
//            }
//            throw new MyDAOException(e);
//        }
//    }
//    
//    private synchronized void releaseConnection(Connection con) {
//        connectionPool.add(con);
//    }
//    
//    private synchronized Connection getConnection() throws MyDAOException {
//        if (connectionPool.size() > 0) {
//            return connectionPool.remove(connectionPool.size() - 1);
//        }
//
//        try {
//            Class.forName(jdbcDriver);
//        } catch (ClassNotFoundException e) {
//            throw new MyDAOException(e);
//        }
//
//        try {
//            return DriverManager.getConnection(jdbcURL);
//        } catch (SQLException e) {
//            throw new MyDAOException(e);
//        }
//    }
//    
//    private void createTable() throws MyDAOException {
//        Connection con = null;
//        try {
//            con = getConnection();
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("CREATE TABLE "
//                    + tableName
//                    + " (email VARCHAR(255) NOT NULL, password VARCHAR(255), firstName VARCHAR(255), lastName VARCHAR(255), PRIMARY KEY(email))");
//            stmt.close();
//
//            releaseConnection(con);
//
//        } catch (SQLException e) {
//            try {
//                if (con != null)
//                    con.close();
//            } catch (SQLException e2) { /* ignore */
//            }
//            throw new MyDAOException(e);
//        }
//    }
//}
