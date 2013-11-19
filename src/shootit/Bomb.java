
package shootit;

import java.awt.*;
import javax.swing.*;

/**
 * This is a bomb object
 */
public class Bomb {
    
    public int x; // x-coordinate
    public int y; // y-coordinate
    private String speed = "FAST";
    
    private Shooter sh;
    private static final int RADIUS = 5;
    
    private Image img ;
    
    
    /*
     * constructor with initial coordinate
     */
    public Bomb(Shooter sh , int x, int y){
        this.sh = sh;
        this.x=x;
        this.y=y;
        
        img = new ImageIcon("images/b1.png").getImage().getScaledInstance(15, 30, Image.SCALE_SMOOTH);
        
    }
    
    /*
     * draw the bomb in the graphics
     */
    public void draw(Graphics g){
        g.setColor(Color.RED);
        //g.fillOval(x-RADIUS/2, y-RADIUS/2, 2*RADIUS, 2*RADIUS);
        g.drawImage(img, x-5, y+40, null);
    }
    
    
    
    /*
     * get position of the bomb
     */
    public Point getPos(){
        return new Point(x,y);
    }
    
    /*
     * update position of the bomb
     */
    public void forward(){
        
        int dy;
        
        if("SLOW".equals(speed)) dy=10;
        else if("MEDIUM".equals(speed)) dy = 15;
        else if("FAST".equals(speed)) dy = 17;
        else dy = 20;
        
        this.y-=dy;
            
    }
    
    /*
     * set speed of the bomb
     * speed variavles are - slow,medium , fast , faster
     */
    public void setSpeed(String speed){
        
    }
    
    /*
     * if the bomb is in the frame
     */
    public boolean inFrame(){
        int h = this.sh.gp.getHeight();
        int h1 = this.y;
        if(h1<=0)return false;
        else return true;
    }
      
}
