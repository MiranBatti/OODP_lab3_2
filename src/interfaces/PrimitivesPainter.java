package interfaces;

import java.util.ArrayList;

import figures.Vertex2D;

public interface PrimitivesPainter {
	public void paintPoint(Vertex2D v);
	public void paintLine(Vertex2D v0, Vertex2D v1);
	public void paintCircle(Vertex2D center, double radie);
	public void paintRectangle(ArrayList<Vertex2D> v);
	public void paintTriangle(ArrayList<Vertex2D> v);
}
