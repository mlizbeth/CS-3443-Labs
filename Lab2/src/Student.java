/**
 * Creates a student object with instance data for their name, grade level, if they are vegetarian, and the code of the zone they are currently in.
 * returns a string representation of the student data
 * @author Madeline Kotara - duk128
 * @version 2.0
 * @since 9-15-2020
 */
public class Student {
	
	//instance variables
	
	private String name, level, zoneCode;
	private boolean isVegetarian;
	
	//constructor, creates a student object with the REQUIRED data
	
	/**
	 * @param name The studen't name
	 * @param level The student's grade level
	 * @param isVegetarian Is the student a vegetarian 
	 * @param zoneCode The code of the zone the student is in
	 */
	public Student(String name, String level, boolean isVegetarian, String zoneCode) {
		this.name = name;
		this.level = level;
		this.isVegetarian = isVegetarian;
		this.zoneCode = zoneCode;
	}
	
	//getters and setters, for reading and writing instance data
	//without needing to access the variable directly
	
	public Student() {}
	
	/**
	 * @return String representing student's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name string for the student's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return String representing student's grade level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level student's grade level
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * @return boolean representing if they are vegetarian 
	 */
	public boolean isVegetarian() {
		return isVegetarian;
	}
	/**
	 * @param isVegetarian boolean representing if student is vegetarian 
	 */
	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}
	/**
	 * @return String code for the zone the student is in
	 */
	public String getZoneCode() {
		return zoneCode;
	}
	/**
	 * @param zoneCode the code of the zone the student is in
	 */
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	
	//returns a string of the student, users boolean expression to determine
	//which output should be used based on if they are vegetarian, from the variable isVegetarian
	

	/**
	 * @return String representation of the student object
	 */
	@Override
	public String toString() {
		if(isVegetarian) {
			return name + " - " + level + " -" + " (veg) ";
		}
		else {
			return name + " - " + level + " -" + " (non-veg) ";
		}
	}
	
}
