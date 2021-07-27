/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE           Version           AUTHOR              DESCRIPTION
 * 2021-06-20     1.0              TungCTHE141487      First Implement
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This class has methods to get connection to database and close connection,
 * prepare statement, result set after using
 *
 * @author TungCTHE141487
 */
public class DBContext {

    /**
     * Create attribute
     */
    private static InitialContext initial;
    private static Context context;
    private static String dbName;
    private static String serverName;
    private static String portNumber;
    private static String image;
    private static String userName;
    private static String password;

    /**
     * Contains information to create the connection to database
     */
    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbName = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            image = context.lookup("image").toString();
            userName = context.lookup("username").toString();
            password = context.lookup("password").toString();
        } catch (NamingException e) {

        }

    }

    /**
     * Represent the connection, support the other class get connection to the
     * database
     *
     * @return connection of database
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userName, password);
    }

    /**
     * Close ResultSet method
     *
     * @param rs is the ResultSet
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * Close PrepareStatement method
     *
     * @param ps is the PreparedStatement
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement ps) throws SQLException {

        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * Close Connection method
     *
     * @param con is the Connection
     * @throws SQLException
     */
    public void closeConnection(Connection con) throws SQLException {

        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * link to an image path
     *
     * @return image path, it is a string
     * @throws Exception
     */
    public String getImagePath() throws Exception {
        return image;
    }
}
