
package shootit;

import java.awt.*;
import java.util.Random;

public class Obstacle {
    
    private static final int LEFT = 1;
    private static final int RIGHT = -1;
    private int orient ;
    
    public int x;
    public int y;
    
    public static int dx=5;
    
   
    
    private Random rand = new Random();
    
    public GamePanel gp ;
    
    public int RX =20;
    public int RY =18;
    
    public Obstacle(GamePanel gp){
        this.gp = gp;
        this.setPos();
    }
    
    
    private  void setPos(){
        int w = gp.getWidth();
        int h = gp.getHeight();
        
        int tmp = rand.nextInt()%2;
        if(tmp==0){
            this.x = w;
            this.orient = LEFT;
        }
        else{
            this.x = 0;
            this.orient = RIGHT;
        }
        
        this.y = (int)(
                (.4*h)*rand.nextFloat()+.1*h
                );
        
    }
    
    /*
     * draw in the graphics
     */
    public void draw(Graphics g){
        g.setColor(Color.CYAN);
        g.fillOval(x-RX, y-RY, 2*RX, 2*RY);
        g.setColor(Color.LIGHT_GRAY);
        g.drawOval(x-RX, y-RY, 2*RX, 2*RY);
        
        
    }
    
    /*
     * speed of the obstacle - slow, medium , fast, faster
     */
    public static void increaseSpeed(){
        
        dx++;
        if(dx>10){
            dx=10;
        }
    }
    
    
    
    
    public void run(){
       this.x-=(this.orient)*dx;
    }
    
    /*
     * check bound
     */
    
    public boolean inRange(){
        if(this.x<=0)return false;
        else if(this.x>gp.getWidth())return false;
        else return true;
    }
    
    /*
     * check if the bomb hits the obstacle
     */
    public boolean hit(Point p){
        int bx = p.x;
        int by = p.y;
        if(bx>this.x-RX && bx< x+RX && by>y-RY && by < y+RY )
            return true;
        return false;
    }
    
}
