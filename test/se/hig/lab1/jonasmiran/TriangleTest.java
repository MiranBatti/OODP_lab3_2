package se.hig.lab1.jonasmiran;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figures.Triangle;
import figures.Vertex2D;

public class TriangleTest {
	
	Triangle triangle;
	Vertex2D v0 = new Vertex2D(-1.0, 1.0);
	Vertex2D v1 = new Vertex2D(3.0, -1.0);
	Vertex2D v2 = new Vertex2D(5.0, 3.0);
	Vertex2D center;

	@Before
	public void setUp() throws Exception {
		triangle = new Triangle(-1.0, 1.0, 3.0, -1.0, 5.0, 3.0);
		center = triangle.getCenter();
	}

	@After
	public void tearDown() throws Exception {
		triangle = null;
	}

	@Test
	public void testGetV0() {
		assertEquals("Wrong position!", v0, triangle.getV0());
	}

	@Test
	public void testGetV1() {
		assertEquals("Wrong position!", v1, triangle.getV1());
	}

	@Test
	public void testGetV2() {
		assertEquals("Wrong position!", v2, triangle.getV2());
	}

	@Test
	public void testMoveBy() {
		triangle.moveBy(3, 3);
		// V0
		assertEquals("Wrong position!", 2, triangle.getV0().getX(), 0.01);
		assertEquals("Wrong position!", 4, triangle.getV0().getY(), 0.01);
		// V1
		assertEquals("Wrong position!", 6, triangle.getV1().getX(), 0.01);
		assertEquals("Wrong position!", 2, triangle.getV1().getY(), 0.01);
		// V2
		assertEquals("Wrong position!", 8, triangle.getV2().getX(), 0.01);
		assertEquals("Wrong position!", 6, triangle.getV2().getY(), 0.01);
	}

	@Test
	public void testRotate() {
		triangle.rotate(30);
		// V0
		assertEquals(-0.598, triangle.getV0().getX(), 0.01);
		assertEquals(-0.5, triangle.getV0().getY(), 0.01);
		// V1
		assertEquals(3.866, triangle.getV1().getX(), 0.01);
		assertEquals(-0.232, triangle.getV1().getY(), 0.01);
		// V2
		assertEquals(3.598, triangle.getV2().getX(), 0.01);
		assertEquals(4.232, triangle.getV2().getY(), 0.01);
	}

	@Test
    public void testTriangleScale() {
		triangle.scale(1.21, 1.21);
		// V0
		assertEquals("Wrong position!", -1.63, triangle.getV0().getX(), 0.01);
		assertEquals("Wrong position!", 1, triangle.getV0().getY(), 0.01);
		// V1
		assertEquals("Wrong position!", 3.21, triangle.getV1().getX(), 0.01);
		assertEquals("Wrong position!", -1.42, triangle.getV1().getY(), 0.01);
		// V2
		assertEquals("Wrong position!", 5.63, triangle.getV2().getX(), 0.01);
		assertEquals("Wrong position!", 3.42, triangle.getV2().getY(), 0.01);
    }
}
