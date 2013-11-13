/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shootit;

import java.awt.*;

/**
 *
 * @author mac
 */
public class Obstacle {
    
    private String orient = "LEFT";
    private String speed = "SLOW";
    public int x;
    public int y;
    public int dx=5;
    
    public GamePanel gp ;
    
    public int RX =20;
    public int RY =18;
    
    public Obstacle(GamePanel gp){
        this.gp = gp;
        this.setPos();
    }
    
    
    private  void setPos(){
        this.x = gp.getWidth();
        this.y = gp.getHeight()/10;
    }
    
    /*
     * draw in the graphics
     */
    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x-RX, y-RY, 2*RX, 2*RY);
    }
    
    /*
     * speed of the obstacle - slow, medium , fast, faster
     */
    public void setSpeed(){
        
    }
    
    /*
     * set orientation - left or right
     */
    public void setOrientation(){
        
    }
    
    /*
     * 
     */
    public void run(){
       this.x-=dx;
    }
    
    /*
     * check bound
     */
    
    public boolean inRange(){
        if(this.x<=0)return false;
        else return true;
    }
    
}
