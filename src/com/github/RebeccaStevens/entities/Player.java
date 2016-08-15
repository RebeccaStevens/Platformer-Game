package com.github.RebeccaStevens.entities;

import processing.core.PConstants;
import processing.core.PGraphics;

public class Player extends Entity {

	private int color = 0xFFFF0000;

	/**
	 * Create the player.
	 * 
	 * @param x - The starting x position of the player 
	 * @param y - The starting y position of the player
	 * @param width - The width of the player
	 * @param height - The height of the player
	 */
	public Player(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(PGraphics g) {
		g.pushStyle();
		g.pushMatrix();
		
		g.rectMode = PConstants.CENTER;
		g.translate(this.position.x, this.position.y);
		g.noStroke();
		g.fill(this.color);
		g.rect(0, 0, this.width, this.height);
		
		g.popMatrix();
		g.popStyle();
	}

}
