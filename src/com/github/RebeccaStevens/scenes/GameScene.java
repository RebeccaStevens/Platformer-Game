package com.github.RebeccaStevens.scenes;

import com.github.RebeccaStevens.Game;
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
		level = new Level1(gameGraphics.width, gameGraphics.height);
	}

	@Override
	protected void enter() {
	}

	@Override
	protected void leave() {
	}

	@Override
	public void update() {
		if (level != null) {
			level.update();
		}
	}

	@Override
	public void draw(PGraphics g) {
		g.background(0);	// create black bars around the game if needed. 
		if (level != null) {
			gameGraphics.beginDraw();
			level.draw(gameGraphics);
			level.drawGrid(gameGraphics);
			gameGraphics.endDraw();
			g.image(gameGraphics, (g.width - gameGraphics.width) / 2, (g.height - gameGraphics.height) / 2);
		}
	}

	/**
	 * Create the game graphics.
	 */
	private void createGameGraphics() {
		Game game = Game.getGame();
		float aspectRatio = game.getSettings().getAspectRation();
		
		int windowWidth = game.getWidth();
		int windowHeight = game.getHeight();
		int gameWidth;
		int gameHeight;
		
		if (((float)windowWidth) / windowHeight <= aspectRatio) {
			gameWidth = windowWidth;
			gameHeight = (int) (windowWidth / aspectRatio);
		} else {
			gameWidth = (int) (windowHeight * aspectRatio);
			gameHeight = windowHeight;
		}

		gameGraphics = game.createGraphics(gameWidth, gameHeight);
	}

}
