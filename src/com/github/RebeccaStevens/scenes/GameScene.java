package com.github.RebeccaStevens.scenes;

import processing.core.PGraphics;

/**
 * This scene contains all the game logic and entities.
 *
 * @author Rebecca Stevens
 */
public class GameScene extends Scene {
	
	// colors
	int backgroundColor = 0xFF64B5F6;
	
	/**
	 * Create the game scene.
	 */
	public GameScene() {
	}

	@Override
	protected void enter() {
	}

	@Override
	protected void leave() {
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(PGraphics g) {
		g.pushStyle();
		
		g.background(backgroundColor);
		
		g.popStyle();
	}

}
