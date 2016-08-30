package com.github.RebeccaStevens.levels;

import java.security.InvalidParameterException;

import com.github.RebeccaStevens.Drawable;
import com.github.RebeccaStevens.Updatable;
import com.github.RebeccaStevens.App;
import com.github.RebeccaStevens.entities.Camera;
import com.github.RebeccaStevens.scenes.GameScene;

import processing.core.PGraphics;

public abstract class Level implements Updatable, Drawable {
	
	private final int gridWidth = 16;
	private int gridHeight;
	private int gameWidth;
	private int gameHeight;
	
	private float zoom = 1F;
	
	protected final Camera camera;
	
	/**
	 * Create the Level.
	 * 
	 * @param gameWidth  - The width of the game screen
	 * @param gameHeight - The height of the game screen
	 */
	public Level() {
		this.camera = new Camera(this);
		this.updateGameGrid();
	}

	/**
	 * Convert game units (for x position) to pixels.
	 * 
	 * @param gameUnits
	 * @return
	 */
	public float convertGridUnitsXToPixels(float gameUnits) {
		return this.zoom * gameUnits * this.gameWidth / this.gridWidth;
	}
	
	/**
	 * Convert game units (for y position) to pixels.
	 * 
	 * @param gameUnits
	 * @return
	 */
	public float convertGridUnitsYToPixels(float gameUnits) {
		return this.gameHeight - (this.zoom * gameUnits * this.gameHeight / this.gridHeight);
	}
	
	/**
	 * Convert game units (for x movement) to pixels.
	 * 
	 * @param gameUnits
	 * @return
	 */
	public float convertGridUnitsVelocityXToPixels(float gameUnits) {
		return this.zoom * gameUnits * this.gameWidth / this.gridWidth;
	}
	
	/**
	 * Convert game units (for y movement) to pixels.
	 * 
	 * @param gameUnits
	 * @return
	 */
	public float convertGridUnitsVelocityYToPixels(float gameUnits) {
		return -(this.zoom * gameUnits * this.gameHeight / this.gridHeight);
	}

	/**
	 * Convert game units (for width) to pixels.
	 * 
	 * @param gameUnits
	 * @return
	 */
	public float convertGridUnitsWidthToPixels(float gameUnits) {
		return this.zoom * gameUnits * this.gameWidth / this.gridWidth;
	}

	/**
	 * Convert game units (for height) to pixels.
	 * 
	 * @param gameUnits
	 * @return
	 */
	public float convertGridUnitsHeightToPixels(float gameUnits) {
		return this.zoom * gameUnits * this.gameHeight / this.gridHeight;
	}
	
	/**
	 * Draw the game grid.
	 * 
	 * @param g
	 */
	public void drawGrid(PGraphics g) {
		g.pushStyle();
		
		g.stroke(0x33000000); // black transparent lines	
		g.strokeWeight(1);
		
		float xOffset = (this.camera.getX() * this.gridWidth / g.width) % 1;
		float yOffset = (this.camera.getY() * this.gridHeight / g.height) % 1;
		
		// draw the vertical lines
		for (int i = 0; i < gridWidth / zoom + 1; i++) {
			g.line((i - xOffset) * this.zoom * g.width / this.gridWidth, 0, (i - xOffset) * this.zoom * g.width / this.gridWidth, g.height);
		}
		
		// draw the horizontal lines
		for (int i = 0; i < gridHeight / zoom + 1; i++) {
			g.line(0, g.height - ((i + yOffset) * this.zoom * g.height / this.gridHeight), g.width, g.height - ((i + yOffset) * this.zoom * g.height / this.gridHeight));
		}
		
		g.popStyle();
	}
	
	/**
	 * Get the width of the game grid (in grid units).
	 * 
	 * @return
	 */
	public int getGridWidth() {
		return gridWidth;
	}

	/**
	 * Get the height of the game grid (in grid units).
	 * 
	 * @return
	 */
	public int getGridHeight() {
		return gridHeight;
	}

	/**
	 * Get the width of the game (in pixels).
	 * 
	 * @return
	 */
	public int getGameWidth() {
		return gameWidth;
	}

	/**
	 * Get the height of the game (in pixels).
	 * 
	 * @return
	 */
	public int getGameHeight() {
		return gameHeight;
	}

	/**
	 * Get the zoom level.
	 * 
	 * @return the zoom
	 */
	public float getZoom() {
		return this.zoom;
	}

	/**
	 * Set the zoom level.
	 * 
	 * @param
	 */
	public void setZoom(float zoom) {
		if (zoom <= 0) {
			throw new InvalidParameterException();
		}
		this.zoom = zoom;
	}

	/**
	 * Update the size of the grid.
	 */
	public void updateGameGrid() {
		GameScene gs = App.getApp().getGameScene();
		this.gameWidth = gs.getGameWidth();
		this.gameHeight = gs.getGameHeight();
		
		this.gridHeight = (int) (this.gridWidth * ((float)(this.gameHeight)) / this.gameWidth);
	}

	/**
	 * Apply the camera offset.
	 * 
	 * @param g
	 */
	protected void applyCamera(PGraphics g) {
		g.translate(g.width / 2 - this.camera.getX(), g.height / 2 - this.camera.getY());
	}
}
