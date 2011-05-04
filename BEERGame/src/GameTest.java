
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GameTest {

	Player p = new Player("Tyler");
	View v;
	Game g = new Game(p, v);
	@Before
	public void setUp() throws Exception {
		Player p = new Player("Tyler");
		View v;
	}

	@Test
	public void testGameCreatePlayer() {
		assertEquals("Tyler", p.getPlayerName());
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
