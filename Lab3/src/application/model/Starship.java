package application.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a Starship which has a name, registry, classification, and an ArrayList of CrewMembers
 * @author Madeline Kotara - duk128
 * @version 1.0
 * @since 10-15-2020
 *
 */

public class Starship {
	
	private String name, registry, classification;
	private List<CrewMember> crewMembers = new ArrayList<CrewMember>();
	
	/**
	 * 
	 * @param name String containing ship name
	 * @param registry String containing ship's code
	 * @param classification String containing the ship classification
	 */
	
	public Starship(String name, String registry, String classification) {
		this.name = name;
		this.registry = registry;
		this.classification = classification;
	}
	
	/**
	 * 
	 * @return String containing Starship name
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name Sets the name of the Starship
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return String containing Starship code
	 */

	public String getRegistry() {
		return registry;
	}
	
	/**
	 * 
	 * @param registry Sets the code of the Starship
	 */

	public void setRegistry(String registry) {
		this.registry = registry;
	}
	
	/**
	 * 
	 * @return String containing Starship class
	 */

	public String getClassification() {
		return classification;
	}
	
	/**
	 * 
	 * @param classification sets the Starship classification
	 */

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	/**
	 * 
	 * @return List all CrewMembers on a Starship
	 */

	public List<CrewMember> getCrewMembers() {
		return crewMembers;
	}
	
	/**
	 * 
	 * @param crewMembers Sets the CrewMembers on a ship
	 */

	public void setCrewMembers(List<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}
	
	/**
	 * 
	 * @param crewmember adds a CrewMember to a ship
	 */
	
	public void addCrewMember(CrewMember crewmember) {
		crewMembers.add(crewmember);
	}
	
	public String toString() {
		String temp = name + " " + "[" + registry + "]" + ", " + "Class: " + classification + ", " + "Crew: " + crewMembers.size() + "\n";
		for(CrewMember x : crewMembers) {
			temp += " - " + x.toString() + "\n";
		}
		return temp;
	}

}
