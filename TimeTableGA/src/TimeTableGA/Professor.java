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
public class Professor {
    
    private final int  professorID;
    private final String professorName;
    
    
    public Professor(int professorID,String professorName){
    this.professorID = professorID;
    this.professorName = professorName;
    }

    public int getProfessorID() {
        return professorID;
    }

    public String getProfessorName() {
        return professorName;
    }
    
}
