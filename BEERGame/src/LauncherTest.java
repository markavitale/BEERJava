import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

public class LauncherTest {

	Game game;
	Game game2;
	Launcher l;
	
	@Before
	public void setUp() throws Exception {
		Region taserRegion = new Region(32, 495, 60, 90);
		View main = new View("opening view in english", new ImageIcon(
				"images/main.jpg"), "opening view in french", new ImageIcon(
				"images/mainfrench.jpg"), taserRegion);
		Region homeRegion = new Region(0, 0, 800, 600, main);
		View home = new View("home view in english", new ImageIcon(
				"images/homeEnglish.jpg"), "home view in french",
				new ImageIcon("images/homeFrench.jpg"), homeRegion);

		Player p = new Player("Tyler");
		this.game = new Game(p, home);
		this.l = new Launcher();
		l.setGame(this.game);
		l.writeGame(game);
		game2 = l.readGame();
	
		
	}
	
	@Test
	public void testGetGame() {
		
		System.out.println(game);
		l.setGame(this.game);
		assertEquals(l.getGame(),game);
	}
	
	@Test
	public void testGetGamePanel() {
		SidePanel p = new SidePanel(l);
		GamePanel g = new GamePanel(l,p);
		l.setGamePanel(g);
		assertEquals(l.getGamePanel(),g);
		
	}
	@Test
	public void testSerializableViewDesc() {
		assertEquals(l.getGame().getCurrentView().getCurrentDescription()
				,game2.getCurrentView().getCurrentDescription());
	}

	@Test
	public void testSerializableViewFrenchDesc() {
		assertEquals(l.getGame().getCurrentView().getFrenchDescription()
				,game2.getCurrentView().getFrenchDescription());
	}
	@Test
	public void testSerializableRegionX() {
		assertEquals(l.getGame().getCurrentView().getRegions().get(0).getX()
				,game2.getCurrentView().getRegions().get(0).getX());
	}
	
	@Test
	public void testSerializableRegionY() {
		assertEquals(l.getGame().getCurrentView().getRegions().get(0).getX()
				,game2.getCurrentView().getRegions().get(0).getX());
	}
	
	@Test
	public void testSerializableRegionWidth() {
		assertEquals(l.getGame().getCurrentView().getRegions().get(0).getWidth()
				,game2.getCurrentView().getRegions().get(0).getWidth());
	}
	
	@Test
	public void testSerializableRegionHeight() {
		assertEquals(l.getGame().getCurrentView().getRegions().get(0).getHeight()
				,game2.getCurrentView().getRegions().get(0).getHeight());
	}
	
	@Test
	public void testSerializableRegionViewDesc() {
		assertEquals(l.getGame().getCurrentView().getRegions().get(0).getView().getCurrentDescription()
				,game2.getCurrentView().getRegions().get(0).getView().getCurrentDescription());
	}
	
	
}
