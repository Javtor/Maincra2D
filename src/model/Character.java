package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Character extends MovingSprite{

	private boolean front;
	
	public static int CHARACTER_WIDTH = 16;
	public static int CHARACTER_HEIGHT = 32;
	public static double FALLING_SPEED = 8;
	
	private Level currentLevel;
	
	private boolean falling;
		
	public Character(double x, double y, Level currentLevel) {
		super(x, y, 16, 32, "character_front.png");
		this.front = true;
		falling = true;
		this.currentLevel = currentLevel;
//		velY = 5;
	}
	
	@Override
	public void tick() {
		falling = isFalling();
		if(falling) {
			velY = FALLING_SPEED;
			
		} else {
			velY = 0;
		}
		
		super.tick();
	}

	private boolean bottomCollision() {
		Block[][] blocks = currentLevel.getBlocks();
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				Block b = blocks[i][j];
				Rectangle2D charRect = new Rectangle2D.Double(x, y, width, height);
				Rectangle2D blockRect = new Rectangle2D.Double(b.getX(), b.getY()-1, b.getWidth(), b.getHeight());
				if(b.getId() != -1 && charRect.getBounds2D().intersects(blockRect.getBounds2D())) {
					return false;
				}
			}
		}
		return true;
	}
	

}
