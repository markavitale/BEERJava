
import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;


public class ViewTest {

	View v1;
	View v2;
	ImageIcon img;
	String description;
	Region myRegion;
	@Before
	public void setUp() throws Exception {
		img = new ImageIcon("main.jpg");
		description = "This is our opening image";
		v1 = new View(description, img);
		myRegion = new Region(1, 2, 3, 4);
		v2 = new View("random description", new ImageIcon("mainfrench.jpg"));
	}
	
	@Test
	public void testCreateDescription() {
		assertEquals(this.description,v1.getCurrentDescription());
	}
	
	@Test
	public void testCreateImage() {
		assertEquals(this.img,v1.getCurrentImage());
	}
	
	@Test
	public void addClickableRegionTrue() {
		v1.addRegion(myRegion);
		assertTrue(v1.getRegions().contains(myRegion));
	}
	
	@Test
	public void addClickableRegionFalse() {
		assertFalse(v1.getRegions().contains(new Region(5, 5, 5,5)));
	}
	
	@Test
	public void addClickableRegionafterRemove() {
		v1.removeRegion(myRegion);
		assertFalse(v1.getRegions().contains(myRegion));
	}
	
	@Test
	public void addView1() {
		v1.addView(v2);
		assertTrue(v1.getViews().contains(v2));
	}
	
	@Test
	public void addView2() {
		v1.addView(v2);
		assertTrue(v2.getViews().contains(v1));
	}
	
	@Test
	public void removeView1() {
		v1.addView(v2);
		v1.removeView(v2);
		assertFalse(v1.getViews().contains(v2));
	}
	
	@Test
	public void removeView2() {
		v1.addView(v2);
		v1.removeView(v2);
		assertFalse(v2.getViews().contains(v1));
	}
	

}
