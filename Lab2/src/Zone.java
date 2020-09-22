import java.util.ArrayList;
import java.util.List;

/**
 * Creates a Zone object containing an ArrayList of Students. Each Zone contains a Name, Code, and Safety Rating
 * @author Madeline Kotara - duk128
 * @version 2.0
 * @since 9-15-2020
 *
 */

public class Zone {
	
	//instance variables
	
	private String zoneName, zoneCode, safetyRating;
	private List<Student> students = new ArrayList<Student>();
	
	//constructor with required fields, creates an array of size [capacity], which is an int passed in the 
	//object constructor
	
	/**
	 * @param zoneName The name of the zone
	 * @param safetyRating The safety rating of the zone
	 * @param zoneCode The short code of the zone
	 */
	public Zone(String zoneName, String safetyRating, String zoneCode) {
		this.zoneName = zoneName; 
		this.zoneCode = zoneCode;
		this.safetyRating = safetyRating;
	}
	
	//getters and setters for reading and modifying data
	/**
	 * 
	 * @return String containing the name of the zone
	 */
	public String getZoneName() {
		return zoneName;
	}
	/**
	 * @param zoneName Changes/sets the zone's name
	 */
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	/**
	 * @return String containing the short code for the zone
	 */
	public String getZoneCode() {
		return zoneCode;
	}
	/**
	 * @param zoneCode changes/sets the zone's short code
	 */
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	/**
	 * @return String containing the safety rating for the zone
	 */
	public String getSafetyRating() {
		return safetyRating;
	}
	/**
	 * 
	 * @param safetyRating changes/sets the zone's safety rating
	 */
	public void setSafetyRating(String safetyRating) {
		this.safetyRating = safetyRating;
	}
	/**
	 * 
	 * @return A List of Students within the Zone
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * 
	 * @param students adds a list of students to the zone
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	/**
	 * 
	 * @param student adds a single student to the list of students within the zone
	 */
	public void addStudent(Student student) {
		students.add(student);
	}
	
	/**
	 * 
	 * @param student removes a single student from the list of students within the zone
	 */
	public void removeStudent(Student student) {
		students.remove(student);
	}
	
	/**
	 * @return A string representation of each student within each zone.
	 */
	@Override
	public String toString() {
		String temp = "";
		String zoneInfo = zoneCode + ": " + zoneName + " (" + safetyRating + " risk" + ")" + "\n";
		for(int x = 0; x < students.size(); x++) {
			temp += "*" + students.get(x) + "\n";
		}
		return zoneInfo + temp;
	}
}
