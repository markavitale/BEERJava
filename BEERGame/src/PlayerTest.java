import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class PlayerTest {

	
	String s;
	Player newPlayer;
	Item item;
	Item item2;
	
	@Before
	public void setUp() throws Exception {
		s = "Tyler";
		newPlayer = new Player(s);
		item = new Item("item", "this is an item", "french item description");
		item2 = new Item("item 2", "this is another item", "french item description");	
		
	}

	@Test
	public void testPlayerName() {
		assertEquals(s, newPlayer.getPlayerName());
	}
	
	@Test
	public void testPlayerClickCount0() {
		assertEquals(0, newPlayer.getClickCount());
	}
	
	@Test
	public void testPlayerClickCount1() {
		newPlayer.increaseClickCount();
		assertEquals(1, newPlayer.getClickCount());
	}
	
	@Test
	public void testPlayerClickCount10() {
		for(int i = 0; i < 10; i++){
			newPlayer.increaseClickCount();
		}
		assertEquals(10, newPlayer.getClickCount());
	}
	
	@Test
	public void testPlayerInventoryTrue() {
		newPlayer.addItem(item);
		assertTrue(newPlayer.hasItem(item));
	}
	
	@Test
	public void testPlayerInventoryFalse() {
		assertFalse(newPlayer.hasItem(item2));
	}
	
	@After
	public void tearDown() throws Exception {
	
	}
	
}
