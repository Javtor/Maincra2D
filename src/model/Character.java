package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Character extends MovingSprite {

	private boolean front;

	public static int CHARACTER_WIDTH = 16;
	public static int CHARACTER_HEIGHT = 32;
	public static double FALLING_SPEED = 5;
	public static double MOVING_SPEED = 2.5;

	private Level currentLevel;

	private boolean falling;

	public Character(double x, double y, Level currentLevel) throws IOException {
		super(x, y, 16, 32, "character_front.png");
		this.front = true;
		falling = true;
		this.currentLevel = currentLevel;
//		velY = 5;
	}

	@Override
	public void tick() {
		falling = isFalling();
		if (falling) {
			velY += 1;

		} else {
			velY = 0;
		}

		super.tick();
	}

	private boolean isFalling() {
		Block[][] blocks = currentLevel.getBlocks();
		for (int i = (int) (x / Block.BLOCK_SIZE); i < blocks.length && i < (int) (x / Block.BLOCK_SIZE) + 3; i++) {
			for (int j = (int) (y / Block.BLOCK_SIZE); j < blocks[0].length
					&& j < (int) (y / Block.BLOCK_SIZE) + 3; j++) {
				if (i >= 0 && j >= 0) {
					Block b = blocks[i][j];
					Rectangle2D charRect = new Rectangle2D.Double(x, y + FALLING_SPEED, width, height);
					Rectangle2D blockRect = new Rectangle2D.Double(b.getX(), b.getY(), b.getWidth(), b.getHeight());

					if (b.getId() != -1 && charRect.getBounds2D().intersects(blockRect.getBounds2D())) {
						this.y = blockRect.getY() - this.height;
						return false;
					}
				}
			}
		}
		return true;
	}

	public void move(boolean right) {
		velX = MOVING_SPEED;
		if (!right)
			velX = -velX;
	}

	public void stop(boolean right) {
		if(right && velX > 0)
		{
			velX = 0;
		} else if(!right && velX < 0) {
			velX = 0;
		}
		
	}

	public void jump() {
		velY = -10;
		
	}

}
