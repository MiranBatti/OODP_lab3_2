package gui;

/*
 * OODP, laboration 3
 *
 * ControlPanel.java
 *
 * Peter Jenke, 2015-01-10
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.FigureBuilder;

/**
 * ControlPanel är en behållare för olika styrelement.
 * 
 * @author Peter.Jenke@hig.se
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel
{
	private DrawingPanel dp;
	private DialogCreator dc;
	private FigureBuilder build;

	/**
	 * Skapar en ny instans av ControlPanel.
	 */
	public ControlPanel (DrawingPanel dp)
	{
		this.dp = dp;
		build = dp.getFigureBuilder();
		
		JButton rotatePlusButton = new JButton("Rotate+");
		JButton rotateMinusButton = new JButton("Rotate-");
		JButton scaleUpButton = new JButton("Bigger");
		JButton scaleDownButton = new JButton("Smaller");
		JButton upButton = new JButton("↑");
		JButton downButton = new JButton("↓");
		JButton leftButton = new JButton("←");
		JButton rightButton = new JButton("→");
		JButton newPointButton = new JButton("New Point");
		JButton newLineButton = new JButton("New Line");
		JButton newRectangleButton = new JButton("New Rectangle");
		JButton newCircleButton = new JButton("New Circle");
		JButton newTriangleButton = new JButton("New Triangle");
		JButton newRemoveAllButton = new JButton("Remove All");
		
		rotatePlusButton.addActionListener(e -> {build.getFigureRotorImpl().rotateAll(5);
		build.getFigurePrinterImpl().printAll();
		dp.repaint();});
		rotateMinusButton.addActionListener(e -> {build.getFigureRotorImpl().rotateAll(-5);
		build.getFigurePrinterImpl().printAll();
		dp.repaint();});
		scaleUpButton.addActionListener(new ScaleUpListener());
		scaleDownButton.addActionListener(new ScaleDownListener());
		upButton.addActionListener(new MoveUpListener());
		downButton.addActionListener(new MoveDownListener());
		leftButton.addActionListener(new MoveLeftListener());
		rightButton.addActionListener(new MoveRightListener());
		newPointButton.addActionListener(new NewPointListener());
		newLineButton.addActionListener(new NewLineListener());
		newRectangleButton.addActionListener(new NewRectangleListener());
		newCircleButton.addActionListener(new NewCircleListener());
		newTriangleButton.addActionListener(new NewTriangleListener());
		newRemoveAllButton.addActionListener(new NewRemoveAllListener());
		
		add(rotatePlusButton);
		add(rotateMinusButton);
		add(scaleUpButton);
		add(scaleDownButton);
		add(leftButton);
		add(upButton);
		add(downButton);
		add(rightButton);
		add(newPointButton);
		add(newLineButton);
		add(newRectangleButton);
		add(newCircleButton);
		add(newTriangleButton);
		add(newRemoveAllButton);
		
		dc = new DialogCreator();
	}
	
	// Uppgifter:
	// Skapa metoder som kan användas för att tilldela handler-objekt
	// till ControlPanel-instansen.
	
	// Lyssnare-klasser som nedan följer fångar upp händelser som genereras
	// när användaren trycker på en knapp.
	// I varje actionPerformed-metod måste det finnas ett metodanrop
	// som t.ex. rotateAll eller moveAll. Man måste alltså ha tillgång
	// till objekt som definierar metoderna.
	private class RotatePlusListener implements ActionListener
	{
		/**
		 * Metoden anropas när 'Rotate+'-knappen aktiveras.
		 */
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Rotation 5 grader
			build.getFigureRotorImpl().rotateAll(5);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}

	private class RotateMinusListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Rotation -5 grader
			build.getFigureRotorImpl().rotateAll(-5);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}

	private class ScaleUpListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Skalning, faktor 1.05 i x and y, 
			build.getFigureScalorImpl().scaleAll(1.05, 1.05);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}

	private class ScaleDownListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Skalning, faktor 0.95 i x and y, 
			build.getFigureScalorImpl().scaleAll(0.95, 0.95);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}

	private class MoveUpListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Flytta i positiv y-riktning med avstånd (0.0, 0.5)
			build.getFigureMoverImpl().moveAll(0, -0.5);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}

	private class MoveDownListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Flytta i negativ y-riktning med avstånd (0.0, -0.5)
			build.getFigureMoverImpl().moveAll(0, 0.5);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}

	private class MoveLeftListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Flytta i negativ x-riktning med avstånd (-0.5, 0.0)
			build.getFigureMoverImpl().moveAll(-0.5, 0);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}

	private class MoveRightListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Flytta i positiv x-riktning med avstånd (0.5, 0.0)
			build.getFigureMoverImpl().moveAll(0.5, 0);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}
	
	private class NewPointListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String mx = "x ";
			String my = "y ";
			double x = dc.createDoubleDialog(mx);
			double y = dc.createDoubleDialog(my);
			
			// Skapa en ny punkt genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			build.getFigureHandlerImpl().createPoint(x, y);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}
	
	private class NewLineListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String mx0 = "x0 ";
			String my0 = "y0 ";
			String mx1 = "x1 ";
			String my1 = "y1 ";
			double x0 = dc.createDoubleDialog(mx0);
			double y0 = dc.createDoubleDialog(my0);
			double x1 = dc.createDoubleDialog(mx1);
			double y1 = dc.createDoubleDialog(my1);

			// Skapa en ny linje genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			build.getFigureHandlerImpl().createLine(x0, y0, x1, y1);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}
	
	private class NewRectangleListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String mx0 = "Height ";
			String my0 = "Width ";
			String mx1 = "x ";
			String my1 = "y ";
			double height = dc.createDoubleDialog(mx0);
			double width = dc.createDoubleDialog(my0);
			double centerX = dc.createDoubleDialog(mx1);
			double centerY = dc.createDoubleDialog(my1);

			// Skapa en ny rektangel genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			build.getFigureHandlerImpl().createRectangle(height, width, centerX, centerY);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}
	
	private class NewCircleListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String mx = "x ";
			String my = "y ";
			String myRadius = "Radius ";
			double x = dc.createDoubleDialog(mx);
			double y = dc.createDoubleDialog(my);
			double radius = dc.createDoubleDialog(myRadius);
			// Skapa en ny cirkel genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			
			build.getFigureHandlerImpl().createCircle(x, y, radius);
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}
	
	private class NewTriangleListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String mx0 = "x0 ";
			String my0 = "y0 ";
			String mx1 = "x1 ";
			String my1 = "y1 ";
			String mx2 = "x2 ";
			String my2 = "y2 ";
			double x0 = dc.createDoubleDialog(mx0);
			double y0 = dc.createDoubleDialog(my0);
			double x1 = dc.createDoubleDialog(mx1);
			double y1 = dc.createDoubleDialog(my1);
			double x2 = dc.createDoubleDialog(mx2);
			double y2 = dc.createDoubleDialog(my2);
			
			// Skapa en ny triangel genom att anropa motsvarande metoden
			// FigureHandler-objektet.
			build.getFigureHandlerImpl().createTriangle(x0, y0, x1, y1, x2, y2);;
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}	
	}
	
	private class NewRemoveAllListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			build.getFigureHandlerImpl().removeAll();
			build.getFigurePrinterImpl().printAll();
			dp.repaint();
		}
		
	}

	private class DialogCreator
	{
		double createDoubleDialog (String msg)
		{
			String inValue = null;				// inmatad text
			String error_msg = "";				// felmeddelandet som visas om texten innehåller
												// andra tecken än bara siffror och en punkt
			double v = 0;
			
			while ((inValue = JOptionPane.showInputDialog (msg + error_msg + ":")) != null)
			{
				error_msg = "";
				
				/*
				Om texten innehåller något annat än siffror, så genereras en
				NumberFormatException. Vi vill inte att programmet avslutar
				och fångar den. Istället visas ett felmeddelande för användaren.
				*/
				try
				{
					v = Double.parseDouble (inValue);
					break;
				} catch (NumberFormatException nfe)
				{
					error_msg = " (Värden få bara bestå av siffror med decimaltecken)";
				}
			}

			return v;
		}
	}
}
