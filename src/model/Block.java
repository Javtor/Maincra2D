package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

public abstract class Block extends Sprite {

	public static int BLOCK_SIZE = 16;

	public static String BASE_URL =  "block" + File.separator;
	
	protected int id;
	protected boolean solid;

	public Block(int x, int y, String imageUrl, int id) throws IOException {
		super(x, y, BLOCK_SIZE, BLOCK_SIZE, BASE_URL+imageUrl);
		solid = true;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	@Override
	public void render(Graphics g) throws IOException {
//		g.setColor(Color.black);
//		g.drawRect((int)(x-Maincra.sX), (int)(y-Maincra.sY), (int)width, (int)height);
//		g.setFont(new Font("TimesRoman", Font.PLAIN, 8)); 
//		g.drawString(""+x/BLOCK_SIZE+" "+y/BLOCK_SIZE, (int)(x-Maincra.sX), (int)(y-Maincra.sY));
		super.render(g);
	}
}
