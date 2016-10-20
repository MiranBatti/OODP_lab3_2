package se.hig.lab1.jonasmiran;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figures.Line;

public class LineTest {
	Line line;
	
	@Before
	public void setUp() throws Exception {
		line = new Line(0, 0, 2, 2);
	}

	@After
	public void tearDown() throws Exception {
		line = null;
	}

	@Test
	public void testVertexPositions() {
		// Vertex 1
		assertEquals("Wrong position", 0, line.getV0().getX(), 0.0001);
		assertEquals("Wrong position", 0, line.getV0().getY(), 0.0001);
		// Vertex 2
		assertEquals("Wrong position", 2, line.getV1().getX(), 0.0001);
		assertEquals("Wrong position", 2, line.getV1().getY(), 0.0001);
	}
	
	public void testCenter(){
		assertEquals("Wrong position", 1, line.getCenter());
	}
}
