import java.awt.Graphics;

import javax.swing.*;

public class LeagueInvaders {
	JFrame Frame;
	
	GamePanel GamePanelInstance;
	
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	
	LeagueInvaders() {
		Frame = new JFrame();
		GamePanelInstance = new GamePanel();
		
		Frame.addKeyListener(GamePanelInstance);
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
