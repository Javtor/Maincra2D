package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Sprite {
	
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	protected String imageUrl;
	
	public static String BASE_URL =  "res" + File.separator;
	
	public Sprite(double x, double y, double width, double height, String imageUrl) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imageUrl = BASE_URL+imageUrl;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public Image getImage() throws IOException {
		File file = new File(imageUrl);
		BufferedImage img = ImageIO.read(file);
		return img;
	}
	
	public void render(Graphics g) throws IOException {
		Image img = getImage();
		g.drawImage(img, (int)(x-Maincra.sX), (int)(y-Maincra.sY), null);
	}
}
