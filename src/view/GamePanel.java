package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.Maincra;

public class GamePanel extends JPanel implements KeyListener, MouseListener {

	private Window mainWindow;
	private Maincra game;
	public Image screen;
	
	private Dimension size = new Dimension(Maincra.WIDTH, Maincra.HEIGHT);
	public Dimension pixel = new Dimension(Maincra.PIXEL_WIDTH, Maincra.PIXEL_HEIGHT);

	public GamePanel(Window mainWindow, Maincra game) {
		this.mainWindow = mainWindow;
		this.game = game;
		
		System.setProperty("java.awt.headless", "false");
		
		setPreferredSize(size);
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		screen = createVolatileImage(pixel.width, pixel.height);
		System.out.println("ok");
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	}

	public void drawGame() {
		Graphics g = screen.getGraphics();
		g.setColor(new Color(255,100,100));
		g.fillRect(0, 0, screen.getWidth(null), screen.getHeight(null));
		
		g = getGraphics();
		
		g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);
		g.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
