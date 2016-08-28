package com.github.RebeccaStevens.levels;

import com.github.RebeccaStevens.Drawable;
import com.github.RebeccaStevens.Updatable;

import processing.core.PGraphics;

public abstract class Level implements Updatable, Drawable {
	
	private final int gridHeight = 12;
	private int gridWidth;
	private int gameWidth;
	private int gameHeight;
	
	public Level(int gameWidth, int gameHeight) {
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		updateGridWidth();
	}

	/**
	 * Convert game units (for width) to pixels.
	 * 
	 * @param gameUnits
	 * @return
	 */
	protected float convertGridUnitWidthToPixels(float gameUnits) {
		return gameUnits * gameWidth / gridWidth;
	}

	/**
	 * Convert game units (for height) to pixels.
	 * 
	 * @param gameUnits
	 * @return
	 */
	protected float convertGridUnitHeightToPixels(float gameUnits) {
		return gameUnits * gameHeight / gridHeight;
	}
	
	/**
	 * Draw the game grid.
	 * 
	 * @param g
	 */
	public void drawGrid(PGraphics g) {
		g.pushStyle();
		
		g.stroke(0x88000000); // black transparent lines	
		g.strokeWeight(1);
		
		// draw the vertical lines
		for (int i = 0; i < gridWidth + 1; i++) {
			g.line(i * g.width / gridWidth, 0, i * g.width / gridWidth, g.height);
		}
		// draw the horizontal lines
		for (int i = 0; i < gridHeight + 1; i++) {
			g.line(0, i * g.height / gridHeight, g.width, i * g.height / gridHeight);
		}
		
		g.popStyle();
	}

	private void updateGridWidth() {
		gridWidth = (int) (gridHeight * ((float)(gameWidth)) / gameHeight);
	}
}
