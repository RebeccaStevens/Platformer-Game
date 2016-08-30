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
	 * Enter the scene.
	 */
	public abstract void enter();
	
	/**
	 * Leave the scene.
	 */
	public abstract void leave();

}
