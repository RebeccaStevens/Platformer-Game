package com.github.RebeccaStevens.levels;

import java.util.ArrayList;

import com.github.RebeccaStevens.entities.Platform;
import com.github.RebeccaStevens.entities.Player;

import processing.core.PConstants;
import processing.core.PGraphics;

public class Level1 extends Level {
	
	// colors
	private int backgroundColor = 0xFF64B5F6;
	
	// entities
	private final Player player;
	
	private final ArrayList<Platform> platforms;

	public Level1(int gameWidth, int gameHeight) {
		super(gameWidth, gameHeight);
		
		player = new Player(convertGridUnitWidthToPixels(1.5F), convertGridUnitHeightToPixels(10), convertGridUnitWidthToPixels(1), convertGridUnitHeightToPixels(2));
		
		platforms = new ArrayList<Platform>();
		platforms.add(new Platform(convertGridUnitWidthToPixels(0F), convertGridUnitHeightToPixels(11F), convertGridUnitWidthToPixels(18F), convertGridUnitHeightToPixels(1F), PConstants.CORNER));
		platforms.add(new Platform(convertGridUnitWidthToPixels(10F), convertGridUnitHeightToPixels(10.5F), convertGridUnitWidthToPixels(4F), convertGridUnitHeightToPixels(1F), PConstants.CENTER));
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
