import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends JFrame implements KeyListener {
	
	private Thread thread;
    private boolean isLeft = false;
    private boolean isRight = false;
    private boolean isUp = false;
    private boolean isDown = false;
    private boolean pewpew = false;
    private boolean help1 = false;
    
    private int lastDirection;
    
    private int x, y;

	
	@Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT) {
        	isLeft = true;
        	if(!pewpew) lastDirection = 1;
        	}
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
        	isRight = true;
        	if(!pewpew) lastDirection = 2;
        	}
        if (e.getKeyCode()==KeyEvent.VK_UP) {
        	isUp = true;
        	if(!pewpew) lastDirection = 3;
        	}
        if (e.getKeyCode()==KeyEvent.VK_DOWN) {
        	isDown = true;
        	if(!pewpew) lastDirection = 4;
        	}
        	
        if (e.getKeyCode()==KeyEvent.VK_SPACE) {
        	
        	pewpew = true;
            bullets.add(CreateBullet());

        }
    	

        
    }
	
	public Bullet CreateBullet () {
		Bullet bullet = new Bullet();
		return bullet; 
	}
 
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT) isLeft = false;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) isRight = false;
        if (e.getKeyCode()==KeyEvent.VK_UP) isUp = false;
        if (e.getKeyCode()==KeyEvent.VK_DOWN) {
        	
        	isDown = false;
        }
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
    	

    }
	
	
    private Robot robot;
    private Bullet bullet;
    private Rock rock;

    public static void main(String[] args) {
        Game game = new Game();
    }

    public Game () {
        this.init();
        this.robot = new Robot();
        this.bullet = new Bullet();
        this.rock = new Rock();

        
    }
    
   

    private void init () {
        this.setVisible(true);
        this.setSize(Definitions.WINDOW_WIDTH, Definitions.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("My Game");
        
        this.addKeyListener(this);
        thread = new MoveThread(this);
        thread.start();


    }
    
    public void animate() {
    	
    	

        if (isLeft) robot.setX( robot.getX() - 2);
        if (isRight) robot.setX( robot.getX() + 2);
        if (isUp) robot.setY( robot.getY() - 2);
        if (isDown) robot.setY( robot.getY() + 2);
        if (pewpew) {
        	switch (lastDirection) {
			case 1:
				bullet.setX(bullet.getX() - 10);
				break;
			
			case 2:
				bullet.setX(bullet.getX() + 10);
				break;
			
			case 3:
				bullet.setY(bullet.getY() - 10);
				break;
				
			case 4:
				bullet.setY(bullet.getY() + 10);
				break;

			default:
				break;
				
			}
        }
        
        if(help1) {
        	if((bullet.getX() < 0 || bullet.getX()>1000 || bullet.getY() < 0 || bullet.getY() > 1000)) {
        		pewpew = false;
        		bullet.setX(robot.getX());
        		bullet.setY(robot.getY());
            }
        }
       
        
      
        
        if (!pewpew && help1) {
        	bullet.setX(robot.getX());
        	bullet.setY(robot.getY());
    	}
        
        
        
        this.repaint();
    }
    
    


    public void paint (Graphics graphics) {
        super.paint(graphics);
        this.robot.paint(graphics);
        this.bullet.paint(graphics);
    	this.rock.paint(graphics);


        
        help1 = true;
    }
    
    public void RrR() {
    
    }
    
    public void paint_rock(Graphics graphics) {
    	super.paint(graphics);
    	this.rock.paint(graphics);
        this.repaint();

    }
    
    
    
    private class MoveThread extends Thread{
        Game runKeyboard;
         
        public MoveThread(Game runKeyboard) {
            super("MoveThread");
            this.runKeyboard = runKeyboard;
        }
         
        public void run(){
            while(true) {
                runKeyboard.animate();

                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
