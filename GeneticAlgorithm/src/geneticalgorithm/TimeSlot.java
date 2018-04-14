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
public class TimeSlot {
    private final int timeSlotID;
    private final int timeSlot;
    
    public TimeSlot(int timeSlotID,int timeSlot)
    {
    this.timeSlotID =timeSlotID;
    this.timeSlot = timeSlot;
    }

    public int getTimeSlotID() {
        return timeSlotID;
    }

    public int getTimeSlot() {
        return timeSlot;
    }
    
    
    
}
