package threads;

import model.Maincra;
import view.Window;

public class GameLoop implements Runnable {

	private Maincra game;	
	
	public GameLoop(Maincra game) {
		super();
		this.game = game;
	}


	@Override
	public void run() {
		while(game.isRunning()) {
			
//			game.tick();
			
			try {
				Thread.sleep(1000/Maincra.TICS_PER_SECOND);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
