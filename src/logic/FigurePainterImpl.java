package logic;

import interfaces.FigurePainter;

import java.util.List;

import interfaces.Drawable;

public class FigurePainterImpl implements FigurePainter{
	
	List<Drawable> drawableList;
	PrimitivesPainterImpl ppainter;
	
	public FigurePainterImpl(List<Drawable> drawableList, PrimitivesPainterImpl ppainter){
		this.drawableList = drawableList;
		this.ppainter = ppainter;
	}

	@Override
	public void paintAll() {
		for (Drawable drawable : drawableList) {
			drawable.draw(ppainter);
		}
	}

}
