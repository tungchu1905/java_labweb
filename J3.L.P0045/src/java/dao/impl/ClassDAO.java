/*
 * Copyright(C) 2005,  FPT University
 * J3.L.P0045
 * Timetable
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-23    1.0              TungCTHE141487      First Implement
 */
package dao.impl;

import context.DBContext;
import dao.IClassDAO;
import entity.Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from IClassDAO contain methods to get information from
 * Class table in database.
 *
 * @author TungCTHE141487
 */
public class ClassDAO extends DBContext implements IClassDAO {

    /**
     * Get all the distinct class name of <code>Timetable</code> object
     *
     * @return the list distinct class name of <code>Timetable</code>
     * @throws Exception
     */
    @Override
    public List<Classes> getClassName() throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Classes> list = new ArrayList<>();
        String s = "  select * from Class";
        try {
            con = getConnection();
            ps = con.prepareStatement(s);
            rs = ps.executeQuery();
            while (rs.next()) {
                Classes d = new Classes(
                        rs.getInt("classId"),
                        rs.getString("className"));
                list.add(d);
            }
        } catch (Exception e) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // close ResultSet, PrepareStatement, Connection
            closeResultSet(rs);
            closePrepareStateMent(ps);
            closeConnection(con);
        }
        return list;
    }

}
