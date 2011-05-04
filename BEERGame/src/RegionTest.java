import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class RegionTest {

	Region newRegion;
	@Before
	public void setUp() throws Exception {
	newRegion = new Region(1,2,3,4);
	}
	
	@Test
	public void getXTest(){
		assertEquals(newRegion.getX(), 1);
	}
	
	@Test
	public void getYTest(){
		assertEquals(newRegion.getY(), 2);
	}
	
	@Test
	public void getWidthTest(){
		assertEquals(newRegion.getWidth(), 3);
	}
	
	@Test
	public void getHeightTest(){
		assertEquals(newRegion.getHeight(), 4);
	}
	
	@Test
	public void isInsideRegionTest1(){
		assertTrue(newRegion.isInsideRegion(2,3));
		}
	
	@Test
	public void isInsideRegionTest2(){
		assertFalse(newRegion.isInsideRegion(15,23));
		}
	
	@Test
	public void isInsideRegionTest3(){
		assertFalse(newRegion.isInsideRegion(2,100));
		}
	
	@Test
	public void isInsideRegionTest4(){
		assertFalse(newRegion.isInsideRegion(100,3));
		}
}
