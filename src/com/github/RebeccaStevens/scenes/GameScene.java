package com.github.RebeccaStevens.scenes;

import java.util.ArrayList;

import com.github.RebeccaStevens.Game;
import com.github.RebeccaStevens.entities.Platform;
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
	ArrayList<Platform> platforms;
	
	/**
	 * Create the game scene.
	 */
	public GameScene() {
		float sketchHeight = Game.getGame().sketchHeight();
		
		player = new Player(125, sketchHeight - 150, 50, 100);
		platforms = new ArrayList<Platform>();
		platforms.add(new Platform(0, sketchHeight - 50, 1200, 50));
		platforms.add(new Platform(600, sketchHeight - 125, 200, 75));
	}

	@Override
	protected void enter() {
	}

	@Override
	protected void leave() {
	}

	@Override
	public void update() {
		for (Platform p : platforms) {
			p.update();
		}
		player.update();
	}

	@Override
	public void draw(PGraphics g) {
		g.pushStyle();
		
		g.background(backgroundColor);
		
		for (Platform p : platforms) {
			p.draw(g);
		}
		player.draw(g);
		
		g.popStyle();
	}

}
