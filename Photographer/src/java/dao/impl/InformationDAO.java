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
import dao.IInformationDAO;
import entity.Information;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from IInformationDAO contains methods to get information
 * from Information table in database.
 *
 * @author TungCTHE141487
 */
public class InformationDAO extends DBContext implements IInformationDAO {

    /**
     * Get the content about information of Management in Information object
     *
     * @return the information of Information object
     * @throws java.lang.Exception
     */
    @Override
    public Information getInformation() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Information";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Information info = new Information(rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("country"),
                        rs.getString("tel"),
                        rs.getString("email"),
                        getImagePath() + rs.getString("image"));

                return info;
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(InformationDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

}
