
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SidePanelTest {

	private Launcher l;
	private SidePanel p;
	private InventoryPanel invPanel;
	@Before
	public void setUp() throws Exception {
		l = new Launcher();
		this.l = new Launcher();
		l.setGame(l.readGame());
		p = new SidePanel(l);
		invPanel = new InventoryPanel(l,p);
	}

	@Test
	public void testGetSetInvPanel() {
		p.setInvPanel(invPanel);
		assertEquals(invPanel, p.getInvPanel());
	}
	
	@Test
	public void testUpdateTextInvDesc() {
		l.getGame().setLanguage("english");
		p.updateText();
		assertEquals(p.getMiddleTextArea().getText(),"Inventory");
	}
	
	@Test
	public void testUpdateTextInvDescFrench() {
		l.getGame().setLanguage("french");
		p.updateText();
		assertEquals(p.getMiddleTextArea().getText(),"Inventaire");
	}
	
	@Test
	public void testUpdateTopPanel() {
		l.getGame().setLanguage("english");
		p.updateText();
		assertEquals(p.getTopTextArea().getText(),l.getGame().getCurrentView().getCurrentDescription());
	}
	
	@Test
	public void testUpdateTopPanelFrench() {
		l.getGame().setLanguage("french");
		p.updateText();
		assertEquals(p.getTopTextArea().getText(),l.getGame().getCurrentView().getFrenchDescription());
	}
	
	@Test
	public void testUpdateBottomPanel() {
		l.getGame().setLanguage("english");
		Item i = new Item("random item", "english description", "french description");
		p.getInvPanel().setSelected(i);
		p.updateText();
		assertEquals(p.getBottomTextArea().getText(),i.getDescription());
	}
	
	@Test
	public void testUpdateBottomPanelFrench() {
		l.getGame().setLanguage("french");
		Item i = new Item("random item", "english description", "french description");
		p.getInvPanel().setSelected(i);
		p.updateText();
		assertEquals(p.getBottomTextArea().getText(),i.getFrenchDescription());
	}
	
}
