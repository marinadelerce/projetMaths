package Courbes;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Circle circle = new Circle();
		frame.setContentPane(circle);
		
		frame.setSize(1000, 1500);
		frame.setVisible(true);

	}

}
