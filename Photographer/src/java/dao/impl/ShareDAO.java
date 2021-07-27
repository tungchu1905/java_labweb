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
import dao.IShareDAO;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from IShareDAO contains method to get information from
 * Share table in database.
 *
 * @author TungCTHE141487
 */
public class ShareDAO extends DBContext implements IShareDAO {

    /**
     * Get list information of Share object <br>
     * All the information of share object will card listed returned the result
     * contain a list of <code> entity.Share </code> objects with icon,
     * socialNetwork, url
     *
     * @return list of Share object, it is a <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Share> getShare() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Share";
        List<Share> list = new ArrayList<>();

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Share sh = new Share(getImagePath() + rs.getString("icon"),
                        rs.getString("social_network"), rs.getString("url"));

                list.add(sh);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ShareDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }

}
