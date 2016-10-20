package logic;

import java.util.List;

import figures.FigureType;
import interfaces.FigurePrinter;

public class FigurePrinterImpl implements FigurePrinter
{
	List<FigureType> figures;
	
	/**
	 * Konstruktor som tar in en array med figurer
	 * @param figures
	 */
	public FigurePrinterImpl (List<FigureType> figures)
	{
		this.figures = figures;
	}
	
	/**
	 * Loopar igen alla figurer och använder toString metoden för samtliga
	 */
	@Override
	public void printAll ()
	{
		for (FigureType f : figures)
			System.out.println (f);
	}
}
