package application.model;

public class Dinosaur {
	
	private String name, type;
	private boolean isCarnivorous;
	
	public Dinosaur(String name, String type, boolean isCarnivorous) {
		this.name = name;
		this.type = type;
		this.isCarnivorous = isCarnivorous;
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

	public boolean isCarnivorous() {
		return isCarnivorous;
	}

	public void setCarnivorous(boolean isCarnivorous) {
		this.isCarnivorous = isCarnivorous;
	}

	public String toString() {
		if(isCarnivorous) {
			return name + " - " + type + " -" + " Carnivore ";
		}
		else {
			return name + " - " + type + " -" + " Non-Carnivore ";
		}
	}
	

}
