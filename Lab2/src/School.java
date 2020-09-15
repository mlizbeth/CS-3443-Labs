import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Madeline Kotara - duk128
 * School.java
 * Creates a school object with an array of zones. Each zone additionally contains every student in that zone
 * 
 */
public class School {
	
	//instance variables
	private final String SPLIT = ",";
	private String schoolName;
	private List<Zone> zones = new ArrayList<Zone>();

	
	//constructor with REQUIRED fields, creates an array with the integer passed to the object, as that size
	
	public School(String schoolName) {
		this.schoolName = schoolName;
	}
	
	//getters and setters
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void loadZones(String filePath) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		while((line = reader.readLine()) != null) {
			String[] data = line.split(SPLIT);
			zones.add(new Zone(data[0], data[1], data[2]));
		}
		//zones.forEach((e) -> System.out.println(e));
		reader.close();
	}
	
	//load student, add to appropriate zone based on zone code
	
	public void loadStudents(String filePath) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		while((line = reader.readLine()) != null) {
			String[] data = line.split(SPLIT);
			Student temp = new Student(data[0], data[1], Boolean.parseBoolean(data[2]), data[3]);
			for(int x = 0; x < zones.size(); x++) {
				if(temp.getZoneCode().equals(zones.get(x).getZoneCode())) {
					zones.get(x).addStudent(temp);
				}
			}
		}
		reader.close();
	}
	
	public void relocate(String student, String zoneCode) {
		
		//TODO

	}
	
	public void save() {
		
		//TODO
		
	}
	
	public String toString() {
		String schoolInfo = "Welcome to " + schoolName + "!" + "\n" + "-------------------------" + "\n";
		String temp = "";
		for(int x = 0; x < zones.size(); x++) {
			temp += zones.get(x) + "\n";
		}
		return schoolInfo + temp;
	}
}
