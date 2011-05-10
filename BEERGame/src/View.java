import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class View implements Serializable{
	String description;
	ImageIcon background;
	ArrayList<View> possibleMoves;
	ArrayList<Region> clickableRegions;
	View frenchAlternate;
	
	public View(String cDescription, ImageIcon cBackground){
		description = cDescription;
		background = cBackground;
		possibleMoves = new ArrayList<View>();
		clickableRegions = new ArrayList<Region>();
	}
	
	public View(String cDescription, ImageIcon cBackground, View french){
		description = cDescription;
		frenchAlternate = french;
		background = cBackground;
		possibleMoves = new ArrayList<View>();
		clickableRegions = new ArrayList<Region>();
	}
	public ImageIcon getCurrentImage() {
		return background;
	}
	
	public View getFrenchAlternate() {
		return this.frenchAlternate;
	}
	public String getCurrentDescription() {
		return this.description;
	}
	
	public ArrayList<Region> getRegions() {
		return this.clickableRegions;
	}
	
	public ArrayList<View> getViews() {
		return this.possibleMoves;
	}
	
	void addView(View v){
		if (!possibleMoves.contains(v)){
		possibleMoves.add(v);
		}
		if (!v.possibleMoves.contains(this)) {
			v.possibleMoves.add(this);
		}
	}
	
	void removeView(View v){
		if (possibleMoves.contains(v)) {
			possibleMoves.remove(v);
		}
		if (v.possibleMoves.contains(this)){
			v.possibleMoves.remove(this);
		}
	}
	
	void addRegion(Region r){
		clickableRegions.add(r);
	}
	
	void removeRegion(Region r){
		clickableRegions.remove(r);
	}
}
