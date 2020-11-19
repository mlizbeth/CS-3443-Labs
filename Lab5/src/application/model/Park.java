package application.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
	
	public void relocate(String currentZoneCode, String newZoneCode, String dinoName) {
		Dinosaur dinoToRelocate = null;
		
		for(Zone zone : parkMap.keySet()) {
			if(zone.getZoneCode().equals(currentZoneCode)) {
				ArrayList<Dinosaur> dinosInZone = parkMap.get(zone);
				for(Iterator<Dinosaur> dinoIterator = dinosInZone.iterator(); dinoIterator.hasNext();) {
					Dinosaur dino = dinoIterator.next();
					if(dino.getName().equals(dinoName)) {
						dinoToRelocate = dino;
						dinoIterator.remove();
						dinosInZone.remove(dino);
						parkMap.put(zone, dinosInZone);
					}
				}
			}
		}
		
		if(dinoToRelocate != null) {
			for(Zone zone : parkMap.keySet()) {
				if(zone.getZoneCode().equals(newZoneCode)) {
					ArrayList<Dinosaur> dinosInZone = parkMap.get(zone);
					dinosInZone.add(dinoToRelocate);
					parkMap.put(zone, dinosInZone);
				}
			}
		}
	}
	
	public void save() {
		try {
			Files.delete(Paths.get(DINO_PATH));
		} catch(IOException e) { System.out.println("Error deleting data file"); }
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DINO_PATH, true));
			parkMap.entrySet().forEach(entity -> {
				ArrayList<Dinosaur> temp = entity.getValue();
				for(Dinosaur dino : temp) {
					try {
						writer.write(dino.getName() + "," + dino.getType() + "," + dino.isNotCarnivorous() + "," + entity.getKey().getZoneCode());
						writer.newLine();
						writer.flush();
					} catch (IOException e) { System.out.println("Error writing to data file"); }
				}
			});		
			writer.close();
		} catch(IOException e) { System.out.println("Error creating data file"); }
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
	
	public HashMap<Zone, ArrayList<Dinosaur>> getParkMap() {
		return parkMap;
	}
	
	public void setParkMap(HashMap<Zone, ArrayList<Dinosaur>> parkMap) {
		this.parkMap = parkMap;
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
