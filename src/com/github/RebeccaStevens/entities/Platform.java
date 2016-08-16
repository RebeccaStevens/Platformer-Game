package com.github.RebeccaStevens.entities;

public class Platform extends Entity {

	/**
	 * Create the player.
	 * 
	 * @param x - The starting x position of the platform 
	 * @param y - The starting y position of the platform
	 * @param width - The width of the platform
	 * @param height - The height of the platform
	 */
	public Platform(float x, float y, float width, float height) {
		super(x, y, width, height, 0xFFCCCCCC);
	}

	@Override
	public void update() {
		
	}

}
