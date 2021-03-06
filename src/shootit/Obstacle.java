
package shootit;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class Obstacle {
    
    private static final int LEFT = 1;
    private static final int RIGHT = -1;
    private int orient ;
    private Color color ; 
    
    public int x;
    public int y;
    
    public static int dx;
    
    private Image img ;
   
    
    private Random rand = new Random();
    
    public GamePanel gp ;
    
    public int RX =50;
    public int RY =50;
    
    public Obstacle(GamePanel gp){
        this.gp = gp;
        dx=5;
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
        
        // set size
        this.RX = (rand.nextInt(10))+30;
        this.RY = (rand.nextInt(10))+30;
        color =  this.randColor();
        
       // String imgFile = "images/b1L.png";
        String imgFile = "images/ob1"+(this.orient==RIGHT? "L.png" : "R.png" );
        this.img = new ImageIcon(imgFile).getImage().getScaledInstance(2*RX,2* RY,Image.SCALE_SMOOTH);
        
    }
    
    /*
     * draw in the graphics
     */
    public void draw(Graphics g){
        //g.setColor(color);
        //g.fillOval(x-RX, y-RY, 2*RX, 2*RY);
        //g.setColor(Color.darkGray);
        //g.drawOval(x-RX, y-RY, 2*RX, 2*RY);
        
        g.drawImage(img, x-RX, y-RY, null);
        
        
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
    
    
    
    
    public void forward(){
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
        if(bx>this.x-RX+8 && bx< x+RX-8 && by>y-RY && by < y+RY )
            return true;
        return false;
    }
    
    /*
     * get random color
     */
    public Color randColor(){
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        
        return new Color(red,green,blue);
    }
    
}
