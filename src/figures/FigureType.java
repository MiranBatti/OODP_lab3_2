package figures;

import java.util.ArrayList;

public abstract class FigureType {
	
	protected ArrayList<Vertex2D> vertex2DArray = new ArrayList<Vertex2D>();
	public Vertex2D center;
	
	public FigureType() {
		
	}
	
	public Vertex2D getCenter(){
		return center;
	}
	
	/**
	 * Flyttar form i x och y led
	 * @param d_x
	 * @param d_y
	 */
	public void moveBy(double d_x, double d_y) {
		for (int i = 0; i < vertex2DArray.size(); i++) {
			Vertex2D _vertex2D = new Vertex2D((vertex2DArray.get(i).getX() + d_x), (vertex2DArray.get(i).getY() + d_y));
			vertex2DArray.set(i, _vertex2D);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < vertex2DArray.size(); i++) {
			s.append(i + ", X: " + vertex2DArray.get(i).getX() + ", Y: " + vertex2DArray.get(i).getY());
		}
		return s.toString();
	}
}
