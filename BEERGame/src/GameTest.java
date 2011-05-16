import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	Player p;
	View v;
	Game g;

	@Before
	public void setUp() throws Exception {
		p = new Player("Tyler");
		Region pauseRegion = new Region(0,0,800,600);
		View pauseView = new View("pause view in english", new ImageIcon(
				"images/pause.jpg"), "pause view in french", new ImageIcon(
						"images/pausefrench.jpg"), pauseRegion);
		g = new Game(p, v, pauseView);
	}

	@Test
	public void testGameCreatePlayer() {
		assertEquals("Tyler", p.getPlayerName());
	}

	@Test
	public void testGameCreatePlayerFalse() {
		assertFalse("Tylerdsadadd".equals(p.getPlayerName()));
	}

	@Test
	public void testMuteGame1() {
		assertFalse(g.isMuted());
	}

	@Test
	public void testMuteGame2() {
		g.muteGame();
		assertTrue(g.isMuted());
	}

	@Test
	public void testMuteGame3() {
		g.unmuteGame();
		assertFalse(g.isMuted());
	}

	@Test
	public void testPauseGame1() {

		assertFalse(g.isPaused());
	}

	@Test
	public void testPauseGame2() {
		g.pauseGame();
		assertTrue(g.isPaused());
	}

	@Test
	public void testPauseGame3() {
		g.unpauseGame();
		assertFalse(g.isPaused());
	}

	@After
	public void tearDown() throws Exception {

	}

}
