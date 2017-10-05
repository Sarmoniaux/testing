/**
 * 
 */
package main.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * @author Simon Armusieaux & Emilie Henry
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestMyPoint {
	
	@Mock
	Random rand1;
	Random rand2;
	
	private MyPoint pointNeutre;
	private MyPoint pointGenerique;
	private MyPoint pointNull;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pointNeutre = new MyPoint();
		pointGenerique = new MyPoint(12.5,-6.123456789);
		pointNull = null;
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#MyPoint()}.
	 */
	@Test
	public void testMyPoint() {
		assertTrue(pointNeutre.getX() == 0 && pointNeutre.getY() == 0);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#MyPoint(double, double)}.
	 */
	@Test
	public void testMyPointDoubleDouble() {
		assertTrue(pointGenerique.getX() == 12.5 && pointGenerique.getY() == -6.123456789);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#MyPoint(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testMyPointMyPoint() {
		MyPoint copyPoint = new MyPoint(pointGenerique);
		assertTrue(copyPoint.getX() == 12.5d && copyPoint.getY() == -6.123456789d);
	}
	
	@Test
	public void testMyPointMyPointNull() {
		MyPoint copyPoint = new MyPoint(pointNull);
		assertTrue(copyPoint.getX() == 0d && copyPoint.getY() == 0d);
	}
	
	@Test
	public void testMyPointMyPointVide() {
		MyPoint copyPoint = new MyPoint(pointNeutre);
		assertTrue(copyPoint.getX() == 0d && copyPoint.getY() == 0d);
	}
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getX()}.
	 */
	@Test
	public void testGetX() {
		pointGenerique.setX(36.123456789);
		assertTrue(pointGenerique.getX() == 36.123456789 && pointGenerique.getY() == 0);
	}
	
	@Test
	public void testGetXNaN() {
		pointGenerique.setX(Double.NaN);
		assertEquals(Double.NaN, pointGenerique.getX(),0);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getY()}.
	 */
	@Test
	public void testGetY() {
		pointGenerique.setY(Double.NaN);
		assertTrue(pointGenerique.getY() == 36789.12346789 && pointGenerique.getX() == 0);
	}
	
	@Test
	public void testGetYNaN() {
		pointGenerique.setY(Math.sqrt(-8));
		assertTrue(pointGenerique.getY() == Double.NaN);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#scale(double)}.
	 */
	@Test
	public void testScale() {
		MyPoint pointScale = pointGenerique.scale(3.0d);
		assertTrue(pointScale.getX() == pointGenerique.getX()*3.0d && pointScale.getY() == pointGenerique.getY()*3.0d);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#horizontalSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testHorizontalSymmetry() {
		MyPoint pointSummetry = pointGenerique.horizontalSymmetry(pointNeutre);
		assertTrue(pointSummetry.getX() == -pointGenerique.getX());
	}
	
	@Test
	public void testHorizontalSymmetryNegatif() {
		pointGenerique.setX(-1);
		pointGenerique.setY(-2.668);
		MyPoint pointSummetry = pointGenerique.horizontalSymmetry(pointNeutre);
		assertTrue(pointSummetry.getX() == -pointGenerique.getX());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHorizontalSymmetryNull() {
		MyPoint pointSummetry = pointGenerique.horizontalSymmetry(pointNull);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#computeAngle(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testComputeAngle() {
		MyPoint pointAngle = new MyPoint(2,0);
		pointGenerique.setX(0);
		pointGenerique.setY(2);
		assertEquals(90,pointGenerique.computeAngle(pointAngle),1);
		
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void testRotatePoint() {
		assertEquals(null, pointGenerique.rotatePoint(pointNull, 90));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#centralSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetry() {
		pointGenerique.centralSymmetry(pointNull);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getMiddlePoint(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testGetMiddlePoint() {
		pointGenerique.setX(0.0d);
		pointGenerique.setY(2.0d);
		MyPoint pointMiddle = pointGenerique.getMiddlePoint(pointNeutre);
		assertTrue(pointMiddle.getY() == 1.0d && pointMiddle.getX() == 0.0d);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#translate(double, double)}.
	 */
	@Test
	public void testTranslateDoubleDouble() {
		pointGenerique.setX(0.0d);
		pointGenerique.setY(2.0d);
		pointGenerique.translate(2.0d, 3.0d);
		assertTrue(pointGenerique.getX() == 2.0d && pointGenerique.getY() == 5.0d);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#setPoint(java.util.Random, java.util.Random)}.
	 */
	@Test
	public void testSetPoint() {
		rand1 = Mockito.mock(Random.class);
		rand2 = Mockito.mock(Random.class);
		Mockito.when(rand1.nextInt()).thenReturn(3);
		Mockito.when(rand2.nextInt()).thenReturn(38);
		
		pointGenerique.setPoint(rand1, rand2);
		
		assertTrue(pointGenerique.getX() == 3.0d && pointGenerique.getY() == 38.0d);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#translate(ITranslation)}.
	 */
	@Test
	public void testTranslateITranslation() {
		ITranslation translation = Mockito.mock(ITranslation.class);
		Mockito.when(translation.getTx()).thenReturn(3);
		Mockito.when(translation.getTy()).thenReturn(38);
		pointGenerique.translate(translation);
		
		assertTrue(pointGenerique.getX() == 3.0d && pointGenerique.getY() == 38.0d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetryNULL() {
        new MyPoint(10,20).centralSymmetry(null);
    }

}
