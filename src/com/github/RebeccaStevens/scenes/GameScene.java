package com.github.RebeccaStevens.scenes;

import com.github.RebeccaStevens.Game;
import com.github.RebeccaStevens.entities.Player;

import processing.core.PGraphics;

/**
 * This scene contains all the game logic and entities.
 *
 * @author Rebecca Stevens
 */
public class GameScene extends Scene {
	
	// colors
	int backgroundColor = 0xFF64B5F6;
	
	// entities
	Player player;
	
	/**
	 * Create the game scene.
	 */
	public GameScene() {
		player = new Player(125, Game.getGame().sketchHeight() - 150, 50, 100);
	}

	@Override
	protected void enter() {
	}

	@Override
	protected void leave() {
	}

	@Override
	public void update() {
		player.update();
	}

	@Override
	public void draw(PGraphics g) {
		g.pushStyle();
		
		g.background(backgroundColor);
		player.draw(g);
		
		g.popStyle();
	}

}
