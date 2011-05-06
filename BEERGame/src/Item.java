import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Item {

	String name;
	String description;
	ArrayList<Item> interactableItems;
	ImageIcon itemImage;

	public Item(String cName, String cDescription) {
		name = cName;
		description = cDescription;
		interactableItems = new ArrayList<Item>();
	}

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
