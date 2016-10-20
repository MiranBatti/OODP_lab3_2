package logic;

import java.util.List;

import interfaces.FigureScalor;
import interfaces.Scalable;

public class FigureScalorImpl implements FigureScalor {
	
	List<Scalable> scaleList;
	
	/**
	 * Konstruktor som tar in en array med figurer
	 * @param figures
	 */
	public FigureScalorImpl(List<Scalable> scaleList) {
		this.scaleList = scaleList;
	}

	/**
	 * Scalar på alla figurer som har scale metoden
	 */
	@Override
	public void scaleAll(double factor_x, double factor_y) {
		for (Scalable figure : scaleList) {
			figure.scale(factor_x, factor_y);
		}
	}
}
