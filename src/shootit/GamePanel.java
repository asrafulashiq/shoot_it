
package shootit;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener{
    
    
    private int PWIDTH = 700;
    private int PHEIGHT = 700 ;
    public boolean pause = false;
    public boolean run = false;
    
    public Shooter shooter;
    public ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    //public ArrayList<Obstacle> obs = new ArrayList<Obstacle>();
    
    //private Obstacle obs =null;
    
    
    // variables for game states
    public int destroyedObs = 0;
    public long timePassed = 0;
    public long initialTime ; 
    public long currentTime ; 
    
    private Timer timer= new Timer(50,this);
    
    @Override
    public void actionPerformed(ActionEvent e){
        this.run();
    }
    
    public GamePanel(){
        
       this.setSize(this.PWIDTH,this.PHEIGHT);
       //System.out.print(this.getWidth());
       //this.setPreferredSize(new Dimension(this.PWIDTH,this.PHEIGHT));
       
       this.setFocusable(true);
       this.requestFocus();
       shooter = new Shooter(this);
       //obs  = new Obstacle(this);
       
       this.addKeyListener(new MyKeyListener());
       this.startGame();
       
    }
    
    /*
     * start the game
     */
    private void startGame(){
       
      // obs.add(new Obstacle(this));
       this.initialTime = System.currentTimeMillis();
       this.timer.start();
        
    }
    
    /*
     * exit the game
     */
    private void exitGame(){
        
    }
    
    /*
     * pause for a while
     */
    public void pauseGame(){
        
    }
    
    /*
     * running of the animation loop
     */
    public void run(){
        this.gameRender();
        this.gameUpdate();
        this.printScreen();
        
        try{
            Thread.sleep(10);
        }
        catch(InterruptedException ex){
            
        }
    }
    
    /*
     * update the game states
     */
    public synchronized void gameUpdate(){
        
        // forwarding the obstacle
        /*for(java.util.Iterator<Obstacle> i =this.obs.iterator();i.hasNext();){
            Obstacle o = i.next();
            
            if(!o.inRange()){
                i.remove();
            }
        }
        */
        
        // deleting out of bound bombs
        
        for(java.util.Iterator<Bomb> i=this.bombs.iterator();i.hasNext();){
            Bomb elm = i.next();
                    
            elm.forward();
            if(!elm.inFrame()){
                i.remove();
            }
           
           
            
        }
        
        
        
        // if bomb hits the obstacle then destroy
        
        
    }
    
    /*
     * rendering game states for printing
     */
    public void gameRender(){
        
    }
    
    /*
     * draw the game in the canvas
     */
    public void printScreen(){
        
        Graphics g = this.getGraphics();
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(new Color(30,30,50));
        g.fillRect(0, 0, getWidth(), getHeight());
        this.shooter.draw(g);
        
        if (this.bombs.size()!=0)
        for(Bomb b : this.bombs){
            b.draw(g);
        }
        
        
       
        
        
    }
    
    /*
     * show information after game over
     */
    public void gameOver(){
        
    }
    
    /*
     * key event listener
     */
    
    private class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    shooter.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    shooter.moveRight();
                    break;
                case KeyEvent.VK_SPACE:
                    shooter.shoot();
                    break;
            }
        }
    }
}
