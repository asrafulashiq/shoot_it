
package shootit;
import java.awt.*;
import javax.swing.*;

/**
 * class for the shooter object
 *  there is only one shooter object in the game
 */
public class Shooter {
    
    public int x,y;
    public GamePanel gp;
    private int len = 40;
    
    private int dx=9;
    
    public Shooter(GamePanel gp){
        //this(gp.getWidth()/2 , gp.getHeight());
        this.gp = gp; 
        this.x = gp.getWidth()/2;
        this.y = gp.getHeight()-100;
        
    }
    
    public Shooter(int x , int y){
         this.x = x;
         this.y = y;
    }
    
    /*
     * shoot a bomb
     */
    public void shoot(){
        this.gp.bombs.add(new Bomb(this,x,y-len-10));
    }
    
    /*
     * set the position of the shooter
     */
    public void setPos(int x , int y){
        this.x = x;
        this.y= y;
    }
    
    public Point getPos(){
        return new Point(x,y);
    }
    
    /*
     * left move
     */
    public void moveLeft(){
        this.x-=dx;
        
    }
    
    /*
     * right move
     */
    public void moveRight(){
        this.x+=dx;
    }
    
    /*
     * draw in graphics
     */
    public void draw(Graphics g){
        g.setColor(new Color(200,230,190));
        g.fill3DRect(x-len/2, y-len/2 ,len,len,true);
        g.setColor(new Color(100,100,110));
        g.fill3DRect(x-5,y-len, 10, len/2,true);
        
    }
}
