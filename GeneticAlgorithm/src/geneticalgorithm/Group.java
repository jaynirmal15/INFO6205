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
public class Group {
    private final int groupID;
    private final int groupSize;
    private final int ModuleIDs[];
    
    
    public Group(int groupID,int groupSize,int ModuleIDs[]){
    this.groupID = groupID;
    this.ModuleIDs = ModuleIDs;
    this.groupSize = groupSize;
    }

    public int getGroupID() {
        return groupID;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public int[] getModuleIDs() {
        return ModuleIDs;
    }
    
    
    
}
