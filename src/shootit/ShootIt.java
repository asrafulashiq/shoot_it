/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shootit;


public class ShootIt extends javax.swing.JFrame{

    private int PWIDTH = 500;
    private int PHEIGHT = 500;
    
    public static void main(String[] args) {
        new ShootIt();
    }
    
    public ShootIt(){
        
        GamePanel panel = new GamePanel();
        this.add(panel);
        
        this.setSize(this.PWIDTH,this.PHEIGHT);
        this.setLocation(100,100);
        //this.setPreferredSize(new java.awt.Dimension(this.PWIDTH,this.PHEIGHT));
        this.setVisible(true);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
    }
}
