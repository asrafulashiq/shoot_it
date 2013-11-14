
package shootit;


public class ShootIt extends javax.swing.JFrame{

    private int PWIDTH = 700;
    private int PHEIGHT = 700;
    
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
