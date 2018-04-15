/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTableGA;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jay
 */
public class TimeTable {

    private final HashMap<Integer, Room> rooms;
    private final HashMap<Integer, Professor> professors;
    private final HashMap<Integer, Modules> modules;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, TimeSlot> timeslots;
    private Class classes[];

    private int numClasses = 0;

    public TimeTable() {
        this.rooms = new HashMap<Integer, Room>();
        this.professors = new HashMap<Integer, Professor>();
        this.modules = new HashMap<Integer, Modules>();
        this.groups = new HashMap<Integer, Group>();
        this.timeslots = new HashMap<Integer, TimeSlot>();

    }
    public TimeTable(TimeTable cloneable) {
		this.rooms = cloneable.getRooms();
		this.professors = cloneable.getProfessors();
		this.modules = cloneable.getModules();
		this.groups = cloneable.getGroups();
		this.timeslots = cloneable.getTimeslots();
	}

    public HashMap<Integer, Professor> getProfessors() {
        return professors;
    }

    public HashMap<Integer, Modules> getModules() {
        return modules;
    }

    public HashMap<Integer, Group> getGroups() {
        return groups;
    }

    public HashMap<Integer, TimeSlot> getTimeslots() {
        return timeslots;
    }
    public void addRoom(int roomId, String roomName, int capacity) {
		this.rooms.put(roomId, new Room(roomId, roomName, capacity));
	}
    public void addProfessor(int professorId, String professorName) {
		this.professors.put(professorId, new Professor(professorId, professorName));
	}
    public void addModule(int moduleId, String moduleCode, String module, int professorIds[]) {
		this.modules.put(moduleId, new Modules(moduleId, moduleCode, module, professorIds));
	}
    public void addGroup(int groupId, int groupSize, int moduleIds[]) {
		this.groups.put(groupId, new Group(groupId, groupSize, moduleIds));
		this.numClasses = 0;
	}
    public void addTimeslot(int timeslotId, String timeslot) {
		this.timeslots.put(timeslotId, new TimeSlot(timeslotId, timeslot));
	}
    
    public void createClasses(Individual individual) {
		// Init classes
		Class classes[] = new Class[this.getNumClasses()];

		// Get individual's chromosome
		int chromosome[] = individual.getChromosome();
		int chromosomePos = 0;
		int classIndex = 0;

		for (Group group : this.getGroupsAsArray()) {
			int moduleIds[] = group.getModuleIDs();
			for (int moduleId : moduleIds) {
				classes[classIndex] = new Class(classIndex, group.getGroupID(), moduleId);

				// Add timeslot
				classes[classIndex].addTimeSlotID(chromosome[chromosomePos]);
                                
				chromosomePos++;

				// Add room
				classes[classIndex].addRoomID(chromosome[chromosomePos]);
				chromosomePos++;

				// Add professor
				classes[classIndex].addProfessor(chromosome[chromosomePos]);
				chromosomePos++;

				classIndex++;
			}
		}

		this.classes = classes;
	}
         public Room getRoom(int roomId) {
		if (!this.rooms.containsKey(roomId)) {
			System.out.println("Rooms doesn't contain key " + roomId);
		}
		return (Room) this.rooms.get(roomId);
	}

	public HashMap<Integer, Room> getRooms() {
		return this.rooms;
	}
        public Room getRandomRoom() {
		Object[] roomsArray = this.rooms.values().toArray();
		Room room = (Room) roomsArray[(int) (roomsArray.length * Math.random())];
		return room;
	}
        public Professor getProfessor(int professorId) {
		return (Professor) this.professors.get(professorId);
	}
        public Modules getModule(int moduleId) {
		return (Modules) this.modules.get(moduleId);
	}
        public int[] getGroupModules(int groupId) {
		Group group = (Group) this.groups.get(groupId);
		return group.getModuleIDs();
	}
        public Group getGroup(int groupId) {
		return (Group) this.groups.get(groupId);
	}
        public Group[] getGroupsAsArray() {
		return (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
	}
        public TimeSlot getTimeslot(int timeslotId) {
		return (TimeSlot) this.timeslots.get(timeslotId);
	}
        public TimeSlot getRandomTimeslot() {
		Object[] timeslotArray = this.timeslots.values().toArray();
		TimeSlot timeslot = (TimeSlot) timeslotArray[(int) (timeslotArray.length * Math.random())];
		return timeslot;
	}
        public Class[] getClasses() {
		return this.classes;
	}
        public int getNumClasses() {
		if (this.numClasses > 0) {
			return this.numClasses;
		}

		int numClasses = 0;
		Group groups[] = (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
		for (Group group : groups) {
			numClasses += group.getModuleIDs().length;
		}
		this.numClasses = numClasses;

		return this.numClasses;
	}
        public int calcClashes() {
		int clashes = 0;

		for (Class classA : this.classes) {
			// Check room capacity
			int roomCapacity = this.getRoom(classA.getRoomID()).getCapacity();
			int groupSize = this.getGroup(classA.getGroudID()).getGroupSize();
			
			if (roomCapacity < groupSize) {
				clashes++;
			}

			// Check if room is taken
			for (Class classB : this.classes) {
				if (classA.getRoomID()== classB.getRoomID()&& classA.getTimeSlotID()== classB.getTimeSlotID()
						&& classA.getClassID()!= classB.getClassID()) {
					clashes++;
					break;
				}
			}

			// Check if professor is available
			for (Class classB : this.classes) {
				if (classA.getProfessorID()== classB.getProfessorID()&& classA.getTimeSlotID()== classB.getTimeSlotID()
						&& classA.getClassID()!= classB.getClassID()) {
					clashes++;
					break;
				}
			}
		}

		return clashes;
	}
}
