/*
 * Madeline Kotara - duk128
 * Zone.java
 * Creates a Zone object which contains an array of students.
 */

public class Zone {
	
	//instance variables
	
	private String zoneName;
	private Student[] students;
	
	//constructor with required fields, creates an array of size [capacity], which is an int passed in the 
	//object constructor
	
	public Zone(String zoneName, int capacity) {
		this.zoneName = zoneName; 
		students = new Student[capacity];
	}
	
	//getters and setters for reading and mofying data
	
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
	
	//returns a string representation of all the students (and their data) in each zone.
	
	@Override
	public String toString() {
		String temp = "";
		for(int x = 0; x < students.length; x++) {
			if(students[x] == null) {
				break;
			}
			temp += "* " + students[x] + "\n";
		}
		return zoneName + " Zone:" + "\n" + temp;
	}
	
	//adds students to a zone
	//start a loop and check if the element is empty, if it is, add the student that was passed to it, then end the loop 
	//so we don't copy the data to every index.
	
	public void addStudent(Student student) {
		for(int x = 0; x < students.length; x++) {
			if(students[x] == null) {
				students[x] = student;
				break;
			}
		}
	}

}
