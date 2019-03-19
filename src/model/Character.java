package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import model.blocks.Air;

public class Character extends MovingSprite {

	private boolean front;

	public static int CHARACTER_WIDTH = 16;
	public static int CHARACTER_HEIGHT = 32;
	public static double FALLING_SPEED = 5;
	public static double MOVING_SPEED = 2.5;
	public static double GRAVITY_TICK = 1;
	public static double JUMPING_SPEED = -8;

	private boolean movingRight;
	private boolean movingLeft;

	private Level currentLevel;

	private boolean falling;

	public Character(double x, double y, Level currentLevel) throws IOException {
		super(x, y, 16, 32, "character_front.png");
		this.front = true;
		falling = true;
		this.currentLevel = currentLevel;
	}

	@Override
	public void tick() {
		double maxDown = findMaxDown();
		falling = maxDown != 0;
		if (falling) {
			velY += GRAVITY_TICK;
		}

		if (movingRight) {
			velX = MOVING_SPEED;
		} else if (movingLeft) {
			velX = -MOVING_SPEED;
		} else {
			velX = 0;
		}				
		
		if (velY > 0) {
			velY = Math.min(velY, maxDown);
		}

		if (velY < 0) {
			velY = Math.max(velY, findMaxUp());
		}

		y += velY;

		if (velX > 0) {

			velX = Math.min(velX, findMaxRight());
		}

		if (velX < 0) {

			velX = Math.max(velX, findMaxLeft());
		}
		
		x += velX;
		
		
	}

	private double findMaxDown() {
		Block[][] blocks = currentLevel.getBlocks();
		double min = Integer.MAX_VALUE;
		for (int x = (int) (this.x / Block.BLOCK_SIZE); x <= (int) Math.ceil((this.x + width) / Block.BLOCK_SIZE)
				- 1; x++) {
			if (x >= 0 && x < blocks.length) {
				for (int y = (int) Math.ceil((this.y + height) / Block.BLOCK_SIZE); y <= (int) Math
						.ceil((this.y + height + velY) / Block.BLOCK_SIZE); y++) {
					if (y >= 0 && y < blocks[0].length) {
						Block b = blocks[x][y];
						if (b.isSolid())
							min = Math.min(min, b.y - (this.y + height));
					}
				}
			}
		}
		return min;
	}

	private double findMaxUp() {
		Block[][] blocks = currentLevel.getBlocks();
		double min = Integer.MIN_VALUE;
		for (int x = (int) (this.x / Block.BLOCK_SIZE); x <= (int) Math.ceil((this.x + width) / Block.BLOCK_SIZE)
				- 1; x++) {
			if (x >= 0 && x < blocks.length) {
				for (int y = (int) Math.ceil((this.y) / Block.BLOCK_SIZE)
						- 1; y >= (int) Math.ceil((this.y + velY) / Block.BLOCK_SIZE) - 1; y--) {
					if (y >= 0 && y < blocks[0].length) {
						Block b = blocks[x][y];
						if (b.isSolid())
							min = Math.max(min, b.y + Block.BLOCK_SIZE - (this.y));
					}
				}
			}
		}
		return min;
	}

	private double findMaxRight() {
		Block[][] blocks = currentLevel.getBlocks();
		double min = Integer.MAX_VALUE;
		for (int x = (int) Math.ceil((this.x + width) / Block.BLOCK_SIZE); x <= (int) Math
				.ceil((this.x + width + velX) / Block.BLOCK_SIZE); x++) {
			if (x >= 0 && x < blocks.length) {
				for (int y = (int) (this.y / Block.BLOCK_SIZE); y <= (int) Math
						.ceil((this.y + height) / Block.BLOCK_SIZE) - 1; y++) {
					if (y >= 0 && y < blocks[0].length) {
						Block b = blocks[x][y];
						if (b.isSolid())
							min = Math.min(min, b.x - (this.x + width));
					}
				}
			}
		}
		return min;
	}

	private double findMaxLeft() {
		Block[][] blocks = currentLevel.getBlocks();
		double min = Integer.MIN_VALUE;
		for (int x = (int) Math.ceil((this.x) / Block.BLOCK_SIZE)
				- 1; x >= (int) Math.ceil((this.x + velX) / Block.BLOCK_SIZE) - 1; x--) {
			if (x >= 0 && x < blocks.length) {
				for (int y = (int) (this.y / Block.BLOCK_SIZE); y <= (int) Math
						.ceil((this.y + height) / Block.BLOCK_SIZE) - 1; y++) {
					if (y >= 0 && y < blocks[0].length) {
						Block b = blocks[x][y];
						if (b.isSolid())
							min = Math.max(min, b.x + Block.BLOCK_SIZE - (this.x));
					}
				}
			}
		}
		return min;
	}

//	private boolean isFalling() {
//		Block[][] blocks = currentLevel.getBlocks();
//		for (int i = (int) (x / Block.BLOCK_SIZE); i < blocks.length && i < (int) (x / Block.BLOCK_SIZE) + 3; i++) {
//			for (int j = (int) (y / Block.BLOCK_SIZE); j < blocks[0].length
//					&& j < (int) (y / Block.BLOCK_SIZE) + 3; j++) {
//				if (i >= 0 && j >= 0) {
//					Block b = blocks[i][j];
//					Rectangle2D charRect = new Rectangle2D.Double(x, y + FALLING_SPEED, width, height);
//					Rectangle2D blockRect = new Rectangle2D.Double(b.getX(), b.getY(), b.getWidth(), b.getHeight());
//
//					if (b.getId() != -1 && charRect.getBounds2D().intersects(blockRect.getBounds2D())) {
//						this.y = blockRect.getY() - this.height;
//						return false;
//					}
//				}
//			}
//		}
//		return true;
//	}

	public void move(boolean right) {
		if (right)
			movingRight = true;
		if (!right)
			movingLeft = true;
	}

	public void stop(boolean right) {
		if (right && movingRight) {
			movingRight = false;
		} else if (!right && movingLeft) {
			movingLeft = false;
		}

	}

	public void jump() {
		if (!falling)
			velY = JUMPING_SPEED;

	}

}
