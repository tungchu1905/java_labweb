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
import dao.IIntroductionDAO;
import entity.Introduction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from IIntroductionDAO contains method to get information
 * from Introduction table in database.
 *
 * @author TungCTHE141487
 */
public class IntroductionDAO extends DBContext implements IIntroductionDAO {

    /**
     * Get all information of Introduction object
     *
     * @return the introduction of Information object
     * @throws java.lang.Exception
     */
    @Override
    public Introduction getIntroduction() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Intro";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Introduction intro = new Introduction(getImagePath() + rs.getString("image"),
                        rs.getString("entry"),
                        rs.getString("aboutme"));
                return intro;
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
