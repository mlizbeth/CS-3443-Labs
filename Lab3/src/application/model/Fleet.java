package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fleet {
	
	private String name;
	private List<Starship> ships = new ArrayList<Starship>();
	private final String SPLIT = ",";
	
	public Fleet(String name) throws IOException {
		this.name = name;
		loadShips("data/fleet.csv");
		loadCrew("data/personnel.csv");
	}
	
	public void loadCrew(String path) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while((line = reader.readLine()) != null) {
			for(Starship x : ships) {
				String[] data = line.split(SPLIT);
				CrewMember temp = new CrewMember(data[0], data[1], data[2], data[3], data[4]);
				if(x.getRegistry().equals(temp.getCurrentShip())) {
					x.addCrewMember(temp);
				}
			}
		}
		reader.close();
		
//		for(Starship x : ships) {
//			System.out.println(x.toString());
//		}
	}
		
	public void loadShips(String path) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while((line = reader.readLine()) != null) {
			String[] data = line.split(SPLIT);
			ships.add(new Starship(data[0], data[1], data[2]));
		}
			
		reader.close();
	}

	
	/*
	 * TODO
	 * getStarshipByName();
	 */
	
}
