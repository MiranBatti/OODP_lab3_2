package se.hig.lab1.jonasmiran;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figures.Circle;

public class CircleTest {
	Circle circle;

	@Before
	public void setUp() throws Exception {
		circle = new Circle(2, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
		circle = null;
	}

	@Test
	public void testVertexPositions() {
		assertEquals("Wrong x position", 2, circle.getCenter().getX(), 0.0001);
		assertEquals("Wrong y position", 1, circle.getCenter().getY(), 0.0001);
		assertEquals("Wrong radius", 1, circle.getRadius(), 0.0001);
	}
	
	@Test
	public void testMoveBy(){
		circle.moveBy(3, 3);
		assertEquals("Error: MoveByX", 5, circle.getCenter().getX(), 0.0001);
		assertEquals("Error: MoveByX", 4, circle.getCenter().getY(), 0.0001);
	}

	@Test
	public void testScale(){
		circle.scale(1.21, 1.21);
		assertEquals("Error: ScaleX", 2, circle.getCenter().getX(), 0.0001);
		assertEquals("Error: ScaleY", 1, circle.getCenter().getY(), 0.0001);
		assertEquals("Error: Radius", 1.21, circle.getRadius(), 0.0001);
	}
}
