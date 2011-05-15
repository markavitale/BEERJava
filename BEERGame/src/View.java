import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/**
 * @author vitalema
 * 
 *         this is a view in the game
 */
public class View extends TimerTask implements Serializable{
	String description;
	String frenchDescription;
	ImageIcon background;
	ImageIcon frenchBackground;
	ArrayList<View> possibleMoves;
	ArrayList<Region> clickableRegions;

	/**
	 * @param cDescription
	 *            - description of this view
	 * @param cBackground
	 *            - the background image for this view
	 * 
	 *            this constructs a view and initializes the possibleMoves and
	 *            clickableRegions arrays to empty arrays
	 */
	public View(String cDescription, ImageIcon cBackground) {
		description = cDescription;
		background = cBackground;
		possibleMoves = new ArrayList<View>();
		clickableRegions = new ArrayList<Region>();
	}

	public View(String cDescription, ImageIcon cBackground,
			String fDescription, ImageIcon frenchBack, Region r) {
		description = cDescription;
		frenchBackground = frenchBack;
		frenchDescription = fDescription;
		background = cBackground;
		possibleMoves = new ArrayList<View>();
		clickableRegions = new ArrayList<Region>();
		clickableRegions.add(r);
	}

	/**
	 * @param cDescription
	 *            - description of this view
	 * @param cBackground
	 *            - the background image for this view
	 * @param french
	 *            - the French version of this view
	 * 
	 *            this returns the French version of this view.
	 */

	public View(String cDescription, ImageIcon cBackground, Region r) {
		description = cDescription;
		
		background = cBackground;
		possibleMoves = new ArrayList<View>();
		clickableRegions = new ArrayList<Region>();
		clickableRegions.add(r);
	}
	
	public View(String cDescription, ImageIcon cBackground, String fDescription, Region r) {
		frenchDescription = fDescription;
//		if (cDescription == "the dynamite is lit, back away!") {
//			TimerTask newView = new View("you win", new ImageIcon("images/youwin.jpg"),
//					"you win in french", new ImageIcon("images/youwinfrench.jpg"), newGame);
//			Timer timer = new Timer();
//			timer.schedule(newView, 100);
//			}
		description = cDescription;
		background = cBackground;
		possibleMoves = new ArrayList<View>();
		clickableRegions = new ArrayList<Region>();
		clickableRegions.add(r);
	}
	/**
	 * @return the image for this view
	 */
	public ImageIcon getCurrentImage() {
		return background;
	}
	
	/**
	 * @return the alternate view in French
	 */
	public ImageIcon getFrenchImage() {
		return this.frenchBackground;
	}

	public String getFrenchDescription() {
		return this.frenchDescription;
	}

	/**
	 * @return the description of this view
	 */
	public String getCurrentDescription() {
		return this.description;
	}

	/**
	 * @return the list of clickable regions
	 */
	public ArrayList<Region> getRegions() {
		return this.clickableRegions;
	}

	/**
	 * @return return the list of possible views the user could get to from this
	 *         view
	 */
	public ArrayList<View> getViews() {
		return this.possibleMoves;
	}

	void addView(View v) {
		if (!possibleMoves.contains(v)) {
			possibleMoves.add(v);
		}
		if (!v.possibleMoves.contains(this)) {
			v.possibleMoves.add(this);
		}
	}

	void removeView(View v) {
		if (possibleMoves.contains(v)) {
			possibleMoves.remove(v);
		}
		if (v.possibleMoves.contains(this)) {
			v.possibleMoves.remove(this);
		}
	}

	void addRegion(Region r) {
		clickableRegions.add(r);
	}

	void removeRegion(Region r) {
		clickableRegions.remove(r);
	}

	@Override
	public void run() {
		System.out.println("timer test");
		
	}
}
