package com.github.RebeccaStevens.entities;

import java.security.InvalidParameterException;

import com.github.RebeccaStevens.Drawable;
import com.github.RebeccaStevens.Window;
import com.github.RebeccaStevens.levels.Level;

import processing.core.PConstants;
import processing.core.PGraphics;

public abstract class DrawableEntity extends Entity implements Drawable {
	
	protected float width;
	protected float height;
	protected int fillColor;
	
	/**
	 * Create the entity.
	 * 
	 * @param level - The level this entity is in
	 * @param x - The starting x position of the entity 
	 * @param y - The starting y position of the entity
	 * @param width - The width of the entity
	 * @param height - The height of the entity
	 * @param mode - The drawing mode of the entity
	 * @param fillColor - The fill color of the entity
	 */
	public DrawableEntity(Level level, float x, float y, float width, float height, int mode, int fillColor) {
		super(level, x, y);
		if (mode == PConstants.CENTER) {
			// no action needed
		} else if (mode == PConstants.CORNER) {
			this.position.add(width / 2, height / 2);
		} else {
			throw new InvalidParameterException("unsupported entity draw mode");
		}
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
	 * This entity's x position.
	 * 
	 * @return
	 */
	public float getX() {
		return position.x;
	}

	/**
	 * This entity's y position.
	 * 
	 * @return
	 */
	public float getY() {
		return position.y;
	}
	
	/**
	 * Get the width of the entity.
	 * 
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * Set the width of the entity.
	 * 
	 * @param width
	 */
	public void setWidth(float width) {
		if (width <= 0) {
			throw new InvalidParameterException();
		}
		this.width = width;
	}

	/**
	 * Get the height of the entity.
	 * 
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Set the height of the entity.
	 * 
	 * @param height
	 */
	public void setHeight(float height) {
		if (height <= 0) {
			throw new InvalidParameterException();
		}
		this.height = height;
	}

	/**
	 * The left edge's position of this entity.
	 * 
	 * @return
	 */
	public float getLeftEdgePosition() {
		return this.position.x - this.width / 2;
	}
	
	/**
	 * The right edge's position of this entity.
	 * 
	 * @return
	 */
	public float getRightEdgePosition() {
		return this.position.x + this.width / 2;
	}
	
	/**
	 * The top edge's position  of this entity.
	 * 
	 * @return
	 */
	public float getTopEdgePosition() {
		return this.position.y - this.height / 2;
	}
	
	/**
	 * The bottom edge's position  of this entity.
	 * 
	 * @return
	 */
	public float getBottomEdgePosition() {
		return this.position.y + this.height / 2;
	}
	
	/**
	 * Test if this entity is colliding with another entity.
	 * 
	 * @param other - The other entity to test with
	 * @return True if this entity is touching the other entity
	 */
	public boolean collidesWith(DrawableEntity other) {
		if (this == other) {
			return true;
		}
		if (this.getLeftEdgePosition() <= other.getRightEdgePosition()
		&&  this.getRightEdgePosition() >= other.getLeftEdgePosition()
		&&  this.getTopEdgePosition() <= other.getBottomEdgePosition()
		&&  this.getBottomEdgePosition() >= other.getTopEdgePosition()) {
			return true;
		}
		return false;
	}

}
