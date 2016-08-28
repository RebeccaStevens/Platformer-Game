package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.Updatable;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Entity implements Updatable{

	protected final PVector position;
	protected final PVector velocity;
	
	private float minX = Float.NEGATIVE_INFINITY;
	private float minY = Float.NEGATIVE_INFINITY;
	private float maxX = Float.POSITIVE_INFINITY;
	private float maxY = Float.POSITIVE_INFINITY;
	
	/**
	 * Create the entity.
	 * 
	 * @param x - The starting x position of the entity 
	 * @param y - The starting y position of the entity
	 * @param width - The width of the entity
	 * @param height - The height of the entity
	 * @param mode 
	 * @param fillColor - The fill color of the entity
	 */
	public Entity(float x, float y) {
		this.position = new PVector(x, y);
		this.velocity = new PVector();
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
