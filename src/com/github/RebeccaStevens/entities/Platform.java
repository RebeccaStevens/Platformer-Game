package com.github.RebeccaStevens.entities;

import processing.core.PConstants;

public class Platform extends DrawableEntity {

	private static final int fillColor = 0xFFCCCCCC;

	/**
	 * Create the player.
	 * 
	 * @param x - The starting x position of the platform 
	 * @param y - The starting y position of the platform
	 * @param width - The width of the platform
	 * @param height - The height of the platform
	 */
	public Platform(float x, float y, float width, float height) {
		super(x, y, width, height, PConstants.CORNER, fillColor);
	}

	@Override
	public void update() {
		
	}

}
