import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	
	String name;
	int clickCount;
	ArrayList<Item> inventory;
	
	/**
	 * @param playerName the name of the player
	 * 
	 * this creates the player that will play through the game and 
	 * initializes his inventory to be empty.
	 */
	public Player(String playerName){
		name = playerName;
		inventory = new ArrayList<Item>();
	}
	
	String getPlayerName(){
		return name;
	}
	
	void increaseClickCount(){
		clickCount++;
	}
	
	int getClickCount(){
		return clickCount;
	}
	
	void addItem(Item i){
		inventory.add(i);
	}
	
	ArrayList<Item> getInventory() {
		return this.inventory;
	}
	boolean hasItem(Item i){
		return inventory.contains(i);
	}
}
