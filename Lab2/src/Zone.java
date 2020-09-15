import java.util.ArrayList;
import java.util.List;

/*
 * Madeline Kotara - duk128
 * Zone.java
 * Creates a Zone object which contains an array of students.
 */

public class Zone {
	
	//instance variables
	
	private String zoneName, zoneCode, safetyRating;
	private List<Student> students = new ArrayList<Student>();
	
	//constructor with required fields, creates an array of size [capacity], which is an int passed in the 
	//object constructor
	
	public Zone(String zoneName, String safetyRating, String zoneCode) {
		this.zoneName = zoneName; 
		this.zoneCode = zoneCode;
		this.safetyRating = safetyRating;
	}
	
	//getters and setters for reading and modifying data
	
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	public String getSafetyRating() {
		return safetyRating;
	}
	public void setSafetyRating(String safetyRating) {
		this.safetyRating = safetyRating;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void removeStudent(Student student) {
		students.remove(student);
	}
	
	public String toString() {
		String temp = "";
		String zoneInfo = zoneCode + ": " + zoneName + " (" + safetyRating + " risk" + ")" + "\n";
		for(int x = 0; x < students.size(); x++) {
			temp += students.get(x) + "\n";
		}
		return zoneInfo + temp;
	}
}
