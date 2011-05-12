import static org.junit.Assert.*;

import java.awt.Point;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;


public class InventoryPanelTest {

	InventoryPanel invPanel;
	Launcher l;
	@Before
	public void setUp() {
		l = new Launcher();
		SidePanel sidePanel = new SidePanel(l);
		invPanel = new InventoryPanel(l.getGame(),sidePanel);
		Region r = new Region(0,0,50,50);
		l.getGame().getCurrentPlayer().getInventory().get(0).setRegion(r);
	}
	@Test
	public void testGetSelected() {
		assertEquals(invPanel.selected,invPanel.returnSelected());
	}
	
	@Test
	public void testSetSelected() {
		Item i = new Item("new item", "blah blah", "in french!");
		invPanel.setSelected(i);
		assertEquals(invPanel.returnSelected(),i);
	}
	
	@Test
	public void testImageClickNoChange() {
		Item i = new Item("new item", "blah blah", "in french!");
		invPanel.setSelected(i);
		invPanel.checkImageClick(new Point(100,100));
		assertEquals(invPanel.returnSelected(),i);
	}
	
	@Test
	public void testImageClickChange() {
		Item i = new Item("new item", "blah blah", "in french!");
		invPanel.setSelected(i);
		invPanel.checkImageClick(new Point(10,10));
		assertFalse(invPanel.returnSelected() == i);
	}
	
	@Test
	public void testImageClickChange2() {
		Item i = new Item("new item", "blah blah", "in french!");
		invPanel.setSelected(i);
		invPanel.checkImageClick(new Point(10,10));
		assertEquals(invPanel.returnSelected(),
				l.getGame().getCurrentPlayer().getInventory().get(0));
	}
}
