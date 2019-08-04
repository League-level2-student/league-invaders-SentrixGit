import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship roket;
	ArrayList<Projectile> destroy = new ArrayList <Projectile>();
	ArrayList<Alien> aliens = new ArrayList <Alien>();
	
	ObjectManager(int xVal, int yVal, int widthVal, int heightVal) {
		roket = new Rocketship(xVal,yVal,widthVal,heightVal);
	}
	
	void addProjectile(Projectile p) {
		
	}
	
	void addAlien() {
		aliens.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < destroy.size(); i++) {
			destroy.get(i).update();
		}
	}
	
	void draw(Graphics g) {
		roket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		
		for (int i = 0; i < destroy.size(); i++) {
			destroy.get(i).draw(g);
		}
	}
	
	void purgeObjects() {
		//for (int i = 0; i < aliens.size(); i++) {
		//	aliens.get(i).draw(g);
		//}
		
		//for (int i = 0; i < destroy.size(); i++) {
		//	destroy.get(i).draw(g);
		//}
	}
	
}