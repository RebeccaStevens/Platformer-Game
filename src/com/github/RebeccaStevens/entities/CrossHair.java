package com.github.RebeccaStevens.entities;

import gamelib.game.Level;
import gamelib.game.OverlayElement;
import processing.core.PGraphics;
import processing.core.PVector;

public class CrossHair extends OverlayElement {
	
	private float width = 48;
	private float height = 48;

	/**
	 * Create a CrossHair.
	 * 
	 * @param level - The level this entity is in
	 * @param x - The starting x position of the player 
	 * @param y - The starting y position of the player
	 * @param width - The width of the player
	 * @param height - The height of the player
	 */
	public CrossHair(Level level, float x, float y) {
		super(level, x, y);
	}

	@Override
	public void draw(PGraphics g) {
		PVector location = getLocationInPixels();
		
		g.noFill();
		g.stroke(0, 0, 0, 64);
		g.strokeWeight(3);
		g.ellipse(location.x, location.y, width, height);
		g.stroke(255, 0, 0);
		g.strokeWeight(2);
		g.ellipse(location.x, location.y, width, height);
		g.strokeWeight(1);
		g.line(location.x, location.y - height / 2, location.x, location.y + height / 2);
		g.line(location.x - width / 2, location.y, location.x + width / 2, location.y);
	}
}
