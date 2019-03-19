package threads;

import model.Game;
import view.Window;

public class Render implements Runnable {

	private Window mainWindow;	
	private Game game;
	private long targetTime;
	
	public Render(Window mainWindow, Game game) {
		super();
		this.mainWindow = mainWindow;
		this.game = game;
		targetTime = 1000000000L/Game.FRAMES_PER_SECOND;
	}


	@Override
	public void run() {
		while(game.isRunning()) {
			long time = System.nanoTime();
			game.tick();
			mainWindow.refresh();
			long elapsed = System.nanoTime() - time;
			long wait = (targetTime - elapsed) / 1000000;
			if(wait < 10) wait = 10;
			try {
//				if (wait > 0) {
					Thread.sleep(wait);
//				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
