package com.github.RebeccaStevens.entities;

import multikey.Key;
import processing.core.PConstants;
import processing.core.PGraphics;

public class Player extends Entity {

	private int color = 0xFFFF0000;
	
	private Key moveLeft1;
	private Key moveLeft2;
	private Key moveRight1;
	private Key moveRight2;
	private Key moveRun1;
	private Key moveRun2;
	private Key moveJump1;
	private Key moveJump2;

	private float walkSpeed = 200;
	private float runSpeed = 450;

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
		moveLeft1 = new Key(PConstants.LEFT);
		moveLeft2 = new Key('A');
		moveRight1 = new Key(PConstants.RIGHT);
		moveRight2 = new Key('D');
		moveRun1 = new Key(PConstants.SHIFT);
		moveRun2 = new Key(-1);
		moveJump1 = new Key(PConstants.UP);
		moveJump2 = new Key(' ');
	}

	@Override
	public void update() {
		int dx = ((moveRight1.isPressed() || moveRight2.isPressed()) ? 1 : 0) - ((moveLeft1.isPressed() || moveLeft2.isPressed()) ? 1 : 0);
		if (moveRun1.isPressed() || moveRun2.isPressed()) {
			this.velocity.x = runSpeed * dx;
		} else {
			this.velocity.x = walkSpeed * dx;
		}
		this.move();
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
