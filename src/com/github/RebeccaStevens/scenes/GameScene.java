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
	private int backgroundColor = 0xFF64B5F6;
	
	// entities
	private Player player;
	private ArrayList<Platform> platforms;
	
	/**
	 * Create the game scene.
	 */
	public GameScene() {
		float sketchHeight = Game.getGame().sketchHeight();
		
		player = new Player(125, sketchHeight - 150, 50, 100);
		platforms = new ArrayList<Platform>();
		platforms.add(new Platform(600, sketchHeight - 25, 1200, 50));
		platforms.add(new Platform(700, sketchHeight - 75, 200, 75));
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
