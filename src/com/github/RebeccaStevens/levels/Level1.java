package com.github.RebeccaStevens.levels;

import java.util.ArrayList;

import com.github.RebeccaStevens.Game;
import com.github.RebeccaStevens.entities.Platform;
import com.github.RebeccaStevens.entities.Player;

import processing.core.PGraphics;

public class Level1 extends Level {
	
	// colors
	private int backgroundColor = 0xFF64B5F6;
	
	// entities
	private Player player;
	private ArrayList<Platform> platforms;

	public Level1() {
		float sketchHeight = Game.getGame().sketchHeight();
		
		player = new Player(125, sketchHeight - 150, 50, 100);
		platforms = new ArrayList<Platform>();
		platforms.add(new Platform(600, sketchHeight - 25, 1200, 50));
		platforms.add(new Platform(700, sketchHeight - 75, 200, 75));
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
