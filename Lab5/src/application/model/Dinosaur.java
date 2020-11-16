package application.model;

public class Dinosaur {
	
	private String name, type;
	private boolean isNotCarnivorous;
	
	public Dinosaur(String name, String type, boolean isNotCarnivorous) {
		this.name = name;
		this.type = type;
		this.isNotCarnivorous = isNotCarnivorous;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isNotCarnivorous() {
		return isNotCarnivorous;
	}

	public void setCarnivorous(boolean isNotCarnivorous) {
		this.isNotCarnivorous = isNotCarnivorous;
	}

	public String toString() {
		if(!isNotCarnivorous) {
			return name + " - " + type + " -" + " Carnivore ";
		}
		else {
			return name + " - " + type + " -" + " Non-Carnivore ";
		}
	}
}
