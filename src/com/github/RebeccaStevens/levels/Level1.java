package com.github.RebeccaStevens.levels;

import java.util.ArrayList;

import com.github.RebeccaStevens.entities.Platform;
import com.github.RebeccaStevens.entities.Player;

import processing.core.PGraphics;

public class Level1 extends Level {
	
	// colors
	private int backgroundColor = 0xFF64B5F6;
	
	// entities
	private final Player player;
	
	private final ArrayList<Platform> platforms;

	public Level1(int gameWidth, int gameHeight) {
		super(gameWidth, gameHeight);
		
		player = new Player(convertToPixels(1.5F), convertToPixels(10), convertToPixels(1), convertToPixels(2));
		
		platforms = new ArrayList<Platform>();
		platforms.add(new Platform(convertToPixels(8F), convertToPixels(11.5F), convertToPixels(16F), convertToPixels(1F)));
		platforms.add(new Platform(convertToPixels(10F), convertToPixels(10.5F), convertToPixels(4F), convertToPixels(1F)));
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
