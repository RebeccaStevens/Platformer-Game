package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.levels.Level;

import multikey.Key;
import processing.core.PConstants;

public class Player extends DrawableEntity {
	
	private static final int fillColor = 0xFFFF0000;
	
	private final Key moveLeft1;
	private final Key moveLeft2;
	private final Key moveRight1;
	private final Key moveRight2;
	private final Key moveRun1;
	private final Key moveRun2;
	private final Key moveJump1;
	private final Key moveJump2;

	private float walkSpeed;
	private float runSpeed;

	/**
	 * Create the player.
	 * 
	 * @param level - The level this entity is in
	 * @param x - The starting x position of the player 
	 * @param y - The starting y position of the player
	 * @param width - The width of the player
	 * @param height - The height of the player
	 */
	public Player(Level level, float x, float y, float width, float height) {
		super(level, x, y, width, height, PConstants.CENTER, fillColor);
		
		this.moveLeft1 = new Key(PConstants.LEFT);
		this.moveLeft2 = new Key('A');
		this.moveRight1 = new Key(PConstants.RIGHT);
		this.moveRight2 = new Key('D');
		this.moveRun1 = new Key(PConstants.SHIFT);
		this.moveRun2 = new Key(-1);
		this.moveJump1 = new Key(PConstants.UP);
		this.moveJump2 = new Key(' ');
		
		this.walkSpeed = 3;
		this.runSpeed = 5;
	}

	@Override
	public void update() {
		int dx  = ((this.moveRight1.isPressed() || this.moveRight2.isPressed()) ? 1 : 0)
				- ((this.moveLeft1.isPressed()  || this.moveLeft2.isPressed())  ? 1 : 0);
		
		if (this.moveRun1.isPressed() || this.moveRun2.isPressed()) {
			this.velocity.x = this.runSpeed * dx;
		} else {
			this.velocity.x = this.walkSpeed * dx;
		}
		this.move();
	}

}
