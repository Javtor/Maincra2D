package model;

import java.awt.Graphics;
import java.io.IOException;

import model.blocks.*;

public class Level {

	private Block[][] blocks;

	public Level() {
		blocks = new Block[50][50];
		generateLevel();
	}

	public void generateLevel() {
		for (int x = 0; x < blocks.length; x++) {
			for (int y = 0; y < blocks[0].length; y++) {
				if (x == 0 || y == 0 || x == blocks.length - 1 || y == blocks[0].length - 1) {
					blocks[x][y] = new Dirt(x * Block.BLOCK_SIZE, y * Block.BLOCK_SIZE);
				} else {
					blocks[x][y] = new Air(x * Block.BLOCK_SIZE, y * Block.BLOCK_SIZE);
				}

			}
		}
	}

	public void tick() {

	}

	public void render(Graphics g) throws IOException {
		for (int x = 0; x < blocks.length; x++) {
			for (int y = 0; y < blocks[0].length; y++) {
				blocks[x][y].render(g);
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

}
