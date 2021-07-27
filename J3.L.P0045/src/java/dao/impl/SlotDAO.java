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
import dao.ISlotDAO;
import entity.Slot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from ISlotDAO contain methods to get information from
 * Slot table in database.
 *
 * @author TungCTHE141487
 */
public class SlotDAO extends DBContext implements ISlotDAO {

    /**
     * Get all list element of <code>Slot</code> object <br>
     * All the element will card listed returned the result contain a list of <code> entity.Gallery
     * </code> objects with slot, time
     *
     * @return all list element of <code>Slot</code> object
     * @throws Exception
     */
    @Override
    public List<Slot> getAllSlot() throws Exception {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Slot> list = new ArrayList<>();
        String s = "  select slotid as slot, (startTime+'-'+endTime) as Time "
                + " from Slot";
        try {
            con = getConnection();
            ps = con.prepareStatement(s);
            rs = ps.executeQuery();
            while (rs.next()) {
                Slot slot = new Slot(
                        rs.getInt("slot"),
                        rs.getString("time"));
                list.add(slot);
            }
        } catch (Exception e) {
            Logger.getLogger(SlotDAO.class.getName()).log(Level.SEVERE, null, e);
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
