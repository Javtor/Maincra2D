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

	public static String BASE_URL =  "block" + File.separator;
	
	protected int id;

	public Block(int x, int y, String imageUrl, int id) {
		super(x, y, BLOCK_SIZE, BLOCK_SIZE, BASE_URL+imageUrl);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	
}
