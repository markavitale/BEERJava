import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * This class represents an item in the game.
 *
 */
public class Item {

	String name;
	String description;
	ArrayList<Item> interactableItems;
	ImageIcon itemImage;

	/**
	 * @param cName - the name of the item.
	 * @param cDescription - the description of the item.
	 * 
	 * This is the constructor to the item class, 
	 */
	public Item(String cName, String cDescription) {
		name = cName;
		description = cDescription;
		interactableItems = new ArrayList<Item>();
	}

	/**
	 * @param cName - the name of the item
	 * @param cDescription - the description of the item
	 * @param img - an image of the item
	 * 
	 * This constructor also takes an image for display in the inventory.
	 */
	public Item(String cName, String cDescription, ImageIcon img) {
		itemImage = img;
		name = cName;
		description = cDescription;
		interactableItems = new ArrayList<Item>();
	}
	String getName() {
		return name;
	}

	ImageIcon getItemImage() {
		return this.itemImage;
	}
	
	String getDescription() {
		return description;
	}

	boolean canInteractWithItem(Item i) {
		return interactableItems.contains(i);
	}

	void addInteractableItem(Item i) {
		if (!canInteractWithItem(i)) {
			interactableItems.add(i);
		}
		if (!i.canInteractWithItem(this)) {
			i.addInteractableItem(this);
		}

	}
}
