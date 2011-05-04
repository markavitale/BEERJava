import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;



public class RegionTest {

	Region newRegion;
	/*int xMinMinus1, xMin, xMinPlus1, xNom, xMaxMinusOne, xMax, xMaxPlusOne;
	int yMinMinus1, yMin, yMinPlus1, yNom, yMaxMinusOne, yMax, yMaxPlusOne;
	*/
	ArrayList<Integer> xValues;
	ArrayList<Integer> yValues;
 	@Before
	public void setUp() throws Exception {
	newRegion = new Region(1,1,4,4);
	xValues = new ArrayList<Integer>();
	yValues = new ArrayList<Integer>();
	for (int i =0; i<7; i++) {
		xValues.add(i);
		yValues.add(i);
	}
	
	/*xMinMinus1 = 0;
	xMin = 1; 
	xMinPlus1 = 2;
	xNom = 3;
	xMaxMinusOne = 4;
	xMax = 5; 
	xMaxPlusOne = 6;
	yMinMinus1 = 0;
	yMin = 1; 
	yMinPlus1 = 2;
	yNom = 3;
	yMaxMinusOne = 4;
	yMax = 5; 
	yMaxPlusOne = 6;
	*/
	}
	
	@Test
	public void getXTest(){
		assertEquals(newRegion.getX(), 1);
	}
	
	@Test
	public void getXTestFalse(){
		assertFalse(newRegion.getX() == 2);
	}
	
	@Test
	public void getYTest(){
		assertEquals(newRegion.getY(), 1);
	}
	
	@Test
	public void getYTestFalse(){
		assertFalse(newRegion.getY() == 11);
	}
	
	
	@Test
	public void getWidthTest(){
		assertEquals(newRegion.getWidth(), 4);
	}
	
	@Test
	public void getWidthTestFalse(){
		assertFalse(newRegion.getWidth() == 12);
	}
	
	
	@Test
	public void getHeightTest(){
		assertEquals(newRegion.getHeight(), 4);
	}
	
	@Test
	public void getHeightTestFalse(){
		assertFalse(newRegion.getHeight() == 12);
	}
	
	@Test
	public void isInsideRegionTestFalses() {
		for (int i =0 ; i <yValues.size(); i++) {
			assertFalse(newRegion.isInsideRegion(xValues.get(0), yValues.get(i)));
			assertFalse(newRegion.isInsideRegion(xValues.get(6), yValues.get(i)));
			assertFalse(newRegion.isInsideRegion(xValues.get(i), yValues.get(0)));
			assertFalse(newRegion.isInsideRegion(xValues.get(i), yValues.get(6)));
		}
	}
	
	@Test
	public void isInsideRegionTestTrues() {
		for (int i =1 ; i <yValues.size()-1; i++) {
			for (int z =1 ; z <yValues.size()-1; z++) {
			assertTrue(newRegion.isInsideRegion(xValues.get(i), yValues.get(z)));
			}
		}
	}
}
