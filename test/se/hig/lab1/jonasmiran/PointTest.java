package se.hig.lab1.jonasmiran;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figures.Point;
import figures.Vertex2D;

public class PointTest {	
	Point point;

	@Before
	public void setUp() throws Exception {
		point = new Point(2.0, 1.0);
	}

	@After
	public void tearDown() throws Exception {
		point = null;
	}

	@Test
	public void testNewPoint() {
		assertEquals("Wrong Position", 0, point.getV().dist(new Vertex2D(2.0,1.0)), 0.01);
	}
	@Test
	public void testNewMoveBy() {
		assertEquals("Wrong Position", 0, point.getV().dist(new Vertex2D(2.0,1.0)), 0.01);
	}
	
}
