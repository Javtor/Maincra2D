package model;

public class Maincra {
	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	
	public static final int TICS_PER_SECOND = 1;
	public static final int FRAMES_PER_SECOND = 20;
	
	private boolean running;
	public int testNumb;
	public Maincra() {
		
	}
	
	public void init()
	{
		running = true;
		testNumb = 0;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void gameLoop() {
		testNumb++;
	}
	
	

}
