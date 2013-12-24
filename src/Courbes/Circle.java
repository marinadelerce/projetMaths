package Courbes;

import java.awt.*;
import javax.swing.*;

public class Circle extends JPanel {

	public Circle() {
		setPreferredSize(new Dimension(100, 100));
		setBackground(Color.white);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCircles2(g, 4, this.getWidth() / 2, this.getHeight() / 2, 50, 50);
	}

	public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
		cg.drawOval(xCenter - r, yCenter - r, 2 * r, 2 * r);
	}

	public void drawCircles(Graphics cg, int k, int xCenter, int yCenter, int r) {
		if (k == 0) {
			drawCircle(cg, xCenter, yCenter, r);
		} else {
			drawCircle(cg, xCenter, yCenter, r);
			drawCircles(cg, k - 1, (int) (xCenter + 1.5 * r), yCenter, r / 2);
			drawCircles(cg, k - 1, xCenter, (int) (yCenter + 1.5 * r), r / 2);
		}
	}

	public int distance(int xA, int yA, int xB, int yB) {
		return (int) Math.hypot(xB - xA, yB - yA);
	}

	public void drawCircles2(Graphics cg, int k, int xCenter, int yCenter,
			int r, int sumRadius) {
		if (k > 1) {
			drawCircle(cg, xCenter, yCenter, r);
			System.out.println(distance(xCenter - r / 2, yCenter - r / 2, this.getWidth() / 2,
					this.getHeight() / 2) <= sumRadius);
			if (distance(xCenter - r / 2, yCenter - r / 2, this.getWidth() / 2,
					this.getHeight() / 2) <= sumRadius) {
				drawCircle(cg, xCenter, yCenter, r);
				drawCircles2(cg, k - 1, (int) (xCenter + 1.5 * r), yCenter,
						r / 2, (int) (r * 1.5));
				drawCircles2(cg, k - 1, xCenter, (int) (yCenter + 1.5 * r),
						r / 2, (int) (r * 1.5));
				drawCircles2(cg, k - 1, (int) (xCenter - 1.5 * r), yCenter,
						r / 2, (int) (r * 1.5));
				drawCircles2(cg, k - 1, xCenter, (int) (yCenter - 1.5 * r),
						r / 2, (int) (r * 1.5));
		}
		}}
}