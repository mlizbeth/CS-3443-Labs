/*
 * Madeline Kotara - duk128
 * School.java
 * Creates a school object with an array of zones. Each zone additionally contains every student in that zone
 * 
 */
public class School {
	
	//instance variables
	
	private String schoolName;
	private Zone[] zones;
	
	//constructor with REQUIRED fields, creates an array with the integer passed to the object, as that size
	
	public School(String schoolName, int capacity) {
		this.schoolName = schoolName;
		zones = new Zone[capacity];
	}
	
	//getters and setters
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Zone[] getZones() {
		return zones;
	}

	public void setZones(Zone[] zones) {
		this.zones = zones;
	}
	
	//adds a zone to the Zone array. Since we aren't using a List, we have to manually assign the values.
	//start a loop and check if the element is empty, if it is, add the zone that was passed to it, then end the loop 
	//so we don't copy the data to every index.
	
	public void addZone(Zone zone) {
		for(int x = 0; x < zones.length; x++) {
			if(zones[x] == null) {
				zones[x] = zone;
				break;
			}
		}
	}
	
	//string representation of the school
	//The school contains zones, and the zones contain students, and the students contain there own data.

	@Override
	public String toString() {
		
		String temp = "";
		for(int x = 0; x < zones.length; x++) {
			if(zones[x] == null) {
				break;
			}
			temp += zones[x] + "\n";
		}
		return "Welcome to " + schoolName + "!" + "\n" + "-------------------------" + "\n" + temp;
		
	}

}
