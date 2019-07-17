import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2; 
    
    int currentState = MENU;
    
    Font titleFont;
    
    GamePanel() {
    	titleFont = new Font("Arial", Font.BOLD, 48);
    }
    
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	public void updateMenuState() { 
		
	}
	
	void updateGameState() { 
		
	}
	
	void updateEndState()  { 
		 
	}
	
	void drawMenuState(Graphics g) { 
		System.out.println("yeet");
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("yay", 0, 0);
	}
	
	void drawGameState(Graphics g) { 
		 
	}
	
	void drawEndState(Graphics g)  { 
		 
	}
}
