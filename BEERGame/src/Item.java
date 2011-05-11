import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * This class represents an item in the game.
 *
 */
public class Item implements Serializable {

	String name;
	String description;
	String frenchDescription;
	ArrayList<Item> interactableItems;
	ImageIcon itemImage;
	Region r;

	/**
	 * @param cName - the name of the item.
	 * @param cDescription - the description of the item.
	 * 
	 * This is the constructor to the item class, 
	 */
	public Item(String cName, String cDescription, String fDescription) {
		name = cName;
		description = cDescription;
		interactableItems = new ArrayList<Item>();
		frenchDescription = fDescription;
	}

	/**
	 * @param cName - the name of the item
	 * @param cDescription - the description of the item
	 * @param img - an image of the item
	 * @param itemRegion - the clickable region for this item on the screen
	 * 
	 * This constructor also takes an image for display in the inventory.
	 */
	public Item(String cName, String cDescription, ImageIcon img,
			Region itemRegion, String fDescription) {
		r = itemRegion;
		frenchDescription = fDescription;
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
	
	Region getRegion() {
		return r;
	}
	
	String getDescription() {
		return description;
	}
	
	String getFrenchDescription() {
		return frenchDescription;
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
