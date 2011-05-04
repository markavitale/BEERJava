import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	Item i1;
	Item i2;
	Item i3;
	Item i4;

	@Before
	public void setUp() throws Exception {
		i1 = new Item("taser", "This is a taser");
		i2 = new Item("keys", "These keys unlock things");
		i3 = new Item("moneybag", "This bag contains money");
		i4 = new Item("rock", "This is a rock");
		
		i1.addInteractableItem(i2);
		i1.addInteractableItem(i3);
		i2.addInteractableItem(i4);
	}

	@Test
	public void testGetName1() {
		assertEquals("taser", i1.getName());
	}

	@Test
	public void testGetName2() {
		assertEquals("keys", i2.getName());
	}

	@Test
	public void testGetName3() {
		assertEquals("moneybag", i3.getName());
	}

	@Test
	public void testGetName4() {
		assertEquals("rock", i4.getName());
	}

	@Test
	public void testGetDescription1() {
		assertEquals("This is a taser", i1.getDescription());
	}

	@Test
	public void testGetDescription2() {
		assertEquals("These keys unlock things", i2.getDescription());
	}

	@Test
	public void testGetDescription3() {
		assertEquals("This bag contains money", i3.getDescription());
	}

	@Test
	public void testGetDescription4() {
		assertEquals("This is a rock", i4.getDescription());
	}

	@Test
	public void testLongDescription() {
		String s = "This is an example of a really really long description. Our descriptions will be shorter than this so this is a good way to test they will all work!";
		Item newItem = new Item("random Name", s);
		assertEquals(s, newItem.getDescription());
	}

	@Test
	public void testIsInteractable0() {
	

		assertTrue(i1.canInteractWithItem(i2));
	}

	@Test
	public void testIsInteractable1() {
		assertTrue(i1.canInteractWithItem(i3));
	}

	@Test
	public void testIsInteractable2() {
		assertFalse(i1.canInteractWithItem(i4));
	}
	
	@Test
	public void testIsInteractable3() {
		assertTrue(i2.canInteractWithItem(i4));
	}
	
	@Test
	public void testIsInteractable4() {
		assertTrue(i2.canInteractWithItem(i1));
	}
}
