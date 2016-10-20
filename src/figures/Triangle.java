package figures;

import interfaces.Drawable;
import interfaces.PrimitivesPainter;
import interfaces.Rotatable;
import interfaces.Scalable;

public class Triangle extends FigureType implements Rotatable, Scalable, Drawable{
	
	private Vertex2D center;
	
	/**
	 * Konstruktor som tar in alla tre positionerna som behövs för att skapa en triangel
	 * @param v0
	 * @param v1
	 * @param v2
	 */
	public Triangle(double x0, double y0, double x1, double y1, double x2, double y2) {
		vertex2DArray.add(new Vertex2D(x0, y0));
		vertex2DArray.add(new Vertex2D(x1, y1));
		vertex2DArray.add(new Vertex2D(x2, y2));
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
	 * Retunerar Vertex2D v2
	 * @return
	 */
	public Vertex2D getV2() {
		return vertex2DArray.get(2);
	}
	
	/**
	 * Retunerar centrum av triangeln
	 * @return
	 */
	
	private void calculateCenter() {
		double minX = vertex2DArray.get(0).getX();
		double maxX = vertex2DArray.get(0).getX();
		double minY = vertex2DArray.get(0).getY();
		double maxY = vertex2DArray.get(0).getY();
		
		for (int i = 0; i < vertex2DArray.size(); i++) {
			if (minX > vertex2DArray.get(i).getX()) {
				minX = vertex2DArray.get(i).getX();
			}
			if (minY > vertex2DArray.get(i).getY())
				minY = vertex2DArray.get(i).getY();
		}
		
		for (int i = 0; i < vertex2DArray.size(); i++) {
			if (maxX < vertex2DArray.get(i).getX()) {
				maxX = vertex2DArray.get(i).getX();
			}
			if (maxY < vertex2DArray.get(i).getY())
				maxY = vertex2DArray.get(i).getY();
		}
		center = new Vertex2D(minX + ((maxX-minX) / 2), minY + ((maxY-minY) / 2));
	}
	
	@Override
	public Vertex2D getCenter(){
		return center;
	}

	/**
	 * Roterar triangeln med inskickad vinkel
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
	 * Scalar triangeln i x-led och y-led
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
		return ("Triangle: V0: " + getV0() + ", V1: " + getV1() + ", V2: " + getV2());
	}
	
	/** 
	 * equals metod för att jämföra objekt
	 */
	@Override
	public boolean equals (Object objecjt) {
		if (!(objecjt instanceof Vertex2D))
			return false;
		Triangle tri = (Triangle) objecjt;
		return (tri.getV0() == getV0() && tri.getV1() == getV1() && tri.getV2() == getV2());
	}

	@Override
	public void draw(PrimitivesPainter ppaint) {
		ppaint.paintTriangle(this.vertex2DArray);
	}
}
