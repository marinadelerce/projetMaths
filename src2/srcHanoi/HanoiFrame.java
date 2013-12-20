/* PROJET MATHEMATIQUES DISCRETES 2006
 * Hanoi.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;

/**
 * @author Jane Tournois
 * ELEVES:
 */
public class HanoiFrame extends JFrame {
    
   private int nbEtages;
    
   public AxeDeHanoi axeA = new AxeDeHanoi(250);
   public AxeDeHanoi axeB = new AxeDeHanoi(550);
   public AxeDeHanoi axeC = new AxeDeHanoi(850);
       
    /** Creates a new instance of Hanoi */
    public HanoiFrame() {
        super("Tours de Hanoi");
        
        //pour fermer en cliquant sur la croix
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //mise en page
        this.setSize(1150,750);
        //centrer la fenetre dans l'ecran
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width)/2,
                (screen.height - this.getSize().height)/2);
    
        //la question: COMBIEN D'ETAGES?
        int etages = -1;
        while(etages == -1 || etages > 20)
        {
            String reponse = " ";
            reponse = JOptionPane.showInputDialog(null, "Combien d'etages doivent avoir les tours de Hanoi? " +
                    "(Entrez un entier entre 1 et 20)");
            if(reponse == null){System.exit(0); }
            else{
                try{ etages = Integer.parseInt(reponse); }
                //dans le cas ou l'utilisateur entre une valeur qui n'est pas un entier, ou pas un nombre
                catch(java.lang.NumberFormatException e){
                    int confirm = JOptionPane.showConfirmDialog(null, "Nombre entre non valide. Nouvel essai?",
                            "Erreur de saisie",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.ERROR_MESSAGE);
                    if(confirm == 1){System.exit(0);} //reponse NO
                    else{continue;}
                }
            }
        }
        this.nbEtages = etages;
        //initialiser la tour A
        for(int i = this.nbEtages; i > 0; --i){
          axeA.pushBack(new Integer(i));  
        }
        //zone de dessin
        HanoiPanel hanoiPane = this.makeHanoiPanel(etages);
        this.setContentPane(hanoiPane);
        
        this.pack();
        this.show();

	toursDeHanoi(etages);
    }
    
    /**
     *@param n le nombre d'etages a deplacer
     *@return HanoiPanel les tours de Hanoi, dessinees dans un JPanel
     */    
    private HanoiPanel makeHanoiPanel(int n){
        HanoiPanel pane = new HanoiPanel(this);
	//pane.repaint();
	//pause(1000);
        return pane;
    }
    
    /**TODO
     */    
    private void toursDeHanoi(int n){
        this.toursDeHanoi(n, this.axeA, this.axeB, this.axeC);
    }
    
    /**TODO
    */
    private void toursDeHanoi(int n, AxeDeHanoi a, AxeDeHanoi b, AxeDeHanoi c){
        if(n>0) {
	    toursDeHanoi(n-1,a,c,b);
	    b.pushBack(a.removeTop());
	    repaint();
	    pause(1000);
	    toursDeHanoi(n-1,c,b,a);
	}
    }

    private static void pause(int n) {
	try {
	    Thread.sleep(n);
	} catch(InterruptedException e){
	    e.printStackTrace();
	}
    }
    
       
    public int getNb(){
        return nbEtages;
    }
       

    @Override
            public Dimension getPreferredSize(){
        return new Dimension(1150,750);
    }    
    
    
    //MAIN
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Impossible d'utiliser le systeme look and feel: "+e);        
        }
        HanoiFrame hanoiTours = new HanoiFrame();
    }
}



class AxeDeHanoi extends Stack<Integer>{
   
    private int xCoord;
    private int nbEtages = 0;
    
    public AxeDeHanoi(int x){
        this.xCoord = x;
    }
    public int x(){
        return this.xCoord;
    }
    public int taille(){ //size() est heritee de Vector (mere de Stack)
        return nbEtages;
    }
    
    public void pushBack(Integer n){
        Integer i = this.push(n);
        nbEtages++;
    } 
    
    public Integer removeTop(){
       nbEtages--;
       return (Integer)(super.pop());
    }
            
}
