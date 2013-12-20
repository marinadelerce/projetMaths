package Courbes;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		Circle circle = new Circle();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				frame.dispose();
				System.exit(0);
			}
		});
		frame.setContentPane(circle);
		
		frame.setSize(1500, 800);
		frame.setVisible(true);
	}

}
