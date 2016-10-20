package interfaces;

public interface FigureHandler
{
	public void createCircle (double x, double y, double r);
	public void createLine (double x0, double y0, double x1, double y1);
	public void createPoint (double x, double y);
	public void createRectangle (double height, double width, double centerX, double centerY);
	public void createTriangle (double x0, double y0, double x1, double y1, double x2, double y2);
	public void removeAll ();
}
