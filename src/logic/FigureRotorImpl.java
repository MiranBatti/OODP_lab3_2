package logic;

import java.util.List;

import interfaces.FigureRotor;
import interfaces.Rotatable;

public class FigureRotorImpl implements FigureRotor {
	
	List<Rotatable> rotateList;
	
	/**
	 * Konstruktor som tar in en array med figurer
	 * @param figures
	 */
	public FigureRotorImpl (List<Rotatable> rotateList) {
		this.rotateList = rotateList;
	}

	/**
	 * Roterar på alla figurer som har rotate metoden
	 */
	@Override
	public void rotateAll(double angle) {
		for (Rotatable figure : rotateList) {
			figure.rotate(angle);
		}
	}
}
