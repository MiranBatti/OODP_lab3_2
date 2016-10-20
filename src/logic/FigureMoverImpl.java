package logic;

import java.util.List;

import figures.FigureType;
import interfaces.FigureMover;

public class FigureMoverImpl implements FigureMover {
	
	List<FigureType> figures;
	
	/**
	 * Konstruktor som tar in en array med figurer
	 * @param figures
	 */
	public FigureMoverImpl(List<FigureType> figures) {
		this.figures = figures;
	}

	/**
	 * Flyttar alla figurer i arrayen
	 */
	@Override
	public void moveAll(double x, double y) {
		for (FigureType figure : figures) {
			figure.moveBy(x, y);
		}
	}
}
