package figures;

import interfaces.Drawable;
import interfaces.PrimitivesPainter;
import interfaces.Rotatable;
import interfaces.Scalable;

public class Line extends FigureType implements Rotatable, Scalable, Drawable {
	
	private Vertex2D center;
	
	/**
	 * Konstruktor som tar in två positioner som behövs för att skapa en linje
	 * @param v0
	 * @param v1
	 */
	public Line(double x0, double y0, double x1, double y1) {
		vertex2DArray.add(new Vertex2D(x0, y0));
		vertex2DArray.add(new Vertex2D(x1, y1));
	}
	
	/**
	 * Retunerar Vertex2D v0
	 * @return
	 */
	public Vertex2D getV0() {
		return vertex2DArray.get(0);
	}
	
	/**
	 * Retunerar Vertex2D v1
	 * @return
	 */
	public Vertex2D getV1() {
		return vertex2DArray.get(1);
	}
	
	/**
	 * Retunerar centrum av lijen
	 * @return
	 */
	@Override
	public Vertex2D getCenter() {
		return center;
	}
	
	public void calculateCenter(){
		double centerX = (getV0().getX() + getV1().getX()) / (double) vertex2DArray.size();
		double centerY = (getV0().getY() + getV1().getY()) / (double) vertex2DArray.size();
		
		center = new Vertex2D(centerX, centerY);
	}
	
	/**
	 * Roterar linjen med inskickad vinkel
	 * @param angle
	 */
	@Override
	public void rotate(double angle) {
		calculateCenter();
		center = getCenter();
		
		for (int i = 0; i < vertex2DArray.size(); i++) {
			Vertex2D _vertex2D = vertex2DArray.get(i).rotate(center, angle);
			vertex2DArray.set(i, _vertex2D);
		}
	}
	
	/**
	 * Scalar linjen i x-led och y-led
	 * @param xFactor
	 * @param yFactor
	 */
	public void scale(double xFactor, double yFactor) {
		calculateCenter();
		center = getCenter();
		
		for (int i = 0; i < vertex2DArray.size(); i++) {
			Vertex2D _vertex2D = vertex2DArray.get(i).scale(center, xFactor, yFactor);
			vertex2DArray.set(i, _vertex2D);
		}
	}
	
	/**
	 * Retunerar string med info om objektet
	 */
	@Override
	public String toString() {
		return ("Line: V0: " + getV0() + ", V1: " + getV1());
	}
	
	/** 
	 * equals metod för att jämföra objekt
	 */
	@Override
	public boolean equals (Object objecjt) {
		if (!(objecjt instanceof Vertex2D))
			return false;
		Line line = (Line) objecjt;
		return (line.getV0() == getV0() && line.getV0() == getV0());
	}

	@Override
	public void draw(PrimitivesPainter ppaint) {
		ppaint.paintLine(vertex2DArray.get(0), vertex2DArray.get(1));
	}
}
