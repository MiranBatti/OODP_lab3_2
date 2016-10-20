package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import figures.Vertex2D;
import interfaces.PrimitivesPainter;

public class PrimitivesPainterImpl implements PrimitivesPainter{
	private Graphics g;
	private double presetPointDiameter = 5;
	
	public void setGraphics(Graphics g){
		this.g = g;
	}

	@Override
	public void paintPoint(Vertex2D v) {
		g.setColor(Color.BLACK);
		g.drawOval( (int) v.getX(), (int) v.getY(), (int) presetPointDiameter, (int) presetPointDiameter);
	}

	@Override
	public void paintLine(Vertex2D v0, Vertex2D v1) {
		g.setColor(Color.PINK);
		g.drawLine( (int) v0.getX(), (int) v0.getY(), (int) v1.getX(), (int) v1.getY());
	}

	@Override
	public void paintCircle(Vertex2D center, double radie) {
		g.setColor(Color.DARK_GRAY);
		g.drawOval( (int) center.getX(), (int) center.getY(), (int) radie, (int) radie);
	}
	
	@Override
	public void paintRectangle(ArrayList<Vertex2D> v) {
		int xPoints[] = new int[v.size()];
		int yPoints[] = new int[v.size()];		
		int nPoints = v.size();		

		for (int i = 0; i < v.size(); i++) {
			xPoints[i] = (int) v.get(i).getX();
			yPoints[i] = (int) v.get(i).getY();
		}		
		g.setColor(Color.BLUE);
		g.drawPolygon(xPoints, yPoints, nPoints);
	}
	
	@Override
	public void paintTriangle(ArrayList<Vertex2D> v) {		
		int xPoints[] = new int[v.size()];
		int yPoints[] = new int[v.size()];		
		int nPoints = v.size();		
		
		for (int i = 0; i < v.size(); i++) {
			xPoints[i] = (int) v.get(i).getX();
			yPoints[i] = (int) v.get(i).getY();
		}		
		g.setColor(Color.RED);
		g.drawPolygon(xPoints, yPoints, nPoints);
	}
	
}
