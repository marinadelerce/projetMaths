package Courbes;

/**
 * methods/CirclePanel.java - Component to draw circles.
 * This class functions as a GUI component, and can be added to a layout.
 * @version 22 June 1998, revised July 1999,  2002-02-07 JPanel
 * @author Fred Swartz
 */

import java.awt.*;
import javax.swing.*;

public class Circle extends JPanel {

	// =========================================== constructor
	public Circle() {
		setPreferredSize(new Dimension(100, 100));
		setBackground(Color.white);
	}// end constructor

	// =========================================== paintComponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCircles(g, 23, 200, 200, 200);
	}// end paintComponent

	// ========================================== drawCircle
	// Convenience method to draw from center with radius
	public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
		cg.drawOval(xCenter - r, yCenter - r, 2 * r, 2 * r);
	}// end drawCircle

	public void drawCircles(Graphics cg, int k, int xCenter, int yCenter, int r) {
		if(k!=0){
			drawCircle(cg, xCenter, yCenter, r);

			drawCircles(cg, k-1, (int) (xCenter + 1.5 * r), yCenter, r / 2);
			drawCircles(cg, k-1, xCenter, (int) (yCenter + 1.5 * r), r / 2);
		}
	}
} // end class CirclePanel
