public class Region {
	int x;
	int y;
	int width;
	int height;
	
	public Region(int newX,int newY, int w, int h){
		x = newX;
		y = newY;
		width = w;
		height = h;
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
