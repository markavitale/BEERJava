import java.awt.Image;
import java.util.ArrayList;


public class View {
	String description;
	Image background;
	ArrayList<View> possibleMoves;
	ArrayList<Region> clickableRegions;
	
	public View(String cDescription, Image cBackground){
		description = cDescription;
		background = cBackground;
		possibleMoves = new ArrayList<View>();
		clickableRegions = new ArrayList<Region>();
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
