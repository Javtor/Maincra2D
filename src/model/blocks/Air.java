package model.blocks;

import java.awt.Graphics;

import model.Block;

public class Air extends Block{

	public Air(int x, int y) {
		super(x, y);
		id = -1;
	}

	@Override
	public void render(Graphics g) {
		return;
	}
}
