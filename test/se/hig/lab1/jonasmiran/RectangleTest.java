package se.hig.lab1.jonasmiran;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figures.Rectangle;
import figures.Vertex2D;

public class RectangleTest {
	
	Rectangle rectangle;
	Vertex2D center = new Vertex2D(20,20);
	double height = 10;
	double width = 20;
	double rndX;
	double rndY;
	Vertex2D v0;
	Vertex2D v1;
	Vertex2D v2;
	Vertex2D v3;

	@Before
	public void setUp() throws Exception {
		rectangle = new Rectangle(height, width, 20, 20);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetV0() {
		double x = center.getX() - (width / 2);
		double y = center.getY() + (height / 2);
		assertEquals("Wrong position!", new Vertex2D(x, y), rectangle.getV0());
	}

	@Test
	public void testGetV1() {
		double x = center.getX() + (width / 2);
		double y = center.getY() + (height / 2);
		assertEquals("Wrong position!", new Vertex2D(x, y), rectangle.getV1());
	}

	@Test
	public void testGetV2() {
		double x = center.getX() - (width / 2);
		double y = center.getY() - (height / 2);
		assertEquals("Wrong position!", new Vertex2D(x, y), rectangle.getV2());
	}

	@Test
	public void testGetV3() {
		double x = center.getX() + (width / 2);
		double y = center.getY() - (height / 2);
		assertEquals("Wrong position!", new Vertex2D(x, y), rectangle.getV3());
	}

	@Test
	public void testMoveBy() {
		rndX = 20;
		rndY = 10;
		v0 = rectangle.getV0();
		v1 = rectangle.getV1();
		v2 = rectangle.getV2();
		v3 = rectangle.getV3();
		rectangle.moveBy(rndX, rndY);
		assertEquals("Wrong position!", new Vertex2D((v0.getX() + rndX), (v0.getY() + rndY)), rectangle.getV0());
		assertEquals("Wrong position!", new Vertex2D((v1.getX() + rndX), (v1.getY() + rndY)), rectangle.getV1());
		assertEquals("Wrong position!", new Vertex2D((v2.getX() + rndX), (v2.getY() + rndY)), rectangle.getV2());
		assertEquals("Wrong position!", new Vertex2D((v3.getX() + rndX), (v3.getY() + rndY)), rectangle.getV3());
	}

	@Test
	public void testRotate() {
		double angle = 90;
		v0 = rectangle.getV0();
		v1 = rectangle.getV1();
		v2 = rectangle.getV2();
		v3 = rectangle.getV3();
		rectangle.rotate(angle);
		assertEquals("Wrong position!", v0.rotate(center, angle), rectangle.getV0());
		assertEquals("Wrong position!", v1.rotate(center, angle), rectangle.getV1());
		assertEquals("Wrong position!", v2.rotate(center, angle), rectangle.getV2());
		assertEquals("Wrong position!", v3.rotate(center, angle), rectangle.getV3());
	}

	@Test
	public void testScale() {
		rndX = 3;
		rndY = 2;
		v0 = rectangle.getV0();
		v1 = rectangle.getV1();
		v2 = rectangle.getV2();
		v3 = rectangle.getV3();
		rectangle.scale(rndX, rndY);
		assertEquals("Wrong position!", v0.scale(center, rndX, rndY), rectangle.getV0());
		assertEquals("Wrong position!", v1.scale(center, rndX, rndY), rectangle.getV1());
		assertEquals("Wrong position!", v2.scale(center, rndX, rndY), rectangle.getV2());
		assertEquals("Wrong position!", v3.scale(center, rndX, rndY), rectangle.getV3());
	}
}
