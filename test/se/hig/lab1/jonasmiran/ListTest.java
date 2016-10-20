package se.hig.lab1.jonasmiran;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figures.FigureType;
import figures.Rectangle;
import interfaces.Rotatable;
import interfaces.Scalable;
import figures.Line;

public class ListTest {
	private Line line;
	private Rectangle rekt;
	private List<Rotatable> rotatableList;
	private List<Scalable> scalableList;
	private List<FigureType> figures;

	@Before
	public void setUp() throws Exception {
		line = new Line(0, 0, 4, 2);
		rekt = new Rectangle(6, 4, 2, 1);
		rotatableList = new ArrayList<Rotatable>();
		scalableList = new ArrayList<Scalable>();
		figures = new ArrayList<FigureType>();
		//Line
		rotatableList.add(line);
		scalableList.add(line);
		figures.add(line);
		//Rectangle
		rotatableList.add(rekt);
		scalableList.add(rekt);
		figures.add(rekt);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRotate() {
		for (Rotatable rotatable : rotatableList){
			rotatable.rotate(30.0);
		}
		// Line
		//Center
		assertEquals("Rotate line, CenterX", 2, line.getCenter().getX(), 0.003);
		assertEquals("Rotate line, CenterY", 1, line.getCenter().getY(), 0.003);
		//V0
		assertEquals("Rotate line, V0 X", 0.769, line.getV0().getX(), 0.003);
		assertEquals("Rotate line, V0 Y", -0.866, line.getV0().getY(), 0.003);
		//V1
		assertEquals("Rotate line, V1 X", 3.232, line.getV1().getX(), 0.003);
		assertEquals("Rotate line, V1 Y", 2.866, line.getV1().getY(), 0.003);
		
		
	}
	
	public void testScale(){
		for (Scalable scalable : scalableList) {
			scalable.scale(1.21, 1.21);
		}
		//Line
		//Center
		assertEquals("Scale, CenterX", 2, line.getCenter().getX(), 0.003);
		assertEquals("Scale, CenterY", 1, line.getCenter().getY(), 0.003);
		//V0
		assertEquals("Scale, V0 X", -0.42, line.getV0().getX(), 0.003);
		assertEquals("Scale, V0 Y", -0.21, line.getV0().getY(), 0.003);
		//V1
		assertEquals("Scale, V1 X", 4.42, line.getV1().getX(), 0.003);
		assertEquals("Scale, V1 Y", 2.21, line.getV1().getY(), 0.003);
		
		//Rectangle
	}

	public void testMoveBy(){
		for (FigureType fig : figures) {
			fig.moveBy(3, 3);
		}
		//Line
		//Center
		assertEquals("MoveBy, CenterX", 5, line.getCenter().getX(), 0.003);
		assertEquals("MoveBy, CenterY", 4, line.getCenter().getY(), 0.003);
		//V0
		assertEquals("MoveBy, V0 X", 3, line.getV0().getX(), 0.003);
		assertEquals("MoveBy, V0 Y", 3, line.getV0().getY(), 0.003);
		//V1
		assertEquals("MoveBy, V1 X", 7, line.getV1().getX(), 0.003);
		assertEquals("MoveBy, V1 Y", 5, line.getV1().getY(), 0.003);
		
		//Rectangle
	}
}
