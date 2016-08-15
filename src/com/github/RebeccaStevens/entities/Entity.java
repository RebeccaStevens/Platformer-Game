package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.Time;

import processing.core.PGraphics;
import processing.core.PVector;

public abstract class Entity {
	
	protected PVector position;
	protected PVector velocity;
	protected float width;
	protected float height;
	
	/**
	 * Create the entity.
	 * 
	 * @param x - The starting x position of the entity 
	 * @param y - The starting y position of the entity
	 * @param width - The width of the entity
	 * @param height - The height of the entity
	 */
	public Entity(float x, float y, float width, float height) {
		this.position = new PVector(x, y);
		this.velocity = new PVector();
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Update the entity. I.e. Move it 
	 */
	abstract public void update();
	
	/**
	 * Draw the entity.
	 * 
	 * @param g
	 */
	abstract public void draw(PGraphics g);
	
	/**
	 * Move the entity.
	 * Changes its position based on its velocity.
	 */
	protected void move() {
		float time = Time.getTimeStep();
		this.position.x += time * this.velocity.x;
		this.position.y += time * this.velocity.y;
	}

}
