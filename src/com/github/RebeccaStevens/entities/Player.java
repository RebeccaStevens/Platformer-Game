package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.App;
import com.github.RebeccaStevens.Settings;

import gamelib.game.Entity;
import gamelib.game.Level;
import gamelib.game.entities.Actor;
import inputmanager.Input;
import processing.core.PGraphics;

public class Player extends Actor {
	
	private static final int fillColor = 0xFFFF0000;
	
	private final Input moveLeft1  = new Input();
	private final Input moveLeft2  = new Input();
	private final Input moveRight1 = new Input();
	private final Input moveRight2 = new Input();
	private final Input moveRun1   = new Input();
	private final Input moveRun2   = new Input();
	private final Input moveJump1  = new Input();
	private final Input moveJump2  = new Input();
	
	private final Input fightPrimary1 = new Input();
	private final Input fightPrimary2 = new Input();

	private float airSpeed;
	private float walkSpeed;
	private float runSpeed;
	private float jumpSpeed;
	
	private Gun weapon;

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
		
		setWeapon(new Gun(level, x, y));
		
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
		
		if (this.fightPrimary1.isPressed() || this.fightPrimary2.isPressed()) {
			weapon.shoot();
		}
	}

	@Override
	public void draw(PGraphics g) {
		g.noStroke();
		g.fill(fillColor);
		g.rect(0, 0, getWidthInPixels(), getHeightInPixels());
	}

	@Override
	public void onCollidesWith(Entity entityCollidedWith) {
		
	}

	/**
	 * Get the player's weapon.
	 * @return
	 */
	public Gun getWeapon() {
		return weapon;
	}

	/**
	 * Set the player's weapon.
	 * @param weapon
	 */
	public void setWeapon(Gun weapon) {
		this.weapon = weapon;
		this.weapon.setWelder(this);
	}

	/**
	 * Update the key binds according to the game settings.
	 */
	public void updateKeyBindings() {
		Settings settings = App.getApplet().getSettings();
		
		this.moveLeft1.setInput(settings.inputPlayerMoveLeft1.getType(), settings.inputPlayerMoveLeft1.getInputCode());
		this.moveLeft2.setInput(settings.inputPlayerMoveLeft2.getType(), settings.inputPlayerMoveLeft2.getInputCode());
		this.moveRight1.setInput(settings.inputPlayerMoveRight1.getType(), settings.inputPlayerMoveRight1.getInputCode());
		this.moveRight2.setInput(settings.inputPlayerMoveRight2.getType(), settings.inputPlayerMoveRight2.getInputCode());
		this.moveRun1.setInput(settings.inputPlayerMoveRun1.getType(), settings.inputPlayerMoveRun1.getInputCode());
		this.moveRun2.setInput(settings.inputPlayerMoveRun2.getType(), settings.inputPlayerMoveRun2.getInputCode());
		this.moveJump1.setInput(settings.inputPlayerMoveJump1.getType(), settings.inputPlayerMoveJump1.getInputCode());
		this.moveJump2.setInput(settings.inputPlayerMoveJump2.getType(), settings.inputPlayerMoveJump2.getInputCode());
		
		this.fightPrimary1.setInput(settings.inputPlayerFightPrimary1.getType(), settings.inputPlayerFightPrimary1.getInputCode());
		this.fightPrimary2.setInput(settings.inputPlayerFightPrimary2.getType(), settings.inputPlayerFightPrimary2.getInputCode());
	}

}
