package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.App;
import com.github.RebeccaStevens.Settings;

import gamelib.game.Entity;
import gamelib.game.Level;
import gamelib.game.entities.Actor;
import keymanager.Key;
import processing.core.PGraphics;
import processing.core.PVector;

public class Player extends Actor {
	
	private static final int fillColor = 0xFFFF0000;
	
	private final Key moveLeft1  = new Key();
	private final Key moveLeft2  = new Key();
	private final Key moveRight1 = new Key();
	private final Key moveRight2 = new Key();
	private final Key moveRun1   = new Key();
	private final Key moveRun2   = new Key();
	private final Key moveJump1  = new Key();
	private final Key moveJump2  = new Key();
	
	private final Key fightShoot1 = new Key();
	private final Key fightShoot2 = new Key();

	private float airSpeed;
	private float walkSpeed;
	private float runSpeed;
	private float jumpSpeed;

	private final PVector crossHairLocation;
	
	private long timeOfLastShot;

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
		super(level, x, y, width, height, 10);
		
		crossHairLocation = new PVector();
		
		updateKeyBindings();

		this.airSpeed  = 0.5F;
		this.walkSpeed =  7F;
		this.runSpeed  = 11F;
		this.jumpSpeed =  5F;
	}

	@Override
	public void update(float delta) {
		int dx  = ((this.moveRight1.isPressed() || this.moveRight2.isPressed()) ? 1 : 0)
				- ((this.moveLeft1.isPressed()  || this.moveLeft2.isPressed())  ? 1 : 0);
		
		if (this.isOnGround()) {
			if (this.moveJump1.isPressed() || this.moveJump2.isPressed()) {
				addVelocity(0, jumpSpeed);
			}
			
			if (this.moveRun1.isPressed() || this.moveRun2.isPressed()) {
				setVelocityX(this.runSpeed * dx);
			} else {
				setVelocityX(this.walkSpeed * dx);
			}
			setVelocityOffsetX(0);
		} else {
			setVelocityOffsetX(this.airSpeed * dx);
		}
		
		if (this.fightShoot1.isPressed() || this.fightShoot2.isPressed()) {
			long timeStamp = App.getApplet().getGameManager().getTime().getTimeStamp();
			if (timeOfLastShot <= timeStamp - 200) {
				new Bullet(getLevel(), getX(), getY(), crossHairLocation, this);
				timeOfLastShot = timeStamp;
			}
		}
	}

	/**
	 * Update the key binds according to the game settings.
	 */
	public void updateKeyBindings() {
		Settings settings = App.getApplet().getSettings();
		
		this.moveLeft1.setKeyCode(settings.getKeyCodePlayerMoveLeft1());
		this.moveLeft2.setKeyCode(settings.getKeyCodePlayerMoveLeft2());
		this.moveRight1.setKeyCode(settings.getKeyCodePlayerMoveRight1());
		this.moveRight2.setKeyCode(settings.getKeyCodePlayerMoveRight2());
		this.moveRun1.setKeyCode(settings.getKeyCodePlayerMoveRun1());
		this.moveRun2.setKeyCode(settings.getKeyCodePlayerMoveRun2());
		this.moveJump1.setKeyCode(settings.getKeyCodePlayerMoveJump1());
		this.moveJump2.setKeyCode(settings.getKeyCodePlayerMoveJump2());
		this.fightShoot1.setKeyCode(settings.getKeyCodePlayerFightShoot1());
		this.fightShoot2.setKeyCode(settings.getKeyCodePlayerFightShoot2());
	}

	@Override
	public void draw(PGraphics g) {
		g.noStroke();
		g.fill(fillColor);
		g.rect(0, 0, getWidthInPixels(), getHeightInPixels());
	}

	public void setCrossHairLocation(PVector location) {
		crossHairLocation.set(location);
	}

	@Override
	public void onCollidesWith(Entity entityCollidedWith) {
		
	}

}
