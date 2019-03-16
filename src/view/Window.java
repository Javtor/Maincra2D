package view;

import javax.swing.JFrame;

import model.Maincra;
import threads.GameLoop;
import threads.Render;

public class Window extends JFrame{
	
	public static final String TITLE = "Maincra 2D";
	
	private GamePanel gamePanel;
	private Maincra game;

	public Window() {
		game = new Maincra();
		gamePanel = new GamePanel(this, game);
		this.add(gamePanel);
		pack();
		setTitle(TITLE);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		startGame();
	}
	
	
	private void startGame() {		
		Thread loop = new Thread(new GameLoop(game));
		loop.setName("Game loop");
		
		Thread render = new Thread(new Render(this, game));
		render.setName("Render");		
		
		game.init();
		loop.start();
		render.start();
	}


	public void refresh()
	{
		gamePanel.updateUI();
	}
	
	public static void main(String[] args) {
		new Window();
	}
}
