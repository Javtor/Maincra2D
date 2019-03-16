package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Block extends Sprite {

	public static int BLOCK_SIZE = 16;

	public static String BASE_URL = "res" + File.separator + "block" + File.separator;

	public Block(int x, int y) {
		super(x, y, BLOCK_SIZE, BLOCK_SIZE);
		// TODO Auto-generated constructor stub
	}

	protected int id;

	public void render(Graphics g) throws IOException {
		Image img = getImage();
		g.drawImage(img, (int)x, (int)y, null);
	}
}
