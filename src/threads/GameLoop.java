package threads;

import model.Game;
import view.Window;

public class GameLoop implements Runnable {

	private Game game;	
	
	public GameLoop(Game game) {
		super();
		this.game = game;
	}


	@Override
	public void run() {
		while(game.isRunning()) {
			
//			game.tick();
			
			try {
				Thread.sleep(1000/Game.TICS_PER_SECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
