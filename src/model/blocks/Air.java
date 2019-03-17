package model.blocks;

import java.awt.Graphics;
import java.io.IOException;

import model.Block;

public class Air extends Block{

	public Air(int x, int y) throws IOException {
		super(x, y, "dirt.png", -1);
		id = -1;
	}

	@Override
	public void render(Graphics g) {
		return;
	}
}
