package com.github.RebeccaStevens.scenes;

import java.security.InvalidParameterException;

import com.github.RebeccaStevens.App;
import com.github.RebeccaStevens.levels.Level;
import com.github.RebeccaStevens.levels.Level1;

import processing.core.PGraphics;

/**
 * This scene contains all the game logic and entities.
 *
 * @author Rebecca Stevens
 */
public class GameScene extends Scene {

	/**
	 * The game's graphic object.
	 */
	private PGraphics gameGraphics;
	
	/**
	 * The active level.
	 */
	private Level level;
	
	/**
	 * Create the game scene.
	 */
	public GameScene() {
		createGameGraphics();
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
	}

	@Override
	public void update() {
		if (this.level != null) {
			this.level.update();
		}
	}

	@Override
	public void draw(PGraphics g) {
		g.background(0);	// create black bars around the game if needed. 
		if (this.level != null) {
			this.gameGraphics.beginDraw();
			this.level.draw(this.gameGraphics);
			this.level.drawGrid(this.gameGraphics);
			this.gameGraphics.endDraw();
			g.image(gameGraphics, (g.width - this.gameGraphics.width) / 2, (g.height - this.gameGraphics.height) / 2);
		}
	}
	
	/**
	 * The level number to run.
	 * 
	 * @param levelNumber
	 */
	public void setLevel(int levelNumber) {
		switch (levelNumber) {
		case 1:
			this.level = new Level1();
			break;
		default:
			throw new InvalidParameterException("Level \"" + levelNumber + "\" does not exist.");
		}
	}

	/**
	 * The width of the game (in pixels).
	 * 
	 * @return
	 */
	public int getGameWidth() {
		return this.gameGraphics.width;
	}

	/**
	 * The height of the game (in pixels).
	 * 
	 * @return
	 */
	public int getGameHeight() {
		return this.gameGraphics.height;
	}

	/**
	 * Create the game graphics.
	 */
	private void createGameGraphics() {
		App app = App.getApp();
		float aspectRatio = app.getSettings().getAspectRation();
		
		int windowWidth = app.getWidth();
		int windowHeight = app.getHeight();
		int gameWidth;
		int gameHeight;
		
		if (((float)windowWidth) / windowHeight <= aspectRatio) {
			gameWidth = windowWidth;
			gameHeight = (int) (windowWidth / aspectRatio);
		} else {
			gameWidth = (int) (windowHeight * aspectRatio);
			gameHeight = windowHeight;
		}
	
		this.gameGraphics = app.createGraphics(gameWidth, gameHeight);
	}

}
