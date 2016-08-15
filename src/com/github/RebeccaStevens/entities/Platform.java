package com.github.RebeccaStevens.entities;

import processing.core.PConstants;
import processing.core.PGraphics;

public class Platform extends Entity {
	
	int color = 0xFFCCCCCC;


	/**
	 * Create the player.
	 * 
	 * @param x - The starting x position of the platform 
	 * @param y - The starting y position of the platform
	 * @param width - The width of the platform
	 * @param height - The height of the platform
	 */
	public Platform(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(PGraphics g) {
		g.pushStyle();
		g.pushMatrix();
		
		g.rectMode = PConstants.CORNER;
		g.translate(this.position.x, this.position.y);
		g.noStroke();
		g.fill(this.color);
		g.rect(0, 0, this.width, this.height);
		
		g.popMatrix();
		g.popStyle();
	}

}
