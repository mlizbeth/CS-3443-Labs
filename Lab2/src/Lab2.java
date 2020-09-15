import java.io.IOException;

public class Lab2 {
	
	public static void main(String[] args) {
		
		School m = new School("Monroe_May_Elemn_School");

		try {
			
			m.loadZones("data/zones.csv");
			m.loadStudents("data/students.csv");
			
			System.out.println(m);
			
			m.relocate("Blue", "TY");
			m.relocate("Echo", "TY");
			//m.relocate("Trudy", "R");
			m.save();
			
			System.out.println(m);
			
		} catch(IOException e) {
			System.out.println("Error loading the file - please check its location.");
			e.printStackTrace();
		}
	}
}
