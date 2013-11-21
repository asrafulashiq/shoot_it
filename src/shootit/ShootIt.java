
package shootit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShootIt extends JFrame implements WindowListener{

    private int PWIDTH = 900;
    private int PHEIGHT = 700;
    GamePanel panel;
    
    public static void main(String[] args) {
        new ShootIt();
    }
    
    public ShootIt(){
        
        panel = new GamePanel(this.PWIDTH,this.PHEIGHT);
        this.add(panel);
        
        
        this.setTitle("Shoot It");
        this.setSize(this.PWIDTH,this.PHEIGHT);
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(this);
        
    }
    
    @Override
    public void windowActivated(WindowEvent e){
        panel.resumeGame();
    }
    
    @Override
    public void windowDeactivated(WindowEvent e){
        panel.pauseGame();
    }
    
    @Override
    public void windowIconified(WindowEvent e){
        panel.resumeGame();
    }
    
    @Override
    public void windowDeiconified(WindowEvent e){
        panel.pauseGame();
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        panel.gameOver();
    }
    
    @Override
    public void windowClosed(WindowEvent e){
        
    }
    
    @Override
    public void windowOpened(WindowEvent e){
        
    }
}
