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
import dao.ITimetableDAO;
import entity.Timetable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from ITimetableDAO contains methods to get information
 * from Timetable table in database.
 *
 * @author TungCTHE141487
 */
public class TimetableDAO extends DBContext implements ITimetableDAO {

    /**
     * Get all the timetable element of <code>Timetable</code> object <br>
     * All the element will card listed returned the result contain a list of <code> entity.Timetable
     * </code> objects with date, slot, teacher, classes, room
     *
     * @return all the list of <code>Timetable</code> object
     * @throws Exception
     */
    @Override
    public List<Timetable> getAllTimetable() throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Timetable> list = new ArrayList<>();
        String s = " select date,Slot.slotId as slot, (startTime+' - '+endTime) as Time, class.ClassName,"
                + " teacher, room.RoomName from timetable,Room,Class,Slot where"
                + " timetable.slotId = Slot.SlotId and"
                + " timetable.roomId = Room.RoomId and timetable.classId = Class.ClassId order by date desc";
        try {
            con = getConnection();
            ps = con.prepareStatement(s);
            rs = ps.executeQuery();
            while (rs.next()) {
                Timetable d = new Timetable(rs.getDate("date"),
                        rs.getInt("slot"),
                        rs.getString("Time"),
                        rs.getString("ClassName"),
                        rs.getString("teacher"),
                        rs.getString("RoomName"));
                list.add(d);
            }
        } catch (Exception e) {
            Logger.getLogger(TimetableDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // close ResultSet, PrepareStatement, Connection
            closeResultSet(rs);
            closePrepareStateMent(ps);
            closeConnection(con);
        }
        return list;
    }

    /**
     * Get all the list element has search of <code>Timetable</code> object<br>
     * All the element will card listed returned the result contain a list of <code> entity.Timetable
     * </code> objects with date, slot, teacher, classes, room
     *
     * @param from is the date of <code>Timetable</code> object
     * @param to is the date of <code>Timetable</code> object
     * @return all the list has search of <code>Timetable</code> object
     * @throws Exception
     */
    @Override
    public List<Timetable> getListSearch(String from, String to) throws Exception {
        String squery = "     select date,Slot.slotId as slot, (startTime+' - '+endTime) as Time, class.ClassName, teacher, room.RoomName "
                + "from timetable,Room,Class,Slot where [timetable].slotId = Slot.SlotId and"
                + " timetable.roomId = Room.RoomId and timetable.classId = Class.ClassId "
                + "and Date between (?) and (?) order by date desc";
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Timetable> list = new ArrayList<>();
        try {
            con = getConnection();
            ps = con.prepareStatement(squery);
            ps.setString(1, from);
            ps.setString(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                Timetable d = new Timetable(rs.getDate("date"),
                        rs.getInt("slot"),
                        rs.getString("time"),
                        rs.getString("className"),
                        rs.getString("teacher"),
                        rs.getString("roomName"));
                list.add(d);
            }
        } catch (Exception e) {
            Logger.getLogger(TimetableDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // close ResultSet, PrepareStatement, Connection
            closeResultSet(rs);
            closePrepareStateMent(ps);
            closeConnection(con);
        }
        return list;
    }

    /**
     * Add the all the element of Timetable to database
     *
     * @param date the date of Timetable object, it is an
     * <code>java.sql.Date</code>
     * @param slot the slot of Timetable object, it is an int
     * @param classes the classes of Timetable object, it is a string
     * @param teacher the teacher of Timetable object, it is a string
     * @param room the room of Timetable object, it is a string
     * @throws Exception
     */
    @Override
    public void addTimetable(String date, String slot, String classes, String teacher, String room) throws Exception {
        String s = "insert into Timetable "
                + "values(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(s);
            ps.setString(1, date);
            ps.setString(2, slot);
            ps.setString(3, room);
            ps.setString(4, teacher);
            ps.setString(5, classes);
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(TimetableDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // close ResultSet, PrepareStatement, Connection
            closePrepareStateMent(ps);
            closeConnection(con);
        }
    }

    /**
     * Function to check Timetable exist before add
     *
     * @param date the date of Timetable object, it is an
     * <code>java.sql.Date</code>
     * @param classes the slot of Timetable object, it is an int
     * @param room the room of Timetable object, it is a string
     * @return object of Timetable or null when check exist timetable
     * @throws Exception
     */
    @Override
    public Timetable checkExistRoomTimeTable(String date, String classes, String room) throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = "  select date,Slot.slotId as slot, (startTime+'- '+endTime) as Time, class.ClassName, teacher, room.RoomName "
                    + "from timetable,Room,Class,Slot where [timetable].slotId = Slot.SlotId "
                    + "and timetable.roomId = Room.RoomId and timetable.classId = Class.ClassId "
                    + "and date = ? and class.classid = ? and room.roomid =?";
            con = getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setString(2, classes);
            ps.setString(3, room);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Timetable(rs.getDate("date"),
                        rs.getInt("slot"),
                        rs.getString("time"),
                        rs.getString("className"),
                        rs.getString("teacher"),
                        rs.getString("roomName"));
            }
        } catch (Exception e) {
            Logger.getLogger(TimetableDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // close ResultSet, PrepareStatement, Connection
            closeResultSet(rs);
            closePrepareStateMent(ps);
            closeConnection(con);
        }
        return null;
    }

    /**
     * Paginate by number of timetable in <code>Timetable</code> object <br>
     * All the element will card listed returned the result contain a list of
     * <code>entity.Timetable</code> objects with date, slot, teacher, classes,
     * room
     *
     * @param pageIndex the index of page, it is an <code>int</code>
     * @param pageSize the size of page, it is an <code>int</code>
     * @return list of timetable, it is a <code>java.util.List</code> object.
     * @throws java.lang.Exception
     */
    @Override
    public List<Timetable> pagging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Timetable> list = new ArrayList<>();
        //get value between start to end
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;
        String sql = "  select  date,Slot.slotId as slot, (startTime+'- '+endTime) as Time, class.ClassName, teacher, room.RoomName from (select ROW_NUMBER() over (order by date DESC) as No,\n"
                + "                * from [timetable])as x, Slot,Room,Class where x.slotId = Slot.SlotId and x.roomId = Room.RoomId and x.classId = Class.ClassId and No between ? and ? ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                Timetable timetable = new Timetable(rs.getDate("date"),
                        rs.getInt("slot"),
                        rs.getString("time"),
                        rs.getString("className"),
                        rs.getString("teacher"),
                        rs.getString("roomName"));
                list.add(timetable);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(TimetableDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            //Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePrepareStateMent(ps);
            closeConnection(conn);
        }

    }

    /**
     * Get number of result <code>Gallery</code> object by id
     *
     * @return number result of Gallery object, it is an int
     * @throws Exception
     */
    @Override
    public int numberOfResult() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "  Select count(id) from [timetable]";
        int count = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(TimetableDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePrepareStateMent(ps);
            closeConnection(conn);
        }
        return count;
    }

    /**
     * Function to check Timetable exist before add
     *
     * @param date the date of Timetable object, it is an
     * <code>java.sql.Date</code>
     * @param classes the slot of Timetable object, it is an int
     * @param teacher the teacher of Timetable object, it is a string
     * @return object of Timetable or null when check exist timetable
     * @throws Exception
     */
    @Override
    public Timetable checkExistTeacherTimeTable(String date, String classes, String teacher) throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String query = "  select date,Slot.slotId as slot, (startTime+'- '+endTime) as Time, class.ClassName, teacher, room.RoomName "
                    + "from timetable,Room,Class,Slot where [timetable].slotId = Slot.SlotId "
                    + "and timetable.roomId = Room.RoomId and timetable.classId = Class.ClassId "
                    + "and date = ? and class.classid = ? and teacher =?";
            con = getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setString(2, classes);
            ps.setString(3, teacher);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Timetable(rs.getDate("date"),
                        rs.getInt("slot"),
                        rs.getString("time"),
                        rs.getString("className"),
                        rs.getString("teacher"),
                        rs.getString("roomName"));
            }
        } catch (Exception e) {
            Logger.getLogger(TimetableDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // close ResultSet, PrepareStatement, Connection
            closeResultSet(rs);
            closePrepareStateMent(ps);
            closeConnection(con);
        }
        return null;

    }

}
