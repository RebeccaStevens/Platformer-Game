package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.App;

import gamelib.game.Entity;
import gamelib.game.Level;
import processing.core.PGraphics;
import processing.core.PVector;

public class Bullet extends Entity {

	private float speed;
	private final long lifeSpan = 1000L;
	private long lifeDeathTime;

	public Bullet(Level level, float x, float y, PVector target, Entity shooter) {
		super(level, x, y, 1, 0.5F);
		speed = 25;
		
		lifeDeathTime = App.getApplet().getGameManager().getTime().getTimeStamp() + lifeSpan;
		
		PVector vel = PVector.sub(target, this.getLocation()).normalize().mult(speed);
		this.setRotation2D(-vel.heading());
		setVelocity(vel);
		setCollisionGroup(3);
		ignoreInCollisions(shooter);
	}

	@Override
	public void draw(PGraphics g) {
		g.fill(0, 0, 255);
		g.noStroke();
		g.rect(0, 0, getWidthInPixels(), getHeightInPixels());
	}

	@Override
	public void update(float delta) {
		if (App.getApplet().getGameManager().getTime().getTimeStamp() >= lifeDeathTime) {
			remove();
		}
	}

	@Override
	public void onCollidesWith(Entity entityCollidedWith) {
		remove();
	}

}
