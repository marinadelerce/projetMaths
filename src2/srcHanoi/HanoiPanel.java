/* PROJET MATHEMATIQUES DISCRETES 2006
 * HanoiPanel.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Jane Tournois
 * ELEVES:
 */
public class HanoiPanel extends JPanel{
    
   private HanoiFrame hanoiFrame;
    
   private final int diskV = 8;
   private final int diskH = 10;
    
    /** Creates a new instance of HanoiPanel */
    public HanoiPanel(HanoiFrame frame){
        super();
        this.hanoiFrame = frame;
    }
    
    /**draws the content of HanoiPanel: the Hanoi Tours
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        this.drawHanoiTours(g);
    }
    
    /**erases the current drawing, draws the axes and the next state of the Hanoi Tours
     */
    private void drawHanoiTours(Graphics g){
        //pause(2000);
	g.clearRect(0,0,800,600);
        this.drawSupportsAndAxes(g);
        this.drawEtages(g);
	//pause(2000);
    }
    
    private static void pause(int n) {
	try {
	    Thread.sleep(n);
	} catch(InterruptedException e){
	    e.printStackTrace();
	}
    }

    /**draws the ground and to axes to put the disks on.
     */
    public void drawSupportsAndAxes(Graphics g){
        //le fond
        int[] x = {150,950,950,150};
        int[] y = {550,550,600,600};
        g.fillPolygon(x,y,4);
        //les axes
        int[] axe1_x = {245,255,255,245};
        int[] axes_y = {125,125,550,550};
        g.drawPolygon(axe1_x, axes_y, 4);
        int[] axe2_x = {545,555,555,545};
        g.drawPolygon(axe2_x, axes_y, 4);
        int[] axe3_x = {845, 855, 855, 845};
        g.drawPolygon(axe3_x, axes_y, 4);
    }
    
    /**draws the disks on each Hanoi Tour.
    */
   private void drawEtages(Graphics g){
       int nbDisques = hanoiFrame.getNb();
       int largeurDisque = 250;
       int nbA = 1;
       int nbB = 1;
       int nbC = 1;
       int i = nbDisques;
       while(i>0) {
	   if(hanoiFrame.axeA.search(i) != -1) {
	     g.drawRoundRect(125+(nbDisques-i+1)*5,550-nbA*20,largeurDisque-(nbDisques-i+1)*10,20,15,15);
	     nbA++;
	    }
	   if(hanoiFrame.axeB.search(i) != -1) {
	     g.drawRoundRect(425+(nbDisques-i+1)*5,550-nbB*20,largeurDisque-(nbDisques-i+1)*10,20,15,15);
	     nbB++;
	   }
	   if(hanoiFrame.axeC.search(i) != -1) {
	     g.drawRoundRect(725+(nbDisques-i+1)*5,550-nbC*20,largeurDisque-(nbDisques-i+1)*10,20,15,15);
	     nbC++;
	   }
	   //g.drawRoundRect(25+(nbDisques-i+1)*5,550-nbA*20,largeurDisque-(nbDisques-i+1)*10,20,10,10);
	   // nbA++;
	   //  g.drawRoundRect(50,550-i*20,100,20,10,10);
	   i--;
       }
   }
}
