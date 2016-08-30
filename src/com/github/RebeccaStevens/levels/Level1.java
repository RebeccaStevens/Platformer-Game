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

	public Level1() {
		this.player = new Player(this, convertGridUnitsXToPixels(1.5F), convertGridUnitsYToPixels(2), convertGridUnitsWidthToPixels(1), convertGridUnitsHeightToPixels(2));
		
		this.platforms = new ArrayList<Platform>();
		this.platforms.add(new Platform(this, convertGridUnitsXToPixels(0F), convertGridUnitsYToPixels(1F), convertGridUnitsWidthToPixels(18F), convertGridUnitsHeightToPixels(1F)));
		this.platforms.add(new Platform(this, convertGridUnitsXToPixels(10F), convertGridUnitsYToPixels(2F), convertGridUnitsWidthToPixels(4F), convertGridUnitsHeightToPixels(1F)));
		
		this.camera.setFocus(this.player);
		this.camera.setMinX(this.getGameWidth() / 2);
		this.camera.setMaxY(this.getGameHeight() / 2);
		this.player.setMinX(this.player.getWidth() / 2);
	}

	@Override
	public void update() {
		for (Platform p : platforms) {
			p.update();
		}
		this.player.update();
		this.camera.update();
	}

	@Override
	public void draw(PGraphics g) {
		g.pushStyle();
		g.pushMatrix();
		
		applyCamera(g);
		g.background(this.backgroundColor);
		
		for (Platform p : this.platforms) {
			p.draw(g);
		}
		this.player.draw(g);
		
		g.popMatrix();
		g.popStyle();
	}
}
