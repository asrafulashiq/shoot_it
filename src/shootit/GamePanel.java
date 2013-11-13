/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shootit;

/**
 *
 * @author mac
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener{
    
    
    private int PWIDTH = 500;
    private int PHEIGHT = 500 ;
    public boolean pause = false;
    public boolean run = false;
    
    public Shooter shooter;
    public ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    private Obstacle obs =null;
    
    
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
       obs  = new Obstacle(this);
       
       this.addKeyListener(new MyKeyListener());
       this.startGame();
       
    }
    
    /*
     * start the game
     */
    private void startGame(){
       
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
    }
    
    /*
     * update the game states
     */
    public void gameUpdate(){
        
        // forwarding the bomb
        if(this.bombs.size()!=0){
            for(Bomb b:bombs){
                b.forward();
            }
            
        }
        
        
        // deleting out of bound bombs
        for(java.util.Iterator<Bomb> i=this.bombs.iterator();i.hasNext();){
            Bomb elm = i.next();
            if(!elm.inFrame()){
                i.remove();
            }
        }
        
        // forwarding the obstacle
        this.obs.run();
        if(!this.obs.inRange()){
            obs=new Obstacle(this);
        }
        
        
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
        
        
        
       if(this.obs!=null) this.obs.draw(g);
        
        
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
