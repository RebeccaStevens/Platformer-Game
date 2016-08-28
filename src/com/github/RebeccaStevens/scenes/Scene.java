package com.github.RebeccaStevens.scenes;

import com.github.RebeccaStevens.Drawable;
import com.github.RebeccaStevens.Updatable;

/**
 * Scenes are used to display things on the screen.
 * Only the `currentScene` should be updated and displayed.
 *
 * @author Rebecca Stevens
 */
public abstract class Scene implements Updatable, Drawable {
	
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
