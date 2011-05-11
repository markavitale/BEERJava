import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author vitalema
 * 
 * This class represents a region on a view.
 *
 */
public class Region implements Serializable {
	int x;
	int y;
	int width;
	int height;
	Item itemToPickUp;
	View v;
	Item itemRequiredToInteract;
	
	/**
	 * @param newX - x coordinate of top left point in the rectangle
	 * @param newY - y coordinate of top left point in the rectangle
	 * @param w - width of the region
	 * @param h - height of the region
	 * 
	 * constructor for a region with the given coordinates and width/height
	 */
	public Region(int newX,int newY, int w, int h){
		x = newX;
		y = newY;
		width = w;
		height = h;
	}
	
	/**
	 * @param newX - x coordinate of top left point in the rectangle
	 * @param newY - y coordinate of top left point in the rectangle
	 * @param w - width of the region
	 * @param h - height of the region
	 * @param item - an item associated with a region
	 * 
	 * This constructor associates an Item with a region so clicking within
	 * that region allows the Player to interact with that Item
	 */
	public Region(int newX,int newY, int w, int h, Item item){
		x = newX;
		y = newY;
		width = w;
		height = h;
		itemToPickUp = item;
	
	}
	
	/**
	 * @param newX - x coordinate of top left point in the rectangle
	 * @param newY - y coordinate of top left point in the rectangle
	 * @param w - width of the region
	 * @param h - height of the region
	 * @param item - an item associated with a region
	 * @param view - the view that will replace the Game's currentView
	 * 
	 * this allows an item to be interacted with in a way that will change the
	 * current view to the provided view.
	 */
	public Region(int newX,int newY, int w, int h, View view, Item interact){
		v = view;
		x = newX;
		y = newY;
		width = w;
		height = h;
		this.itemRequiredToInteract = interact;
	
	}
	
	public Region(int newX,int newY, int w, int h, Item item, View view){
		v = view;
		x = newX;
		y = newY;
		width = w;
		height = h;
		itemToPickUp = item;
	
	
	}
	
	public Region(int newX,int newY, int w, int h, View view){
		v = view;
		x = newX;
		y = newY;
		width = w;
		height = h;
	
	
	}
	
	Item getItem() {
		return itemToPickUp;
	}
	
	Item getRequiredItem() {
		return itemRequiredToInteract;
	}
	View getView() {
		return v;
	}
	
	
	boolean hasItem() {
		if (itemToPickUp == null) {
			return false;
		}
		return true;
	}
	boolean hasRequiredItem() {
		if (itemRequiredToInteract == null) {
			return false;
		}
		return true;
	}
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
	int getHeight(){
		return height;
	}
	int getWidth(){
		return width;
	}
	
	boolean isInsideRegion(int newX, int newY){
		return newX >= x && newX <= (x+width)
				&& newY >= y && newY <= (y+height);
	}
}
