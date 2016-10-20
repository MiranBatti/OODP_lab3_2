package gui;

/*
 * OODP, laboration 3
 *
 * DrawingPanel.java
 *
 * Peter Jenke, 2015-01-10
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import logic.FigureBuilder;

/**
 * DrawingPanel kan användas för att visa geometriska figurer.
 * Klassen implementerar MouseListener, dvs. innehåller metoder
 * som kan användas för att registrera mus-händelser.
 * 
 * @author Peter.Jenke@hig.se
 */
@SuppressWarnings("serial")
public class DrawingPanel extends JPanel implements MouseListener {
	// Uppgifter:
	// - Lägg till kod för att tilldela och lagra en instans FigurePainter.
	// - Lägg till kod för att tilldela och lagra en instans PrimitivesPainter.
	// - Tilldela PrimitivesPainter-instansen till FigurePainter-instansen.
	FigureBuilder build = new FigureBuilder();
		
	/**
	 * Skapar en ny instans av DrawingPanel.
	 * 
	 */
	public DrawingPanel()
	{
		// MapPanel 'fångar' själv mushändelse:
		addMouseListener(this);
	}
	
	/**
	 * Shares the same instance of FigureBuilder with ControlPanel
	 * @return FigureBuilder
	 */
	public FigureBuilder getFigureBuilder() {
		return build;
	}

	/**
	 * Ritar ut grafiska elementen på nytt.
	 * 
	 * Grafiska element här är kartan och linjen samt start-/slutpunkt.
	 * Det senare ifall användaren markerade sådana.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		// Tilldela g2-objektet till PrimitivesPainter-instansen
		// Anrop rit-metoden i FigurePainter-instansen.
		build.getPrimitivesPainter().setGraphics(g2);
		build.getFigurePainterImpl().paintAll();
		
		// Rit-exempel: Ritar ut en linje från pixel med position (10, 10)
		// till pixel med position (790, 590):
//		g2.drawLine (200, 200, 1000, 800);
//		g2.fillOval((int)300, (int)300, 3, 3);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Behövs för DrawingPanel är en MouseListener.
		repaint ();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Behövs för DrawingPanel är en MouseListener.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Behövs för DrawingPanel är en MouseListener.
	}

	/**
	 * Används för att registrera om användaren började
	 * att markera positioner i kartan.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// Behövs för DrawingPanel är en MouseListener.
		
		// Användaren markerade startpunkten -
		// den måste registreras!
		// Man får tag på koordinaterna genom
		// att anropa e.getX() resp. e.getY().
	}

	/**
	 * Används för att registrera om användaren avslutade
	 * att markera positioner i kartan.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// Behövs för DrawingPanel är en MouseListener.
		
		// Användaren markerade slutpunkten -
		// den måste registreras!
		// Man får tag på koordinaterna genom
		// att anropa e.getX() resp. e.getY().
		
		// Anropa här koden för att beräkna
		// distans och bäring!
		
		// Rita ut bilden på nytt, nu med linjen
		// och start-/slutpunkt.
		repaint ();
	}
}
