package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a Fleet object, which contains a name, and an ArrayList of Starships
 * 
 * @author Madeline Kotara - duk128
 * @version 1.0
 * @since 10-15-2020
 *
 */

public class Fleet {
	
	private String name;
	private List<Starship> ships = new ArrayList<Starship>();
	private final String SPLIT = ",";
	
	/**
	 * 
	 * @param name String containing name of the fleet
	 * @throws IOException if path is invalid
	 */
	
	public Fleet(String name) throws IOException {
		this.name = name;
		loadShips("data/fleet.csv");
		loadCrew("data/personnel.csv");
	}
	
	/**
	 * Reads personnel.csv and creates CrewMembers based on the data in the file
	 * @param path String path to the crew data file
	 * @throws IOException if path is invalid
	 */
	
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
	
	/**
	 * Reads fleet.csv and creates Starships based on the data in the file. 
	 * Also adds CrewMembers to the appropriate Starship based on CrewMember.currentShip and Starship.registry
	 * @param path String path to the starship data file
	 * @throws IOException if path is invalid
	 */
		
	private void loadShips(String path) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while((line = reader.readLine()) != null) {
			String[] data = line.split(SPLIT);
			ships.add(new Starship(data[0], data[1], data[2]));
		}
			
		reader.close();
	}
	
	/**
	 * Static method to create a new Fleet object
	 * @return Fleet 
	 * @throws IOException if path is invalid
	 */
	
	public static Fleet loadData() throws IOException {
		return new Fleet("United Federation of Planets");
	}
	
	/**
	 * 
	 * @return String containing Fleet name
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name Sets the name of the Fleet
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *  
	 * @return List of Starships
	 */

	public List<Starship> getShips() {
		return ships;
	}
	
	/**
	 * 
	 * @param ships Sets the Ships in the Fleet
	 */

	public void setShips(List<Starship> ships) {
		this.ships = ships;
	}
	
	/**
	 * Returns a List of Starships whose name contains the parameter passed
	 * @param shipName the String to search against the ship's name
	 * @return List of Starships containg the shipName passed
	 */

	public List<Starship> getStarshipsByName(String shipName) {
		List<Starship> temp = new ArrayList<Starship>();
		for(Starship ship : ships) {
			if(ship.getName().contains(shipName)) {
				temp.add(ship);
			}
		}
		return temp;
	}
	
	public String toString() {
		return ships.toString();
	}
}
