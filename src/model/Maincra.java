package model;

import java.awt.Graphics;
import java.io.IOException;

public class Maincra {
	
	private static int pixeLSize = 2;
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 560;
	
	public static final int PIXEL_WIDTH = WIDTH/pixeLSize;
	public static final int PIXEL_HEIGHT = HEIGHT/pixeLSize;
	
	public static final int TICS_PER_SECOND = 20;
	public static final int FRAMES_PER_SECOND = 60;
	
	private boolean running;
	public int testNumb;
	
	private Level world;
	
	private int sX;
	private int sY;
	
	public Maincra() {
		
	}
	
	public void init()
	{
		running = true;
		testNumb = 0;		
		world = new Level();
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void tick() {
		testNumb++;
	}

	public void render(Graphics g) throws IOException {
		world.render(g);
		
	}
	
	

}
