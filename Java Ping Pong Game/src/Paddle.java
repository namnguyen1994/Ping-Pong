import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {
	
	int id;
	int yVelocity;
	int speed = 10;
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id = id;
	}
	
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(-speed);
				move(); //allow you to set the W key to move the player 1 paddle up
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(speed);
				move(); //allow you to set the S key to move the player 1 paddle down
			}
			break; //stop the loop
			
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-speed);
				move(); //allow you to move player 2 paddle up
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(speed);
				move(); //allow you to move the player 2 paddle down
			}
			break;
		}
			
	}
	
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(0); // speed change to 0 to prevent it from keep moving
				move(); 
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(0);
				move(); 
			}
			break; 
			
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
				move();
			}
			break;
		}
			
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	
	public void move() {
		y = y + yVelocity;
	}
	
	public void draw(Graphics g) {
		if(id==1)
			g.setColor(Color.red); //set player1 paddle to red
		else
			g.setColor(Color.orange); //set player2 to orange
		g.fillRect(x, y, width, height);
	}
}
