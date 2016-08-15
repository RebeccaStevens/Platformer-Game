package com.github.RebeccaStevens.scenes;

import processing.core.PGraphics;

/**
 * Scenes are used to display things on the screen.
 * Only the `currentScene` should be updated and displayed.
 *
 * @author Rebecca Stevens
 */
public abstract class Scene {
	
	/**
	 * The scene currently being displayed.
	 */
	private static Scene currentScene;

	/**
	 * Enter the scene.
	 */
	protected abstract void enter();
	
	/**
	 * Leave the scene.
	 */
	protected abstract void leave();
	
	/**
	 * Update everything in the scene.
	 */
	public abstract void update();
	
	/**
	 * Draw everything in the scene.
	 */
	public abstract void draw(PGraphics g);
	
	/**
	 * Get the current scene.
	 * @return
	 */
	public static Scene getCurrentScene() {
		return currentScene;
	}

	/**
	 * Change the scene.
	 * 
	 * @param changeTo - The scene to change to.
	 */
	public static void setCurrentScene(Scene changeTo) {
		if (currentScene != null) {
			currentScene.leave();
		}
		currentScene = changeTo;
		currentScene.enter();
	}

}
