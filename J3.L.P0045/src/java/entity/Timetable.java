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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The class object of Timetable, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class Timetable {

    /**
     * Information of date
     */
    private Date date;
    /**
     * Information of slot
     */
    private int slot;
    /**
     * Information of time
     */
    private String time;
    /**
     * Information of classes
     */
    private String classes;
    /**
     * Information of teacher
     */
    private String teacher;
    /**
     * Information of room
     */
    private String room;

    /**
     * Class constructor specifying date, slot, time, classes,teacher, room of
     * Timetable object
     *
     * @param date the date of Timetable object, it is an
     * <code>java.sql.Date</code>
     * @param slot the slot of Timetable object, it is an int
     * @param time the time of Timetable object, it is a string
     * @param classes the classes of Timetable object, it is a string
     * @param teacher the teacher of Timetable object, it is a string
     * @param room the room of Timetable object, it is an int
     */
    public Timetable(Date date, int slot, String time, String classes, String teacher, String room) {

        this.date = date;
        this.slot = slot;
        this.time = time;
        this.classes = classes;
        this.teacher = teacher;
        this.room = room;
    }

    /**
     * Constructor of Timetable
     */
    public Timetable() {
    }

    /**
     * Get value of date attribute of <code>Timetable</code> object and format
     * it to day of week with datetime
     *
     * @return date of <code>Timetable</code> object it is an
     * <code>java.sql.Date</code>
     */
    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("E dd-MM-yyyy");
        return formatter.format(date);
    }

    /**
     * Set value of date attribute of <code>Timetable</code> object
     *
     * @param date is the date of <code>Timetable</code>, it is an
     * <code>java.sql.Date</code>
     */
    public void setDate(Date date) {

        this.date = date;
    }

    /**
     * Get value of slot attribute of <code>Timetable</code> object
     *
     * @return slot of <code>Timetable</code> object it is an int
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Set value of slot attribute of <code>Timetable</code> object
     *
     * @param slot is the slot of <code>Timetable</code>, it is an int
     */
    public void setSlot(int slot) {

        this.slot = slot;
    }

    /**
     * Get value of time attribute of <code>Timetable</code> object
     *
     * @return time of <code>Timetable</code> object it is an string
     */
    public String getTime() {
        return time;
    }

    /**
     * Set value of time attribute of <code>Timetable</code> object
     *
     * @param time is the time of <code>Timetable</code>, it is an string
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Get value of classes attribute of <code>Timetable</code> object
     *
     * @return classes of <code>Timetable</code> object it is an string
     */
    public String getClasses() {
        return classes;
    }

    /**
     * Set value of classes attribute of <code>Timetable</code> object
     *
     * @param classes is the classes of <code>Timetable</code>, it is an string
     */
    public void setClasses(String classes) {
        this.classes = classes;
    }

    /**
     * Get value of teacher attribute of <code>Timetable</code> object
     *
     * @return teacher of <code>Timetable</code> object it is an string
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * Set value of teacher attribute of <code>Timetable</code> object
     *
     * @param teacher is the teacher of <code>Timetable</code>, it is an string
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * Get value of room attribute of <code>Timetable</code> object
     *
     * @return room of <code>Timetable</code> object it is an int
     */
    public String getRoom() {
        return room;
    }

    /**
     * Set value of room attribute of <code>Timetable</code> object
     *
     * @param room is the room of <code>Timetable</code>, it is an int
     */
    public void setRoom(String room) {
        this.room = room;
    }

}
