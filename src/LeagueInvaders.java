import java.awt.Graphics;

import javax.swing.*;

public class LeagueInvaders {
	JFrame Frame;
	
	GamePanel GamePanelInstance;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	LeagueInvaders() {
		Frame = new JFrame();
		GamePanelInstance = new GamePanel();
		
		setup();
	}
	
	public static void main(String[] args) {
		LeagueInvaders LeagueInvadersInstance = new LeagueInvaders();
	}
	
	void setup() {
		// Game Panel Setup
		Frame.add(GamePanelInstance);
		
		// Frame setup
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(WIDTH, HEIGHT);
		Frame.setVisible(true);
	}
}
