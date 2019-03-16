package threads;

import model.Maincra;
import view.Window;

public class Render implements Runnable {

	private Window mainWindow;	
	private Maincra game;
	
	public Render(Window mainWindow, Maincra game) {
		super();
		this.mainWindow = mainWindow;
		this.game = game;
	}


	@Override
	public void run() {
		while(game.isRunning()) {
			
			mainWindow.refresh();
			
			try {
				Thread.sleep(1000/Maincra.FRAMES_PER_SECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
