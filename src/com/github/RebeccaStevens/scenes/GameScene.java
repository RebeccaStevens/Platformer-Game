package com.github.RebeccaStevens.scenes;

import com.github.RebeccaStevens.levels.Level;
import com.github.RebeccaStevens.levels.Level1;

import processing.core.PGraphics;

/**
 * This scene contains all the game logic and entities.
 *
 * @author Rebecca Stevens
 */
public class GameScene extends Scene {
	
	private Level level;
	
	/**
	 * Create the game scene.
	 */
	public GameScene() {
		level = new Level1();
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
		if (level != null) {
			level.draw(g);
		}
	}

}
