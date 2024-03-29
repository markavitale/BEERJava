import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author vitalema and hannantt
 * 
 *         This class represents the current player of the game
 */
@SuppressWarnings("serial")
public class Player implements Serializable {

	String name;
	int clickCount;
	ArrayList<Item> inventory;

	/**
	 * @param playerName
	 *            the name of the player
	 * 
	 *            this creates the player that will play through the game and
	 *            initializes his inventory to be empty.
	 */
	public Player(String playerName) {
		name = playerName;
		inventory = new ArrayList<Item>();
	}

	String getPlayerName() {
		return name;
	}

	void setPlayerName(String pName) {
		this.name = pName;
	}

	void increaseClickCount() {
		clickCount++;
	}

	int getClickCount() {
		return clickCount;
	}

	void addItem(Item i) {
		inventory.add(i);
	}

	void removeItem(Item i) {
		if (inventory.contains(i)) {
			inventory.remove(i);
		}
	}

	ArrayList<Item> getInventory() {
		return this.inventory;
	}

	boolean hasItem(Item i) {
		return inventory.contains(i);
	}
}
