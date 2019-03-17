package model;

public class MovingSprite extends Sprite{
	
	protected double velX;
	protected double velY;

	public MovingSprite(double x, double y, double width, double height, String imageUrl) {
		super(x, y, width, height, imageUrl);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		x += velX;
		y += velY;
	}

}
