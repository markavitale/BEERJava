import java.util.ArrayList;

public class Item {

	String name;
	String description;
	ArrayList<Item> interactableItems;
	
	public Item(String cName, String cDescription){
		name = cName;
		description = cDescription;
		interactableItems = new ArrayList<Item>();
	}
	String getName(){
		return name;
	}
	String getDescription(){
		return description;
	}
	
	boolean canInteractWithItem(Item i){
		return interactableItems.contains(i);
	}
	
	void addInteractableItem(Item i){
		interactableItems.add(i);
	}
}
