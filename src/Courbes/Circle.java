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
		drawCircles2(g, 3, this.getWidth() / 2, this.getHeight() / 2, 50);
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

	public int sommeRayons(int r, int k) {
		float res = r;
		for (int i = 1; i < k; i++) {
			res += r / (2*i);
		}
		return (int) res;
	}

	public void drawCircles2(Graphics cg, int k, int xCenter, int yCenter, int r) {
		int xCenterInit = xCenter, yCenterInit = yCenter;
		if (Math.abs(xCenter - sommeRayons(r, k)) > 0) {

			if (k == 0) {
				drawCircle(cg, xCenter, yCenter, r);
			} else {
				drawCircle(cg, xCenter, yCenter, r);
				drawCircles2(cg, k - 1, (int) (xCenter + 1.5 * r), yCenter,
						r / 2);
				drawCircles2(cg, k - 1, xCenter, (int) (yCenter + 1.5 * r),
						r / 2);
				drawCircles2(cg, k - 1, (int) (xCenter - 1.5 * r), yCenter,
						r / 2);
				drawCircles2(cg, k - 1, xCenter, (int) (yCenter - 1.5 * r),
						r / 2);
			}
		}
	}
}