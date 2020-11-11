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
		wut = new HashMap<Zone, ArrayList<Dinosaur>>();
		try {
			String line = "";
			BufferedReader reader = new BufferedReader(new FileReader(ZONE_PATH));
			while((line = reader.readLine()) != null) {
				String[] data = line.split(SPLIT);
				wut.put(new Zone(data[0], data[1], data[2]), new ArrayList<Dinosaur>());
				//wut.put(new Zone(data[0], data[1], data[2]), null);
			}
			reader.close();
		} catch(IOException e) { System.out.println("The system could not find the file specified"); }
		loadDinosaurs();
	}
	
	//TODO
	//Who knows???
	
	private void loadDinosaurs() {
		ArrayList<Dinosaur> bList = new ArrayList<Dinosaur>();
		ArrayList<Dinosaur> dList = new ArrayList<Dinosaur>();
		ArrayList<Dinosaur> gList = new ArrayList<Dinosaur>();
		ArrayList<Dinosaur> rList = new ArrayList<Dinosaur>();
		ArrayList<Dinosaur> xList = new ArrayList<Dinosaur>();
		ArrayList<Dinosaur> tyList = new ArrayList<Dinosaur>();
		ArrayList<Dinosaur> trList = new ArrayList<Dinosaur>();
		try {
			String line = "";
			BufferedReader reader = new BufferedReader(new FileReader(DINO_PATH));
			while((line = reader.readLine()) != null) {
				String[] data = line.split(SPLIT);
				//dinos.add(new Dinosaur(data[0], data[1], Boolean.getBoolean(data[2])));
				Dinosaur temp = new Dinosaur(data[0], data[1], Boolean.getBoolean(data[2]));
				switch(data[3]) {
				case "B":
					bList.add(temp);
					break;
				case "D":
					dList.add(temp);
					break;
				case "G":
					gList.add(temp);
					break;
				case "R":
					rList.add(temp);
					break;
				case "X":
					xList.add(temp);
					break;
				case "TY":
					tyList.add(temp);
					break;
				case "TR":
					trList.add(temp);
					break;
				default:
					break;
				}
				
			}
			reader.close();
		} catch(IOException e) { System.out.println("The system could not find the file specified"); }
		
		for(Zone z : wut.keySet()) {
			switch(z.getZoneCode()) {
			case "B":
				wut.put(z, bList);
				break;
			case "D":
				wut.put(z, dList);
				break;
			case "G":
				wut.put(z, gList);
				break;
			case "R":
				wut.put(z, rList);
				break;
			case "X":
				wut.put(z, xList);
				break;
			case "TY":
				wut.put(z, tyList);
				break;
			case "TR":
				wut.put(z, trList);
				break;
			default:
				break;
			}
		}
		
		System.out.println(wut);
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
