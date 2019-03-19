package view;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;

import model.Game;
import threads.GameLoop;
import threads.Render;

public class Window extends JFrame{
	
	public static final String TITLE = "Maincra 2D";
	
	private GamePanel gamePanel;
	private Game game;

	public Window() {
		game = new Game();
		gamePanel = new GamePanel(this, game);
		this.add(gamePanel);
		
		setTitle(TITLE);
		setResizable(false);
		pack();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		try {
			startGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void startGame() throws IOException {		
		Thread loop = new Thread(new GameLoop(game));
		loop.setName("Game loop");
		
		Thread render = new Thread(new Render(this, game));
		render.setName("Render");		
		
		game.init();
		gamePanel.screen = createVolatileImage(gamePanel.pixel.width, gamePanel.pixel.height);
		loop.start();
		render.start();
	}

	public void render(Graphics g) {
		try {
			game.render(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void refresh()
	{
		gamePanel.drawGame();
	}
	
	public static void main(String[] args) {
		new Window();
	}


	public void keyPressed(int key) {
		game.keyPressed(key);
		
	}


	public void keyReleased(int key) {
		game.keyReleased(key);
		
	}
}
