package TimeTableGA;

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
    private final String time;
    
    public TimeSlot(int timeSlotID,String timeSlot)
    {
    this.timeSlotID =timeSlotID;
    this.time = timeSlot;
    }

    public int getTimeSlotID() {
        return timeSlotID;
    }

    public String getTimeSlot() {
        return time;
    }
    
    
    
}
