import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2; 
    
    Timer frameDraw;
    Timer alienSpawn;
    
    int currentState = MENU;
    
    // Rocketship object
    int X = 250;
    int Y = 700;
    int sizeX = 50;
    int sizeY = 50;
    
    Rocketship bob = new Rocketship(X, Y, sizeX, sizeY);
    ObjectManager Manager = new ObjectManager(bob);
    
    Font titleFont;
    Font lowerFont1;
    
    GamePanel() {
    	titleFont = new Font("Avenir Next", Font.BOLD, 28);
    	lowerFont1 = new Font("Avenir Next", Font.PLAIN, 16);
    	
        frameDraw = new Timer(1/30,this);
        frameDraw.start();
    }
    
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(new Color(15,15,15));
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		if(currentState == MENU){
		    drawMenuState(g);
		    updateMenuState();
		}else if(currentState == GAME){
		    drawGameState(g);
		    updateGameState();
		}else if(currentState == END){
		    drawEndState(g);
		    updateEndState();
		}
	}
	
	public void updateMenuState() { 
		
	}
	
	void updateGameState() { 
		Manager.update();
	}
	
	void updateEndState()  { 
		 
	}
	
	void startGame() {
		bob.isActive = true;
		alienSpawn = new Timer(1000, Manager);
		alienSpawn.start();
	}
	
	void drawMenuState(Graphics g) { 
		Random random = new Random();
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Space Invaders", 800, 50);
		
		g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		
		g.drawString("Press enter to start!", 850, 900);
	}
	
	void drawGameState(Graphics g) { 
		 //new GameObject(X, Y, sizeX, sizeY);.
		Manager.draw(g);
		bob.draw(g);
		
		if (bob.isActive == false) {
			currentState = END;
		}
	}
	

	void drawEndState(Graphics g)  {
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Space Invaders", 800, 50);
		g.drawString("Oh no! You lost. Your score was:" + ". Press enter to restart", 850, 900);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		    if (currentState == GAME) {
		    	Manager.addProjectile(Manager.roket.getProjectile());
		    }
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState != GAME) {
				startGame();	
				currentState = GAME;
			} else {
				//Manager.addProjectile(bob.getProjectile());
			}
		}
		
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				bob.up();
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				bob.down();
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				bob.right();
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				bob.left();
				
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
