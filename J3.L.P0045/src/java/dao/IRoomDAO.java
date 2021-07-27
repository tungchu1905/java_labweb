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

import entity.Room;
import java.util.List;

/**
 * The interface of RoomDAO defines method to get information from Room table in
 * database.
 *
 * @author TungCTHE141487
 */
public interface IRoomDAO {

    /**
     * Get all the distinct room name of <code>Timetable</code> object
     *
     * @return the list distinct room name of <code>Timetable</code>
     * @throws Exception
     */
    public List<Room> getRoomName() throws Exception;
}
