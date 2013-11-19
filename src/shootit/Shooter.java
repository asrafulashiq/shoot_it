
package shootit;
import java.awt.*;
import javax.swing.*;

/* class for the shooter object
 *  there is only one shooter object in the game
 */
public class Shooter {
    
    public int x,y;
    public GamePanel gp;
    private int len = 100;
    
    private int dx=9;
    
    private Image img , backImg;
    
    public Shooter(GamePanel gp){
        //this(gp.getWidth()/2 , gp.getHeight());
        this.gp = gp; 
        this.x = gp.getWidth()/2;
        this.y = gp.getHeight()-150;
        
        img = new ImageIcon("images/plane.png").getImage();
        //img = new ImageIcon(getClass().getResource("images/plane.png")).getImage();
        img = img.getScaledInstance(len, len, Image.SCALE_SMOOTH);
        this.backImg = new ImageIcon("images/back.jpg").getImage();
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
        //g.setColor(new Color(200,230,190));
        //g.fill3DRect(x-len/2, y-len/2 ,len,len,true);
        //g.setColor(new Color(100,100,110));
        //g.fill3DRect(x-5,y-len, 10, len/2,true);
        g.drawImage(backImg,0,0,null);
        g.drawImage(img, x-len/2, y-len/2,null);
    }
}
