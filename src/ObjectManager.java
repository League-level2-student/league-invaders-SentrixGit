import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship roket;
	ArrayList<Projectile> destroy = new ArrayList <Projectile>();
	ArrayList<Alien> aliens = new ArrayList <Alien>();
	
	ObjectManager(Rocketship rrrr) {
		roket = rrrr;
	}
	
	void addProjectile(Projectile p) {
		//add stuffies
	}
	
	void addAlien() {
		aliens.add(new Alien(new Random().nextInt(LeagueInvaders.WIDTH),0,100,100));
	}
	
	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < destroy.size(); i++) {
			destroy.get(i).update();
		}
		checkCollision();
		purgeObjects();
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
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		
		for (int i = 0; i < destroy.size(); i++) {
			if (destroy.get(i).isActive == false) {
				destroy.remove(i);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		addAlien();
	}
	
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (roket.collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive = false;
			}
		}
	}
	
}