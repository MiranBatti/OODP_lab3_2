package logic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import gui.DrawingPanel;

public class ExportImage {
	
	BufferedImage awtImage;
	
	public ExportImage(DrawingPanel drawingPanel) {
		BufferedImage bi = new BufferedImage(drawingPanel.getSize().width, drawingPanel.getSize().height, BufferedImage.TYPE_INT_ARGB); 
    	Graphics2D g = bi.createGraphics();
    	drawingPanel.paint(g);
    	g.dispose();
	}
	
	public void exportJPEG() {
		try {
			JOptionPane.showMessageDialog(null, "Något fel inträffade, ingen bild skapades.", null, JOptionPane.CLOSED_OPTION);
			ImageIO.write(awtImage, "jpg", new File("figures.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Något fel inträffade, ingen bild skapades.", null, JOptionPane.CLOSED_OPTION);
		}
	}
	
	public void exportPNG(Graphics2D g2) {
		g2.dispose();
		g2.drawImage(awtImage, null, 0, 0);
		try {
			ImageIO.write(awtImage, "png", new File("figures.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Något fel inträffade, ingen bild skapades.", null, JOptionPane.CLOSED_OPTION);
		}
	}
	
}
