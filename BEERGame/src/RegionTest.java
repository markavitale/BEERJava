import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class RegionTest {

	Region newRegion;
	int xMinMinusOne, xMin, xNom, xMax, xMaxPlusOne;
	int yMinMinusOne, yMin, yNom, yMax, yMaxPlusOne;

	ArrayList<Integer> xValues;
	ArrayList<Integer> yValues;

	@Before
	public void setUp() throws Exception {
		newRegion = new Region(1, 1, 4, 4);
		xValues = new ArrayList<Integer>();
		yValues = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			xValues.add(i);
			yValues.add(i);
		}

		xMinMinusOne = 0;
		xMin = 1;
		xNom = 3;
		xMax = 5;
		xMaxPlusOne = 6;
		yMinMinusOne = 0;
		yMin = 1;
		yNom = 3;
		yMax = 5;
		yMaxPlusOne = 6;

	}

	@Test
	public void getXTest() {
		assertEquals(newRegion.getX(), 1);
	}

	@Test
	public void getXTestFalse() {
		assertFalse(newRegion.getX() == 2);
	}

	@Test
	public void getYTest() {
		assertEquals(newRegion.getY(), 1);
	}

	@Test
	public void getYTestFalse() {
		assertFalse(newRegion.getY() == 11);
	}

	@Test
	public void getWidthTest() {
		assertEquals(newRegion.getWidth(), 4);
	}

	@Test
	public void getWidthTestFalse() {
		assertFalse(newRegion.getWidth() == 12);
	}

	@Test
	public void getHeightTest() {
		assertEquals(newRegion.getHeight(), 4);
	}

	@Test
	public void getHeightTestFalse() {
		assertFalse(newRegion.getHeight() == 12);
	}

	@Test
	public void isInsideRegionTestFalses() {
		for (int i = 0; i < yValues.size(); i++) {
			assertFalse(newRegion
					.isInsideRegion(xMinMinusOne, yValues.get(i)));
			assertFalse(newRegion
					.isInsideRegion(xMaxPlusOne, yValues.get(i)));
			assertFalse(newRegion
					.isInsideRegion(xValues.get(i),yMinMinusOne));
			assertFalse(newRegion
					.isInsideRegion(xValues.get(i), yMaxPlusOne));
		}
	}

	@Test
	public void isInsideRegionTestTrues() {
		for (int i = xMin; i < xMax; i++) {
			for (int z = yMin; z < yMax; z++) {
				assertTrue(newRegion.isInsideRegion(xValues.get(i), yValues
						.get(z)));
			}
		}
	}
}
