package application.model;

import java.io.File;

public class CrewMember {
	
	private String name, position, rank, species, currentShip;
	private File picture;
	

	public CrewMember(String name, String position, String rank, String currentShip, String species) {
		this.name = name;
		this.position = position;
		this.rank = rank;
		this.currentShip = currentShip;
		this.species = species;
	}
	
	public String getLastName() {
		return name.substring(name.lastIndexOf(" ") + 1);
	}
	
	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}

	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCurrentShip() {
		return currentShip;
	}

	public void setCurrentShip(String currentShip) {
		this.currentShip = currentShip;
	}
	
	public String toString() {
		return rank + " " + name + ", " + position + " " + "(" + species + ")";
	}

}
