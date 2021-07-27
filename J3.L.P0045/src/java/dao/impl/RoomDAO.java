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
import dao.IRoomDAO;
import entity.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from IRoomDAO contains method to get information from
 * Room table in database.
 *
 * @author TungCTHE141487
 */
public class RoomDAO extends DBContext implements IRoomDAO {

    /**
     * Get all the distinct room name of <code>Timetable</code> object
     *
     * @return the list distinct room name of <code>Timetable</code>
     * @throws Exception
     */
    @Override
    public List<Room> getRoomName() throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Room> list = new ArrayList<>();
        String s = "  select * from room";
        try {
            con = getConnection();
            ps = con.prepareStatement(s);
            rs = ps.executeQuery();
            while (rs.next()) {
                Room d = new Room(
                        rs.getInt("roomid"),
                        rs.getString("roomName"));
                list.add(d);
            }
        } catch (Exception e) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, e);
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
