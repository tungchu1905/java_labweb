/*
 * Copyright(C) 2005,  FPT University
 * J3.L.P0045
 * Timetable
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-23    1.0              TungCTHE141487      First Implement
 */
package entity;

/**
 * The class object of Slot, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class Slot {

    /**
     * Information of slot
     */
    private int slot;
    /**
     * Information of time
     */
    private String time;

    /**
     * Constructor without parameter
     */
    public Slot() {
    }

    /**
     * Class constructor specifying slot, time of <code>Slot</code> object
     *  
     * @param slot the slot of <code>Slot</code> object, it is an int
     * @param time the slot of <code>Slot</code> object, it is an string
     */
    public Slot(int slot, String time) {
        this.slot = slot;
        this.time = time;
    }

    /**
     * Get value of slot attribute of <code>Slot</code> object
     *
     * @return slot of <code>Slot</code> object it is an int
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Set value of slot attribute of <code>Slot</code> object
     *
     * @param slot is the slot of <code>Slot</code>, it is an int
     */
    public void setSlot(int slot) {
        this.slot = slot;
    }

    /**
     * Get value of time attribute of <code>Slot</code> object
     *
     * @return time of <code>Slot</code> object it is an string
     */
    public String getTime() {
        return time;
    }

    /**
     * Set value of time attribute of <code>Slot</code> object
     *
     * @param time is the time of <code>Slot</code>, it is an string
     */
    public void setTime(String time) {
        this.time = time;
    }

}
