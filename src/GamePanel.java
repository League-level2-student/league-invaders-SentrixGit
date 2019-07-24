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
    
    int currentState = MENU;
    
    Font titleFont;
    Font lowerFont1;
    
    GamePanel() {
    	titleFont = new Font("Avenir Next", Font.BOLD, 28);
    	lowerFont1 = new Font("Avenir Next", Font.PLAIN, 16);
    	
        frameDraw = new Timer(1000/60,this);
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
		    updateMenuState();
		}else if(currentState == END){
		    drawEndState(g);
		    updateMenuState();
		}
	}
	
	public void updateMenuState() { 
		
	}
	
	void updateGameState() { 
		
	}
	
	void updateEndState()  { 
		 
	}
	
	void drawMenuState(Graphics g) { 
		Random random = new Random();
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Space Invaders OG Remake", 800, 50);
		
		g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		
		g.drawString("Press space to start", 850, 900);
	}
	
	void drawGameState(Graphics g) { 
		 
	}
	
	void drawEndState(Graphics g)  { 
		 
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState != GAME) {
				if (currentState != END) {
					currentState = GAME;
					System.out.println("YAY");
				}
			}
		}
		
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
			    System.out.println("UP");
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
