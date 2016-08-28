package com.github.RebeccaStevens;

import com.github.RebeccaStevens.entities.Entity;
import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import processing.core.PApplet;
import processing.core.PVector;

public class Camera implements Updatable {
	
	/**
	 * What the camera is focused on.
	 */
	protected Entity focus;
	
	/**
	 * The camera's position.
	 */
	protected final PVector position;
	
	private float minX = Float.NEGATIVE_INFINITY;
	private float minY = Float.NEGATIVE_INFINITY;
	private float maxX = Float.POSITIVE_INFINITY;
	private float maxY = Float.POSITIVE_INFINITY;
	
	/**
	 * Create a camera not focused on (0, 0).
	 */
	public Camera() {
		this(0, 0);
	}
	
	/**
	 * Create a camera focused on the given entity.
	 */
	public Camera(Entity focus) {
		this(focus.getX(), focus.getY());
		this.focus = focus;
	}
	
	/**
	 * Create a camera focused on the given position.
	 */
	public Camera(float x, float y) {
		position = new PVector(x, y);
	}

	@Override
	public void update() {
		if (focus != null) {
			position.set(focus.getX(), focus.getY());
		}
		
		position.x = PApplet.constrain(position.x, minX, maxX);
		position.y = PApplet.constrain(position.y, minY, maxY);
	}

	/**
	 * Get the Entity the camera is focused on.
	 * 
	 * @return
	 */
	public Entity getFocus() {
		return focus;
	}

	/**
	 * Set the Entity for the camera to focus on.
	 * 
	 * @param focus the focus to set
	 */
	public void setFocus(Entity focus) {
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

	/**
	 * Get the position of the camera.
	 * 
	 * @return
	 */
	public PVector getPosition() {
		return position.copy();
	}
	
	/**
	 * Get the x position of the camera.
	 * 
	 * @return
	 */
	public float getX() {
		return position.x;
	}

	/**
	 * Get the y position of the camera.
	 * 
	 * @return
	 */
	public float getY() {
		return position.y;
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

}
