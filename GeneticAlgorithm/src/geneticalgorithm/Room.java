package geneticalgorithm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay
 */
public class Room {

    private final int roomID;
    private final String roomNumber;
    private final int capacity;

    public Room(int roomID, String roomNumber, int capacity) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}
