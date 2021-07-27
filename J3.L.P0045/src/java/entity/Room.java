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
 * The class object of Room, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class Room {

    /**
     * Information of roomId
     */
    private int roomId;
    /**
     * Information of roomName
     */
    private String roomName;

    /**
     * Constructor without parameter
     */
    public Room() {
    }

    /**
     * Class constructor specifying roomId, roomName of <code>Class</code>
     * object
     *
     * @param roomId the roomId of <code>Room</code> object, it is an int
     * @param roomName the roomName of <code>Room</code> object, it is a string
     */
    public Room(int roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    /**
     * Get value of roomId attribute of <code>Room</code> object
     *
     * @return roomId of <code>Room</code> object it is an int
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Set value of roomId attribute of <code>Room</code> object
     *
     * @param roomId is the roomId of <code>Room</code>, it is an int
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * Get value of roomName attribute of <code>Room</code> object
     *
     * @return roomName of <code>Room</code> object it is a string
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Set value of roomName attribute of <code>Room</code> object
     *
     * @param roomName is the roomName of <code>Room</code>, it is a string
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
