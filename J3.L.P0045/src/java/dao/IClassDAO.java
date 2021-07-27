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

import entity.Classes;
import java.util.List;

/**
 * The interface of ClassDAO defines method to get information from Class table
 * in database.
 *
 * @author TungCTHE141487
 */
public interface IClassDAO {

    /**
     * Get all the distinct class name of <code>Timetable</code> object
     *
     * @return the list distinct class name of <code>Timetable</code>
     * @throws Exception
     */
    public List<Classes> getClassName() throws Exception;
}
