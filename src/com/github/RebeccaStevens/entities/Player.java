package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.App;
import com.github.RebeccaStevens.Settings;
import com.github.RebeccaStevens.levels.Level;

import multikey.Key;
import processing.core.PConstants;

public class Player extends DrawableEntity {
	
	private static final int fillColor = 0xFFFF0000;
	
	private final Key moveLeft1  = new Key();
	private final Key moveLeft2  = new Key();
	private final Key moveRight1 = new Key();
	private final Key moveRight2 = new Key();
	private final Key moveRun1   = new Key();
	private final Key moveRun2   = new Key();
	private final Key moveJump1  = new Key();
	private final Key moveJump2  = new Key();

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
		
		updateKeyBindings();
		
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

	/**
	 * Update the key binds according to the game settings.
	 */
	public void updateKeyBindings() {
		Settings settings = App.getApp().getSettings();
		
		this.moveLeft1.setKeyCode(settings.getKeyCodePlayerMoveLeft1());
		this.moveLeft2.setKeyCode(settings.getKeyCodePlayerMoveLeft2());
		this.moveRight1.setKeyCode(settings.getKeyCodePlayerMoveRight1());
		this.moveRight2.setKeyCode(settings.getKeyCodePlayerMoveRight2());
		this.moveRun1.setKeyCode(settings.getKeyCodePlayerMoveRun1());
		this.moveRun2.setKeyCode(settings.getKeyCodePlayerMoveRun2());
		this.moveJump1.setKeyCode(settings.getKeyCodePlayerMoveJump1());
		this.moveJump2.setKeyCode(settings.getKeyCodePlayerMoveJump2());
	}

}
