/*
 * Madeline Kotara - duk128
 * Student.java
 * Creates a student object with instance data for their name, grade level, and if they are vegetarian
 * returns a string representation of the student data
 */
public class Student {
	
	//instance variables
	
	private String name, level, zoneCode;
	private boolean isVegetarian;
	
	//constructor, creates a student object with the REQUIRED data
	
	public Student(String name, String level, boolean isVegetarian, String zoneCode) {
		this.name = name;
		this.level = level;
		this.isVegetarian = isVegetarian;
		this.zoneCode = zoneCode;
	}
	
	//getters and setters, for reading and writing instance data
	//without needing to access the variable directly
	
	public Student() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public boolean isVegetarian() {
		return isVegetarian;
	}
	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}
	public String getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	
	//returns a string of the student, users boolean expression to determine
	//which output should be used based on if they are vegetarian, from the variable isVegetarian
	
	@Override
	public String toString() {
		if(isVegetarian) {
			return "*" + name + " - " + level + " -" + " (veg) ";
		}
		else {
			return "*" + name + " - " + level + " -" + " (non-veg) ";
		}
	}
	
}
