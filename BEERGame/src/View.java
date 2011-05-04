import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class View {
	String description;
	ImageIcon background;
	ArrayList<View> possibleMoves;
	ArrayList<Region> clickableRegions;
	
	public View(String cDescription, ImageIcon cBackground){
		description = cDescription;
		background = cBackground;
		possibleMoves = new ArrayList<View>();
		clickableRegions = new ArrayList<Region>();
	}
	
	public ImageIcon getCurrentImage() {
		return background;
	}
	
	void addView(View v){
		possibleMoves.add(v);
	}
	
	void removeView(View v){
		possibleMoves.remove(v);
	}
	
	void addRegion(Region r){
		clickableRegions.add(r);
	}
	
	void removeRegion(Region r){
		clickableRegions.remove(r);
	}
}
