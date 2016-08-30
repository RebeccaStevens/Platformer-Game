package com.github.RebeccaStevens.entities;

import com.github.RebeccaStevens.levels.Level;

import processing.core.PVector;

public class Camera extends Entity {
	
	/**
	 * What the camera is focused on.
	 */
	protected DrawableEntity focus;
	
	/**
	 * Create a camera focused at (0, 0).
	 */
	public Camera(Level level) {
		this(level, 0, 0);
	}
	
	/**
	 * Create a camera focused on the given entity.
	 */
	public Camera(Level level, DrawableEntity focus) {
		this(level, focus.getX(), focus.getY());
		this.focus = focus;
	}
	
	/**
	 * Create a camera focused on the given position.
	 */
	public Camera(Level level, float x, float y) {
		super(level, x, y);
	}

	@Override
	public void update() {
		if (focus != null) {
			position.set(focus.getX(), focus.getY());
		}
		
		constrain();
	}

	/**
	 * Get the Entity the camera is focused on.
	 * 
	 * @return
	 */
	public DrawableEntity getFocus() {
		return focus;
	}

	/**
	 * Set the Entity for the camera to focus on.
	 * 
	 * @param focus the focus to set
	 */
	public void setFocus(DrawableEntity focus) {
		this.focus = focus;
	}

	/**
	 * Focus the camera on the given position.
	 * This will stop the camera from focusing on an entity if it currently is.
	 * 
	 * @param focus the focus to set
	 */
	public void setFocus(float x, float y) {
		focus = null;
		position.set(x, y);
	}

}
