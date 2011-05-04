
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;


public class ItemTest {
	Item i1;
	Item i2;
	Item i3;
	Item i4;
	
	
	@Before
	public void setUp() throws Exception {
		i1 = new Item("Item 1");
		i2 = new Item("Item 2");
		i3 = new Item("Item 3");
		i4 = new Item("Item 4");
	}

	@Test
	public void isInsideRegionTest2(){
		assertFalse(newRegion.isInsideRegion(15,23));
		}
}
