package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.Updatable;
import com.github.RebeccaStevens.Window;
import com.github.RebeccaStevens.levels.Level;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Entity implements Updatable{

	protected final Level level;
	protected final PVector position;
	protected final PVector velocity;
	
	private float minX = Float.NEGATIVE_INFINITY;
	private float minY = Float.NEGATIVE_INFINITY;
	private float maxX = Float.POSITIVE_INFINITY;
	private float maxY = Float.POSITIVE_INFINITY;
	
	/**
	 * Create the entity.
	 * 
	 * @param level - The level this entity is in
	 * @param x - The starting x position of the entity
	 * @param y - The starting y position of the entity
	 */
	public Entity(Level level, float x, float y) {
		this.level = level;
		this.position = new PVector(x, y);
		this.velocity = new PVector();
	}
	
	/**
	 * Move the entity.
	 * Changes its position based on its velocity.
	 */
	protected void move() {
		float time = Window.getWindow().getTime().getTimeStep();
		this.position.x += time * level.convertGridUnitsVelocityXToPixels(this.velocity.x);
		this.position.y += time * level.convertGridUnitsVelocityYToPixels(this.velocity.y);
		this.constrain();
	}

	/**
	 * Get the level this entity is on.
	 * 
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * Set the min x position of the camera.
	 * 
	 * @param minX
	 */
	public void setMinX(float minX) {
		this.minX = minX;
	}

	/**
	 * Set the min y position of the camera.
	 * 
	 * @param minY
	 */
	public void setMinY(float minY) {
		this.minY = minY;
	}

	/**
	 * Set the max x position of the camera.
	 * 
	 * @param maxX
	 */
	public void setMaxX(float maxX) {
		this.maxX = maxX;
	}

	/**
	 * Set the max y position of the camera.
	 * 
	 * @param maxY
	 */
	public void setMaxY(float maxY) {
		this.maxY = maxY;
	}
	
	/**
	 * Constrain the entity's position.
	 */
	protected void constrain() {
		position.x = PApplet.constrain(position.x, minX, maxX);
		position.y = PApplet.constrain(position.y, minY, maxY);
	}
}
