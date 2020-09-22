import java.io.IOException;

/**
 * Test class for logic/implementation. Loads zone and students into the School object.
 * Moves a student to a new zone and reflects that change in students.csv
 * @author Madeline Kotara - duk128
 * @version 2.0
 * @since 9-15-2020
 *
 */

public class Lab2 {
	
	public static void main(String[] args) {
		
		School m = new School("Monroe_May_Elemn_School");

		try {
			
			m.loadZones("data/zones.csv");
			m.loadStudents("data/students.csv");
			
			System.out.println(m);
			
			m.relocate("Blue", "TY");
			m.save();
			
			System.out.println(m);
			
		} catch(IOException e) {
			System.out.println("Error loading the file - please check its location.");
			e.printStackTrace();
		}
	}
}
