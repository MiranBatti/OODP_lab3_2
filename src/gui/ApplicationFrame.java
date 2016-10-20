package gui;

/*
 * OODP, laboration 3
 *
 * ControlPanel.java
 *
 * Peter Jenke, 2015-01-10
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.ExportImage;

@SuppressWarnings("serial")
public class ApplicationFrame extends JFrame {
	
	DrawingPanel drawingPanel;
	ExportImage exportImg;
	
	public ApplicationFrame (String title) throws HeadlessException {
		super (title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize (new Dimension (1200, 820));

		// mainPanel innehåller
		// - DrawingPanel - en JPanel där figurerna ritas ut
		// - ControlPanel - en JPanel som innehåller styrelementen
		JPanel mainPanel = new JPanel ();
		mainPanel.setLayout(new BorderLayout());
		add(mainPanel);

		drawingPanel = new DrawingPanel();
		
		ControlPanel controlPanel = new ControlPanel(drawingPanel);
		
		mainPanel.add(drawingPanel, BorderLayout.CENTER);
		mainPanel.add(controlPanel, BorderLayout.SOUTH);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportJPEG = new JMenuItem("Export JPEG");
		JMenuItem exportPNG = new JMenuItem("Export PNG");
		exportJPEG.addActionListener(new ExportJPEGListener());
		exportPNG.addActionListener(new ExportPNGListener());
		fileMenu.add(exportJPEG);
		fileMenu.add(exportPNG);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);

		pack();
		setVisible(true);
	}
	
	private class ExportJPEGListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			BufferedImage bi = new BufferedImage(drawingPanel.getSize().width, drawingPanel.getSize().height, BufferedImage.TYPE_INT_ARGB); 
	    	Graphics2D g = bi.createGraphics();
	    	drawingPanel.paint(g);
	    	g.dispose();
	    	try {
	    		ImageIO.write(bi, "png", new File("figures.jpg"));
	    	} catch (Exception ex) {
	    		JOptionPane.showMessageDialog(null, "Något fel inträffade, ingen bild skapades.", null, JOptionPane.CLOSED_OPTION);
	    	}
		}	
	}

	private class ExportPNGListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			BufferedImage bi = new BufferedImage(drawingPanel.getSize().width, drawingPanel.getSize().height, BufferedImage.TYPE_INT_ARGB); 
	    	Graphics2D g = bi.createGraphics();
	    	drawingPanel.paint(g);
	    	g.dispose();
	    	try {
	    		ImageIO.write(bi, "png", new File("figures.png"));
	    	} catch (Exception ex) {
	    		JOptionPane.showMessageDialog(null, "Något fel inträffade, ingen bild skapades.", null, JOptionPane.CLOSED_OPTION);
	    	}
		}	
	}
	
}
