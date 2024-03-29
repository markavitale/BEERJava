import java.awt.Point;
import java.io.Serializable;

/**
 * @author vitalema
 * 
 *         This class represents a region on a view.
 * 
 */
@SuppressWarnings("serial")
public class Region implements Serializable {
	int x;
	int y;
	int width;
	int height;
	Item itemToPickUp;
	View v;
	View waitView;
	Item itemRequiredToInteract;

	/**
	 * @param newX
	 *            - x coordinate of top left point in the rectangle
	 * @param newY
	 *            - y coordinate of top left point in the rectangle
	 * @param w
	 *            - width of the region
	 * @param h
	 *            - height of the region
	 * 
	 *            constructor for a region with the given coordinates and
	 *            width/height
	 */
	public Region(int newX, int newY, int w, int h) {
		x = newX;
		y = newY;
		width = w;
		height = h;
	}

	/**
	 * @param newX
	 *            - x coordinate of top left point in the rectangle
	 * @param newY
	 *            - y coordinate of top left point in the rectangle
	 * @param w
	 *            - width of the region
	 * @param h
	 *            - height of the region
	 * @param item
	 *            - an item associated with a region
	 * 
	 *            This constructor associates an Item with a region so clicking
	 *            within that region allows the Player to interact with that
	 *            Item
	 */
	public Region(int newX, int newY, int w, int h, Item item) {
		x = newX;
		y = newY;
		width = w;
		height = h;
		itemToPickUp = item;

	}

	/**
	 * @param p
	 *            - the beginning point of the region
	 * @param w
	 *            - width of the region
	 * @param h
	 *            - height of the region
	 * @param view
	 *            - the view that will replace the Game's currentView
	 * @param interact
	 *            - an item that is required for the region to be clickable
	 *            
	 *            this allows an item to be interacted with in a way that will
	 *            change the current view to the provided view.
	 */
	public Region(Point p, int w, int h, View view, Item interact) {
		v = view;
		x = (int) p.getX();
		y = (int) p.getY();
		width = w;
		height = h;
		this.itemRequiredToInteract = interact;

	}

	/**
	 * @param p
	 *            - the beginning point of the region
	 * @param w
	 *            - width of the region
	 * @param h
	 *            - height of the region
	 * @param item
	 *            - an item to be picked up in the region
	 * @param view
	 *            - the view that will replace the Game's currentView
	 * 
	 */
	public Region(Point p, int w, int h, Item item, View view) {
		v = view;
		x = (int) p.getX();
		y = (int) p.getY();
		width = w;
		height = h;
		itemToPickUp = item;

	}

	/**
	 * @param newX
	 *            - x coordinate of top left point in the rectangle
	 * @param newY
	 *            - y coordinate of top left point in the rectangle
	 * @param w
	 *            - width of the region
	 * @param h
	 *            - height of the region
	 * @param item
	 *            - an item associated with a region
	 * @param view
	 *            - the view that will replace the Game's currentView
	 */
	public Region(int newX, int newY, int w, int h, View view) {
		v = view;
		x = newX;
		y = newY;
		width = w;
		height = h;

	}

	/**
	 * @param waitV
	 *            - the waitView for explosions
	 * @param p
	 *            - the beginning point of the region
	 * @param w
	 *            - width of the region
	 * @param h
	 *            - height of the region
	 * @param view
	 *            - the view that will replace the Game's currentView
	 */
	public Region(View waitV, Point p, int w, int h, View view) {
		waitView = waitV;
		v = view;
		x = (int) p.getX();
		y = (int) p.getY();
		;
		width = w;
		height = h;
	}

	Item getItem() {
		return itemToPickUp;
	}

	boolean hasWaitView() {
		if (waitView != null) {
			return true;
		}
		return false;
	}

	Item getRequiredItem() {
		return itemRequiredToInteract;
	}

	View getView() {
		return v;
	}

	View getWaitView() {
		return waitView;
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

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	int getHeight() {
		return height;
	}

	int getWidth() {
		return width;
	}

	boolean isInsideRegion(int newX, int newY) {
		return newX >= x && newX <= (x + width) && newY >= y
				&& newY <= (y + height);
	}
}
