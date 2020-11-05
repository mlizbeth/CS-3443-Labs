package application.model;

import java.util.ArrayList;
import java.util.List;

public class Starship {
	
	private String name, registry, classification;
	private List<CrewMember> crewMembers = new ArrayList<CrewMember>();
	
	public Starship(String name, String registry, String classification) {
		this.name = name;
		this.registry = registry;
		this.classification = classification;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getRegistry() {
		return registry;
	}
	
	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public List<CrewMember> getCrewMembers() {
		return crewMembers;
	}

	public void setCrewMembers(List<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}

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
