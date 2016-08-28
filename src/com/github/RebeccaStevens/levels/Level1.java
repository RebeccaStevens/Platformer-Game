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
		
		player = new Player(convertGridUnitsXToPixels(1.5F), convertGridUnitsYToPixels(2), convertGridUnitsWidthToPixels(1), convertGridUnitsHeightToPixels(2));
		
		platforms = new ArrayList<Platform>();
		platforms.add(new Platform(convertGridUnitsXToPixels(0F), convertGridUnitsYToPixels(1F), convertGridUnitsWidthToPixels(18F), convertGridUnitsHeightToPixels(1F)));
		platforms.add(new Platform(convertGridUnitsXToPixels(10F), convertGridUnitsYToPixels(2F), convertGridUnitsWidthToPixels(4F), convertGridUnitsHeightToPixels(1F)));
		
		camera.setFocus(player);
	}

	@Override
	public void update() {
		for (Platform p : platforms) {
			p.update();
		}
		player.update();
		camera.update();
	}

	@Override
	public void draw(PGraphics g) {
		g.pushStyle();
		g.pushMatrix();
		
		applyCamera(g);
		g.background(backgroundColor);
		
		for (Platform p : platforms) {
			p.draw(g);
		}
		player.draw(g);
		
		g.popMatrix();
		g.popStyle();
	}
}
