package model;

import java.io.File;
import java.io.IOException;

public abstract class Block extends Sprite {

	public static int BLOCK_SIZE = 16;

	public static String BASE_URL =  "block" + File.separator;
	
	protected int id;

	public Block(int x, int y, String imageUrl, int id) throws IOException {
		super(x, y, BLOCK_SIZE, BLOCK_SIZE, BASE_URL+imageUrl);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	@Override
	public void render(Graphics g) throws IOException {
//		g.setColor(Color.black);
//		g.drawRect((int)(x-Maincra.sX), (int)(y-Maincra.sY), (int)width, (int)height);
		super.render(g);
	}
}
