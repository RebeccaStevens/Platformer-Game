package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.App;

import gamelib.game.Entity;
import gamelib.game.Level;
import processing.core.PGraphics;
import processing.core.PVector;

public class Gun extends Entity {


	private final PVector crossHairLocation;
	private long timeOfLastShot;
	private Entity welder;

	public Gun(Level level, float x, float y) {
		super(level, x, y, 0.4F, 0.2F);
		
		crossHairLocation = new PVector();
		setCollisionGroup(0);
	}

	@Override
	public void draw(PGraphics g) {
		
	}

	@Override
	public void update(float delta) {
		if (welder != null) {
			setLocation(welder.getLocation());
		}
	}

	@Override
	public void onCollidesWith(Entity entityCollidedWith) {
		
	}


	public void shoot() {
		long timeStamp = App.getApplet().getGameManager().getTime().getTimeStamp();
		if (timeOfLastShot <= timeStamp - 200) {
			new Bullet(getLevel(), getX(), getY(), crossHairLocation, welder);
			timeOfLastShot = timeStamp;
		}
	}

	/**
	 * Get the Entity that is welding this gun.
	 * @return
	 */
	public Entity getWelder() {
		return welder;
	}

	/**
	 * Set the welder of this gun.
	 * @param welder
	 */
	public void setWelder(Entity welder) {
		this.welder = welder;
	}

	public void setCrossHairLocation(PVector location) {
		crossHairLocation.set(location);
	}

}
