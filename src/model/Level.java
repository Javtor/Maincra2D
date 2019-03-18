package model;

import java.awt.Graphics;
import java.io.IOException;

import model.blocks.*;

public class Level {

	private Block[][] blocks;

	public Level() throws IOException {
		blocks = new Block[50][50];
		generateLevel();
	}

	public void generateLevel() throws IOException {
		for (int x = 0; x < blocks.length; x++) {
			for (int y = 0; y < blocks[0].length; y++) {
				if (x == 0 || y == 0 || x == blocks.length - 1 || y == 15) {
					blocks[x][y] = new Dirt(x * Block.BLOCK_SIZE, y * Block.BLOCK_SIZE);
				} else {
					blocks[x][y] = new Air(x * Block.BLOCK_SIZE, y * Block.BLOCK_SIZE);
				}

			}
		}
		blocks[13][14] = new Dirt(13 * Block.BLOCK_SIZE, 14 * Block.BLOCK_SIZE);
//		blocks[13][13] = new Dirt(13 * Block.BLOCK_SIZE, 13 * Block.BLOCK_SIZE);
	}

	public void tick() {

	}

	public void render(Graphics g) throws IOException {
		for (int x = 0; x < blocks.length; x++) {
			for (int y = 0; y < blocks[0].length; y++) {
				Block b = blocks[x][y];
				if (b.getX() + b.width >= Maincra.sX && b.getY() + b.height >= Maincra.sY
						&& b.getX() - b.width <= Maincra.sX + Maincra.WIDTH && b.getY() - b.height <= Maincra.sY + Maincra.HEIGHT ) {
					b.render(g);
				}

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
