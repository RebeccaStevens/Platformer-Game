package com.github.RebeccaStevens;

public class Settings {

	private boolean wideScreen = false;
	
	private float wideScreenAspectRatio = 16F / 9F;
	
	private float normalScreenAspectRatio = 4F / 3F;

	/**
	 * Returns if the game should is being played in wide screen.
	 * 
	 * @return
	 */
	public boolean isWideScreen() {
		return wideScreen;
	}

	/**
	 * Set whether or not the game is in wide screen mode.
	 * 
	 * @param wideScreen
	 */
	public void setWideScreen(boolean wideScreen) {
		this.wideScreen = wideScreen;
	}
	
	/**
	 * Get the game's aspect ratio.
	 * 
	 * @return
	 */
	public float getAspectRation() {
		if (wideScreen) {
			return wideScreenAspectRatio;
		} else {
			return normalScreenAspectRatio;
		}
	}
}
