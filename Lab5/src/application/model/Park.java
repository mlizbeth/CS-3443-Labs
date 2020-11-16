package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Park {
	
	private String parkName;
	private HashMap<Zone, ArrayList<Dinosaur>> parkMap;
	private final String ZONE_PATH = "data/zones.csv";
	private final String DINO_PATH = "data/dinos.csv";
	private final String SPLIT = ",";
	
	public Park(String parkName) {
		this.parkName = parkName;
		loadZones();
	
	}
	
	private void relocate() {
		
	}
	
	private void save() {
		
	}
	
	
	private void loadZones() {
		parkMap = new HashMap<Zone, ArrayList<Dinosaur>>();
		try {
			String line = "";
			BufferedReader reader = new BufferedReader(new FileReader(ZONE_PATH));
			while((line = reader.readLine()) != null) {
				String[] data = line.split(SPLIT);
				parkMap.put(new Zone(data[0], data[1], data[2]), new ArrayList<Dinosaur>());
			}
			reader.close();
		} catch(IOException e) { System.out.println("The system could not find the file specified"); }
		
		if(parkMap != null) {
			loadDinosaurs();
		}
	}
	
	private void loadDinosaurs() {
		try {
			String line = "";
			BufferedReader reader = new BufferedReader(new FileReader(DINO_PATH));
			while((line = reader.readLine()) != null) {
				String[] data = line.split(SPLIT);
				Dinosaur temp = new Dinosaur(data[0], data[1], Boolean.parseBoolean(data[2]));
				for(Zone z : parkMap.keySet()) {
					if(z.getZoneCode().equals(data[3])) {
						parkMap.get(z).add(temp);
					}
				}
			}
			reader.close();
		} catch(IOException e) { System.out.println("The system could not find the file specified"); }
	}
	
	public void setparkName(String parkName) {
		this.parkName = parkName;
	}
	
	public String getparkName() {
		return parkName;
	}
	
	public String toString() {
		for(Zone z : parkMap.keySet()) {
			System.out.println(z.getZoneName() + " - " + z.getZoneCode() + " (" + z.getThreatLevel() + " risk)");
			for(Dinosaur d : parkMap.get(z)) {
				System.out.println(" *" + d.toString());
			}
		}
		return "";
	}

}
