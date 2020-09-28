import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates a school object with a List of Zones. Each Zone contains a list of Students.
 * Additionally contains methods to load all the appropriate zones from a file, as well as all of the students in each zone from a file.
 * Can move students from one zone to another and write the changes to disk.
 * @author Madeline Kotara - duk128
 * @version 2.0
 * @since 9-15-2020
 */
public class School {
	
	//instance variables
	private final String SPLIT = ",";
	private String schoolName;
	private List<Zone> zones = new ArrayList<Zone>();
	private Student temp = new Student();
	private final String DELIMITER = ",";

	
	//constructor with REQUIRED fields, creates an array with the integer passed to the object, as that size
	
	/**
	 * @param schoolName Sets the name of the school
	 */
	public School(String schoolName) {
		this.schoolName = schoolName;
	}
	
	//getters and setters
	
	/**
	 * 
	 * @return String containing the name of the school
	 */
	public String getSchoolName() {
		return schoolName;
	}
	
	/**
	 * 
	 * @param schoolName changes/sets the school's name
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	
	/**
	 * Creates a zone by reading the contents of a file from disk. Uses data from
	 * each column to create a zone object and then adds the new zone object to the List of Zones.
	 * repeats until end of file is reached.
	 * @param filePath Requires the string path of the file on disk
	 * @throws IOException throws an exception if the path is invalid, or the file was not found
	 */
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
	
	/**
	 * Creates the appropriate list of students within the appropriate Zone. Uses data from
	 * each column to create a student, then matches the student's zone code with the zone's actual code and adds
	 * the student to that Array. Repeats until end of file is reached.
	 * @param filePath Requires the string path of the file on disk
	 * @throws IOException throws an exception if the path is invalid, or the file was not found
	 */
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
	
	/**
	 * @param student The student object to be moved
	 * @param zoneCode The zoneCode that the student should be moved to
	 */
	public void relocate(String student, String zoneCode) {		
		for(int zCounter = 0; zCounter < zones.size(); zCounter++) {
			for(int sCounter = 0; sCounter < zones.get(zCounter).getStudents().size(); sCounter++) {
				if(zones.get(zCounter).getStudents().get(sCounter).getName().equals(student)) {
					temp = zones.get(zCounter).getStudents().get(sCounter);
					zones.get(zCounter).removeStudent(temp);
					temp.setZoneCode(zoneCode);
				}
			}
		}
		
		for(int zCounter = 0; zCounter < zones.size(); zCounter++) {
			if(zones.get(zCounter).getZoneCode().equals(zoneCode)) {
				zones.get(zCounter).addStudent(temp);
			}
		}
	}
	
	/**
	 * Deletes the original students.csv and creates a new students.csv with updated zone codes for each student
	 * @throws IOException throws an exception if the file cannot be deleted or written
	 */
	public void save() throws IOException {

		try {
			Files.deleteIfExists(Paths.get("data/students.csv"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/students.csv", true));
		for(int zCounter = 0; zCounter < zones.size(); zCounter++) {
			for(int sCounter = 0; sCounter < zones.get(zCounter).getStudents().size(); sCounter++) {
				bw.write(zones.get(zCounter).getStudents().get(sCounter).getName() + DELIMITER);
				bw.write(zones.get(zCounter).getStudents().get(sCounter).getLevel() + DELIMITER);
				bw.write(String.valueOf(zones.get(zCounter).getStudents().get(sCounter).isVegetarian()) + DELIMITER);
				bw.write(zones.get(zCounter).getStudents().get(sCounter).getZoneCode() + DELIMITER);
				bw.newLine();
				bw.flush();
			}
		}
		bw.close();
	}
	
	/**
	 * @return String representation of the Zone's contained within the school, and the student's contained within those zones.
	 */
	@Override
	public String toString() {
		String schoolInfo = "Welcome to " + schoolName + "!" + "\n" + "-------------------------" + "\n";
		String temp = "";
		for(int x = 0; x < zones.size(); x++) {
			temp += zones.get(x) + "\n";
		}
		return schoolInfo + temp;
	}
}
