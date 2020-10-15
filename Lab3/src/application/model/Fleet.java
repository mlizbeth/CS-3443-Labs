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
	
	private void loadCrew(String path) throws IOException {
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
	}
		
	private void loadShips(String path) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while((line = reader.readLine()) != null) {
			String[] data = line.split(SPLIT);
			ships.add(new Starship(data[0], data[1], data[2]));
		}
			
		reader.close();
	}
	
	public static Fleet loadData() throws IOException {
		return new Fleet("United Federation of Planets");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Starship> getShips() {
		return ships;
	}

	public void setShips(List<Starship> ships) {
		this.ships = ships;
	}

	public List<Starship> getStarshipsByName(String shipName) {
		List<Starship> temp = new ArrayList<Starship>();
		for(Starship ship : ships) {
			if(ship.getName().contains(shipName)) {
				temp.add(ship);
			}
		}
		return temp;
	}
}
