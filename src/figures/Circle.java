package figures;

import interfaces.Drawable;
import interfaces.PrimitivesPainter;
import interfaces.Scalable;

public class Circle extends FigureType implements Scalable, Drawable{
	
	private Vertex2D center, p0;
	private double radius;
	
	/**
	 * Konstruktor med 2 parameterar som behövs för att skapa en circle
	 * @param radius
	 * @param center
	 */
	public Circle(double x, double y, double radius) {
		center = new Vertex2D(x, y);
		this.radius = radius;
		p0 = this.calculateRadiusEndPoint();
	}
	
	/**
	 * Retunerar centrum i circeln
	 * @return 
	 */
	public Vertex2D getCenter() {
		return center;
	}
	
	/**
	 * Retunerar cirkelns radie
	 * @return
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * Flyttar cirkeln i x och y led
	 * @param x
	 * @param y
	 */
	@Override
	public void moveBy(double x, double y) {
		double centerX = center.getX();
		double centerY = center.getY();
		center = new Vertex2D((centerX + x), (centerY + y));
	}
	
	/**
	 * Scalar cirkeln med factor
	 * @param factor
	 */
	public void scale(double factor_x, double factor_y) {
		p0 = p0.scale(center, factor_x, factor_y);
		radius = this.calculateNewRadius();
	}
	
	private Vertex2D calculateRadiusEndPoint(){
		double x = center.getX() + radius;
		double y = center.getY() + radius;
		return new Vertex2D(x, y);
	}
	
	private double calculateNewRadius() {
		double x = p0.getX() - center.getX();
		double y = p0.getY() - center.getY();
		double newRadius = (x + y) / 2;
		return newRadius;
	}
	/**
	 * Retunerar string med info om objektet
	 */
	@Override
	public String toString() {
		return ("Circle: Center: " + getCenter() + ", Radie: " + getRadius());
	}
	
	/** 
	 * equals metod för att jämföra objekt
	 */
	@Override
	public boolean equals (Object objecjt) {
		if (!(objecjt instanceof Vertex2D))
			return false;
		Circle circle = (Circle) objecjt;
		return (circle.getCenter() == getCenter() && circle.getRadius() == getRadius());
	}

	@Override
	public void draw(PrimitivesPainter ppaint) {
		ppaint.paintCircle(center, radius);
	}
}
