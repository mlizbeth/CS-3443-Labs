/*
 * Madeline Kotara - duk128
 * Student.java
 * Creates a student object with instance data for their name, grade level, and if they are vegetarian
 * returns a string representation of the student data
 */
public class Student {
	
	//instance variables
	
	private String name;
	private String level;
	private boolean isVegetarian;
	
	//constructor, creates a student object with the REQUIRED data
	
	public Student(String name, String level, boolean isVegetarian) {
		this.name = name;
		this.level = level;
		this.isVegetarian = isVegetarian;
	}
	
	//getters and setters, for reading and writing instance data
	//without needing to access the variable directly
	
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
	
	//returns a string of the student, users boolean expression to determine
	//which output should be used based on if they are vegetarian, from the variable isVegetarian
	
	@Override
	public String toString() {
		if(isVegetarian) {
			return name + " - " + level + " (veg) ";
		}
		else {
			return name + " - " + level + " (non-veg) ";
		}
	}
	
}
