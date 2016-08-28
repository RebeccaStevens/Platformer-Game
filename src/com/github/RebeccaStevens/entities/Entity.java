package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.Drawable;
import com.github.RebeccaStevens.Window;
import com.github.RebeccaStevens.Updatable;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PVector;

public abstract class Entity implements Updatable, Drawable {
	
	protected PVector position;
	protected PVector velocity;
	protected float width;
	protected float height;
	protected int fillColor;
	
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
	public Entity(float x, float y, float width, float height, int mode, int fillColor) {
		if (mode == PConstants.CENTER) {
			this.position = new PVector(x, y);
		} else if (mode == PConstants.CORNER) {
			this.position = new PVector(x + width / 2, y + height / 2);
		} else {
			throw new RuntimeException("unsupported entity mode");
		}
		this.velocity = new PVector();
		this.width = width;
		this.height = height;
		this.fillColor = fillColor;
	}
	
	/**
	 * Draw the entity.
	 * 
	 * @param g
	 */
	public void draw(PGraphics g) {
		g.pushStyle();
		g.pushMatrix();
		
		g.rectMode = PConstants.CENTER;
		g.translate(this.position.x, this.position.y);
		g.noStroke();
		g.fill(this.fillColor);
		g.rect(0, 0, this.width, this.height);
		
		g.popMatrix();
		g.popStyle();
	}
	
	/**
	 * Move the entity.
	 * Changes its position based on its velocity.
	 */
	protected void move() {
		float time = Window.getWindow().getTime().getTimeStep();
		this.position.x += time * this.velocity.x;
		this.position.y += time * this.velocity.y;
	}
	
	/**
	 * The minimum x position of this entity i.e the left edge.
	 * 
	 * @return
	 */
	public float getMinX() {
		return this.position.x - this.width / 2;
	}
	
	/**
	 * The maximum x position of this entity i.e the right edge.
	 * 
	 * @return
	 */
	public float getMaxX() {
		return this.position.x + this.width / 2;
	}
	
	/**
	 * The minimum y position of this entity i.e the top edge.
	 * 
	 * @return
	 */
	public float getMinY() {
		return this.position.y - this.height / 2;
	}
	
	/**
	 * The maximum y position of this entity i.e the bottom edge.
	 * 
	 * @return
	 */
	public float getMaxY() {
		return this.position.y + this.height / 2;
	}
	
	/**
	 * Test if this entity is colliding with another entity.
	 * 
	 * @param other - The other entity to test with
	 * @return True if this entity is touching the other entity
	 */
	public boolean collidesWith(Entity other) {
		if (this == other) {
			return true;
		}
		if (this.getMinX() <= other.getMaxX()
		&&  this.getMaxX() >= other.getMinX()
		&&  this.getMinY() <= other.getMaxY()
		&&  this.getMaxY() >= other.getMinY()) {
			return true;
		}
		return false;
	}

}
