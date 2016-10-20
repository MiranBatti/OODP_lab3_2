package logic;

import java.util.ArrayList;
import java.util.List;

import figures.Circle;
import figures.FigureType;
import figures.Line;
import figures.Point;
import figures.Rectangle;
import figures.Triangle;
import interfaces.Drawable;
import interfaces.FigureHandler;
import interfaces.Rotatable;
import interfaces.Scalable;

public class FigureHandlerImpl implements FigureHandler {
	
	List<FigureType> figures = new ArrayList<FigureType>();
	List<Rotatable> rotatableFigures = new ArrayList<Rotatable>();
	List<Scalable> scalableFigures = new ArrayList<Scalable>();
	List<Drawable> drawableFigures = new ArrayList<Drawable>();
	
	/**
	 * Skapar en cirkel och lägger den i arrayen klassen använder
	 */
	@Override
	public void createCircle(double x, double y, double radius) {
		Circle circle = new Circle(x, y, radius);
		figures.add(circle);
		scalableFigures.add(circle);
		drawableFigures.add(circle);
	}
	
	/**
	 * Skapar en linje och lägger den i arrayen klassen använder
	 */
	@Override
	public void createLine(double x0, double y0, double x1, double y1) {
		Line line = new Line(x0, y0, x1, y1);
		figures.add(line);
		rotatableFigures.add(line);
		scalableFigures.add(line);
		drawableFigures.add(line);
	}
	
	/**
	 * Skapar en punkt och lägger den i arrayen klassen använder
	 */
	@Override
	public void createPoint(double x, double y) {
		Point point = new Point(x, y);
		figures.add(point);
		drawableFigures.add(point);
	}

	/**
	 * Skapar en rektangel och lägger den i arrayen klassen använder
	 */
	@Override
	public void createRectangle(double height, double width, double centerX, double centerY) {
		Rectangle rectangle = new Rectangle(height, width, centerX, centerY);
		figures.add(rectangle);
		rotatableFigures.add(rectangle);
		scalableFigures.add(rectangle);
		drawableFigures.add(rectangle);
	}

	/**
	 * Skapar en triangel och lägger den i arrayen klassen använder
	 */
	@Override
	public void createTriangle(double x0, double y0, double x1, double y1, double x2, double y2) {
		Triangle tri = new Triangle(x0, y0, x1, y1, x2, y2);
		figures.add(tri);
		rotatableFigures.add(tri);
		scalableFigures.add(tri);
		drawableFigures.add(tri);
	}

	/**
	 * Tar bort alla figurer från arrayen som klassen har skapat
	 */
	@Override
	public void removeAll() {
		figures.clear();
		drawableFigures.clear();
	}
	
	/**
	 * Retunerar en array med alla figurer som har skapats
	 * @return
	 */
	public List<FigureType> getAllFigures() {
		return figures;
	}
	
	public List<Rotatable> getRotatableFigures() {
		return rotatableFigures;
	}
	
	public List<Scalable> getScalableFigures() {
		return scalableFigures;
	}
	
	public List<Drawable> getDrawableFigures() {
		return drawableFigures;
	}
}
