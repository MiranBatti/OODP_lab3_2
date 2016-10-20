package logic;

public class Main {

	public static void main(String[] args) {
		FigureBuilder b = new FigureBuilder();
		b.getFigureHandlerImpl().createLine(1, 1, 7, 7);
		b.getFigureRotorImpl().rotateAll(30);
		b.getFigurePrinterImpl().printAll();
	}
}
