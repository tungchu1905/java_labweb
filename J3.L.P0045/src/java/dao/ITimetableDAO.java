/*
 * Copyright(C) 2005,  FPT University
 * J3.L.P0045
 * Timetable
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-23    1.0              TungCTHE141487      First Implement
 */
package dao;

import entity.Timetable;
import java.util.List;

/**
 * The interface of TimetableDAO defines methods to get information from
 * Timetable table in database.
 *
 * @author TungCTHE141487
 */
public interface ITimetableDAO {

    /**
     * Get all the timetable element of <code>Timetable</code> object <br>
     *
     * @return all the list of <code>Timetable</code> object
     * @throws Exception
     */
    public List<Timetable> getAllTimetable() throws Exception;

    /**
     * Get all the list element has search of <code>Timetable</code> object<br>
     *
     * @param from is the date of <code>Timetable</code> object
     * @param to is the date of <code>Timetable</code> object
     * @return all the list has search of <code>Timetable</code> object
     * @throws Exception
     */
    public List<Timetable> getListSearch(String from, String to) throws Exception;

    /**
     * Add the all the element of Timetable to database
     *
     * @param date the date of Timetable object, it is an
     * <code>java.sql.Date</code>
     * @param slot the slot of Timetable object, it is an int
     * @param classes the classes of Timetable object, it is a string
     * @param teacher the teacher of Timetable object, it is a string
     * @param room the room of Timetable object, it is an int
     * @throws Exception
     */
    public void addTimetable(String date, String slot, String room, String teacher, String classes) throws Exception;

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
    public Timetable checkExistRoomTimeTable(String date, String classes, String room) throws Exception;

    /**
     * Paginate by number of timetable in <code>Timetable</code> object <br>
     *
     * @param pageIndex the index of page, it is an <code>int</code>
     * @param pageSize the size of page, it is an <code>int</code>
     * @return list of timetable, it is a <code>java.util.List</code> object.
     * @throws java.lang.Exception
     */
    public List<Timetable> pagging(int pageIndex, int pageSize) throws Exception;

    /**
     * Get number of result <code>Gallery</code> object by id
     *
     * @return number result of Gallery object, it is an int
     * @throws java.lang.Exception
     */
    public int numberOfResult() throws Exception;

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
    public Timetable checkExistTeacherTimeTable(String date, String classes, String teacher) throws Exception;

}
