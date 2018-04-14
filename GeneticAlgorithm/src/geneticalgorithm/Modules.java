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
public class Modules {
    private final int moduleID;
    private final String moduleCode;
    private final String moduleName;
    private final int professorIDs[];
    
    public Modules(int moduleID,String moduleCode,String moduleName,int professorIDs[]){
    this.moduleCode = moduleCode;
    this.moduleID = moduleID;
    this.moduleName =moduleName;
    this.professorIDs = professorIDs;
    }
    
    
    
    
}
