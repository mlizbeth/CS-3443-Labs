package application.model;

/**
 * Creates a CrewMember object containing their name, position, ranking, species, and the ship they are on board.
 * @author Madeline Kotara - duk128
 * @version 1.0
 * @since 10-15-2020
 *
 */

public class CrewMember {
	
	private String name, position, rank, species, currentShip;
	
	/**
	 * 
	 * @param name String containing CrewMember name
	 * @param position String containing CrewMember position
	 * @param rank String containing CrewMember ranking
	 * @param currentShip String containing the ship registry that they are on board
	 * @param species String containing the species of the CrewMember
	 * @see Starship
	 */
	
	public CrewMember(String name, String position, String rank, String currentShip, String species) {
		this.name = name;
		this.position = position;
		this.rank = rank;
		this.currentShip = currentShip;
		this.species = species;
	}
	
	/**
	 * 
	 * @return String containing CrewMember name
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name The name to be assigned to the CrewMember
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return String containing the job position
	 */ 

	public String getPosition() {
		return position;
	}
	
	/**
	 * 
	 * @param position The job position to be assigned to the CrewMember
	 */

	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * 
	 * @return rank String containing The ranking of the CrewMember
	 */
	
	public String getRank() {
		return rank;
	}
	
	/**
	 * 
	 * @param rank The ranking to be assigned to the CrewMember
	 */

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	/**
	 * 
	 * @return String containing the Species of the CrewMember
	 */

	public String getSpecies() {
		return species;
	}
	
	/**
	 * 
	 * @param species The species to be assigned to the CrewMember
	 */

	public void setSpecies(String species) {
		this.species = species;
	}
	
	/**
	 * 
	 * @return String containing the registry code of the ship the CrewMember is on 
	 * @see Starship
	 */

	public String getCurrentShip() {
		return currentShip;
	}
	
	/**
	 * 
	 * @param currentShip The registry code to be assigned to the CrewMember to associate them with a ship
	 * @see Starship
	 */

	public void setCurrentShip(String currentShip) {
		this.currentShip = currentShip;
	}
	
	public String toString() {
		return rank + " " + name + ", " + position + " " + "(" + species + ")";
	}

}
