package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Park {
	
	private String parkName;
	private HashMap<Zone, ArrayList<Dinosaur>> wut;
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
	
	//TODO
	//Who knows if this is a good idea
	
	private void loadZones() {
		List<Zone> zones = new ArrayList<Zone>();
		try {
			String line = "";
			BufferedReader reader = new BufferedReader(new FileReader(ZONE_PATH));
			while((line = reader.readLine()) != null) {
				String[] data = line.split(SPLIT);
				zones.add(new Zone(data[0], data[1], data[2]));
			}
			reader.close();
		} catch(IOException e) { System.out.println("The system could not find the file specified"); }
		loadDinosaurs(zones);
	}
	
	//TODO
	//Who knows???
	
	private void loadDinosaurs(List<Zone> zones) {
		List<Dinosaur> dinos = new ArrayList<Dinosaur>();
		try {
			String line = "";
			BufferedReader reader = new BufferedReader(new FileReader(DINO_PATH));
			while((line = reader.readLine()) != null) {
				String[] data = line.split(SPLIT);
				dinos.add(new Dinosaur(data[0], data[1], Boolean.getBoolean(data[2])));
				switch(data[3]) {
				case "B":
					break;
				case "D":
					break;
				case "G":
					break;
				case "R":
					break;
				case "X":
					break;
				case "TY":
					break;
				case "TR":
					break;
				default:
					break;
				}
			}
			reader.close();
		} catch(IOException e) { System.out.println("The system could not find the file specified"); }
		System.out.println(dinos);
	}
	
	public void setparkName(String parkName) {
		this.parkName = parkName;
	}
	
	public String getparkName() {
		return parkName;
	}
	
	public String toString() {
		return "";
	}

}
