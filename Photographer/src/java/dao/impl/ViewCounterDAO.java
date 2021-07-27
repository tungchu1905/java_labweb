/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-06-20     1.0              TungCTHE141487      First Implement
 */
package dao.impl;

import context.DBContext;
import dao.IViewsCountDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from IViewsCountDAO contains method to get information
 * from View table in database.
 *
 * @author TungCTHE141487
 */
public class ViewCounterDAO extends DBContext implements IViewsCountDAO {

    /**
     * Get View when user access to Website.<br>
     *
     * @return number of the View had counted, it is an int
     * @throws java.lang.Exception
     */
    @Override
    public int getViewsCount() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [View]";
        int count = 0;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ViewCounterDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Update View when user access to Website.<br>
     *
     * @throws java.lang.Exception
     */
    @Override
    public void updateViewsCount() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE [View]\n"
                + "SET viewed = viewed + 1";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ViewCounterDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement.
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }
}
