
package shootit;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GamePanel extends JPanel implements ActionListener{
    
    private Image img = new ImageIcon("images/back.jpg").getImage();
    
    private int PWIDTH = 700;
    private int PHEIGHT = 700 ;
    //public boolean pause = false;
    public boolean run = false;
    
    public Shooter shooter;
    public ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    //public ArrayList<Obstacle> obs = new ArrayList<Obstacle>();
    
    private Obstacle obs =null;
    
    
    // variables for game states
    public int destroyedObs = 0;
    public long timePassed = 0;
    public int shootNum = 0;
    public long initialTime ; 
    public long currentTime ; 
    
    private Timer timer= new Timer(50,this);
    
    @Override
    public void actionPerformed(ActionEvent e){
        this.run();
    }
    
    public GamePanel(int w, int h){
        
       this.PWIDTH = w;
       this.PHEIGHT = h;
       this.setSize(this.PWIDTH,this.PHEIGHT);
       //System.out.print(this.getWidth());
       //this.setPreferredSize(new Dimension(this.PWIDTH,this.PHEIGHT));
       
       this.setFocusable(true);
       this.requestFocus();
       shooter = new Shooter(this);
       //obs.add (new Obstacle(this) );
       obs = new Obstacle(this);
       
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
       //this.run(); 
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
        run = false;
    }
    
    public void resumeGame(){
        run = true;
    }
    
    /*
     * running of the animation loop
     */
    public void run(){
        if(run){
        this.gameRender();
        this.gameUpdate();
        this.printScreen();
        
        try{
            Thread.sleep(5);
        }
        catch(InterruptedException ex){
            
        }
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
        
        for(Iterator<Bomb> i=this.bombs.iterator();i.hasNext();){
            Bomb elm = i.next();
            
            if(obs!=null){
                if(obs.hit(elm.getPos())){
                    this.destroyedObs++;
                    obs = new Obstacle(this);
                }
            }
            
            elm.forward();
            if(!elm.inFrame()){
                i.remove();
            }
        }
        
        if(obs!=null){
            obs.forward();
            if(!obs.inRange()){
                obs = new Obstacle(this);
            }
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
        
        //g.drawImage(img, 0, 0,null);
        //g.setColor(new Color(130,130,150));
        //this.setBackground(new);
        g.fillRect(0, 0, getWidth(), getHeight());
        this.shooter.draw(g);
        
        if (!this.bombs.isEmpty())
        for(Bomb b : this.bombs){
            b.draw(g);
        }
        
        if(obs!=null)obs.draw(g);
        this.printPoint(g);
        
    }
    
    /*
     * calculate point
     */
    public void printPoint(Graphics g){
        g.setFont(new Font("Serif",Font.BOLD,15));
        g.setColor(Color.WHITE);
        g.drawString(
                
                String.format("%-10s : %d", "DESTROYED",this.destroyedObs)
                ,getWidth()-200,getHeight()-60);
        
        this.timePassed = (System.currentTimeMillis()-this.initialTime)/1000;
        g.drawString(
                String.format("%-15s : %d s","TIME",timePassed)
                ,getWidth()-200,getHeight()-40);
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
                    shootNum++;
                    break;
            }
        }
    }
}
