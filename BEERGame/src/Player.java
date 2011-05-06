import java.util.ArrayList;

public class Player {
	
	String name;
	int clickCount;
	ArrayList<Item> inventory;
	
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
	
	ArrayList<Item> returnInventory() {
		return this.inventory;
	}
	boolean hasItem(Item i){
		return inventory.contains(i);
	}
}
