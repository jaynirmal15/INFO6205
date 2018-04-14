/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

/**
 *
 * @author Jay
 */
public class Class {

    private final int classID;
    private final int groudID;
    private final int moduleID;
    private int professorID;
    private int timeSlotID;
    private int roomID;

    public Class(int classID, int groudID, int moduleID) {
        this.classID = classID;
        this.groudID = groudID;
        this.moduleID = moduleID;
    }

    private void addProfessor(int professorID) {
        this.professorID = professorID;
    }
    private void addRoomID(int roomID) {
        this.roomID = roomID;
    }
    private void addTimeSlotID(int timeSlotID) {
        this.timeSlotID = timeSlotID;
    }

    public int getClassID() {
        return classID;
    }

    public int getGroudID() {
        return groudID;
    }

    public int getModuleID() {
        return moduleID;
    }
    
    
    

}
