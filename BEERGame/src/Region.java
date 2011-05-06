import java.util.ArrayList;

public class Region {
	int x;
	int y;
	int width;
	int height;
	Item itemToPickUp;
	
	public Region(int newX,int newY, int w, int h){
		x = newX;
		y = newY;
		width = w;
		height = h;
	}
	
	public Region(int newX,int newY, int w, int h, Item item){
		x = newX;
		y = newY;
		width = w;
		height = h;
		itemToPickUp = item;
	
	}
	
	Item getItem() {
		return itemToPickUp;
	}

	boolean hasItem() {
		if (itemToPickUp == null) {
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
