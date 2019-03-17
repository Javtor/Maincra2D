package model;

import java.awt.Graphics;
import java.io.IOException;

public class Maincra {
	
	private static int pixeLSize = 2;
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 560;
	
	public static final int PIXEL_WIDTH = WIDTH/pixeLSize;
	public static final int PIXEL_HEIGHT = HEIGHT/pixeLSize;
	
	public static final int TICS_PER_SECOND = 30;
	public static final int FRAMES_PER_SECOND = 50;
	
	private boolean running;
	public int testNumb;
	
	private Level world;
	private Character character;
	
	public static double sX;
	public static double sY;
	
	public Maincra() {
		
	}
	
	public void init()
	{
		running = true;
		testNumb = 0;		
		world = new Level();
		character = new Character(PIXEL_WIDTH/2 - Character.CHARACTER_WIDTH/2, PIXEL_HEIGHT/2 - Character.CHARACTER_HEIGHT/2, world);
		sX = 0;
		sY = 0;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void tick() {		
		sX = character.getX() - (PIXEL_WIDTH/2 - Character.CHARACTER_WIDTH/2);
		double offsetY = PIXEL_HEIGHT/2 - Character.CHARACTER_HEIGHT/2;
		sY = character.getY() - offsetY;
		character.tick();
	}

	public void render(Graphics g) throws IOException {
		world.render(g);
		character.render(g);
	}
	
	

}
