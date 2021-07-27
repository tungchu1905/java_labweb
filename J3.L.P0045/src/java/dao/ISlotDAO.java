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

import entity.Slot;
import java.util.List;

/**
 * The interface of SlotDAO defines method to get information from Slot
 * table in database.
 *
 * @author TungCTHE141487
 */
public interface ISlotDAO {
    /**
     * Get all list element of <code>Slot</code> object <br>
     *
     * @return all list element of <code>Slot</code> object
     * @throws Exception
     */
   public List<Slot> getAllSlot() throws Exception;
}
