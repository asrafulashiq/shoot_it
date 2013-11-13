/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shootit;

import java.awt.*;

/**
 * This is a bomb object
 */
public class Bomb {
    
    public int x; // x-coordinate
    public int y; // y-coordinate
    private String speed = "SLOW";
    
    private Shooter sh;
    private static final int RADIUS = 5;
    
    
    /*
     * constructor with initial coordinate
     */
    public Bomb(Shooter sh , int x, int y){
        this.sh = sh;
        this.x=x;
        this.y=y;
    }
    
    /*
     * draw the bomb in the graphics
     */
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x-RADIUS/2, y-RADIUS/2, 2*RADIUS, 2*RADIUS);
    }
    
    /*
     * check if it hits the point p
     */
    public boolean hit(Point p){
        
        return true;
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
        
        if(speed=="SLOW") dy=2;
        else if(speed=="MEDIUM") dy = 5;
        else if(speed=="FAST") dy = 7;
        else dy = 10;
        
        this.y-=10;
            
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
