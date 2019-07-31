import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	Rocketship(int xVal, int yVal, int widthVal, int heightVal) {
		super(xVal, yVal, widthVal, heightVal);
		speed = 10;
	}
	
	void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
	void up() { 
		y-=speed;
	}
	
	void down() { 
		y+=speed;
	}

	void left() { 
		x+=speed;
	}

	void right() { 
		x-=speed;
	}
}
