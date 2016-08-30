package com.github.RebeccaStevens;

import processing.core.PConstants;

public final class Settings {

	private final float wideScreenAspectRatio = 16F / 9F;
	
	private final float normalScreenAspectRatio = 4F / 3F;
	
	private boolean wideScreen = false;
	

	
	// Player Controls
	private int keyCodePlayerMoveLeft1 = PConstants.LEFT;
	private int keyCodePlayerMoveLeft2 = 'A';
	private int keyCodePlayerMoveRight1 = PConstants.RIGHT;
	private int keyCodePlayerMoveRight2 = 'D';
	private int keyCodePlayerMoveRun1 = PConstants.SHIFT;
	private int keyCodePlayerMoveRun2 = 0;
	private int keyCodePlayerMoveJump1 = PConstants.UP;
	private int keyCodePlayerMoveJump2 = ' ';

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
	
	/**
	 * @return
	 */
	public int getKeyCodePlayerMoveLeft1() {
		return keyCodePlayerMoveLeft1;
	}

	/**
	 * @return
	 */
	public int getKeyCodePlayerMoveLeft2() {
		return keyCodePlayerMoveLeft2;
	}

	/**
	 * @return
	 */
	public int getKeyCodePlayerMoveRight1() {
		return keyCodePlayerMoveRight1;
	}

	/**
	 * @return
	 */
	public int getKeyCodePlayerMoveRight2() {
		return keyCodePlayerMoveRight2;
	}

	/**
	 * @return
	 */
	public int getKeyCodePlayerMoveRun1() {
		return keyCodePlayerMoveRun1;
	}

	/**
	 * @return
	 */
	public int getKeyCodePlayerMoveRun2() {
		return keyCodePlayerMoveRun2;
	}

	/**
	 * @return
	 */
	public int getKeyCodePlayerMoveJump1() {
		return keyCodePlayerMoveJump1;
	}

	/**
	 * @return
	 */
	public int getKeyCodePlayerMoveJump2() {
		return keyCodePlayerMoveJump2;
	}

	/**
	 * @param keyCodePlayerMoveLeft1
	 */
	public void setKeyCodePlayerMoveLeft1(int keyCodePlayerMoveLeft1) {
		this.keyCodePlayerMoveLeft1 = keyCodePlayerMoveLeft1;
	}

	/**
	 * @param keyCodePlayerMoveLeft2
	 */
	public void setKeyCodePlayerMoveLeft2(int keyCodePlayerMoveLeft2) {
		this.keyCodePlayerMoveLeft2 = keyCodePlayerMoveLeft2;
	}

	/**
	 * @param keyCodePlayerMoveRight1
	 */
	public void setKeyCodePlayerMoveRight1(int keyCodePlayerMoveRight1) {
		this.keyCodePlayerMoveRight1 = keyCodePlayerMoveRight1;
	}

	/**
	 * @param keyCodePlayerMoveRight2
	 */
	public void setKeyCodePlayerMoveRight2(int keyCodePlayerMoveRight2) {
		this.keyCodePlayerMoveRight2 = keyCodePlayerMoveRight2;
	}

	/**
	 * @param keyCodePlayerMoveRun1
	 */
	public void setKeyCodePlayerMoveRun1(int keyCodePlayerMoveRun1) {
		this.keyCodePlayerMoveRun1 = keyCodePlayerMoveRun1;
	}

	/**
	 * @param keyCodePlayerMoveRun2
	 */
	public void setKeyCodePlayerMoveRun2(int keyCodePlayerMoveRun2) {
		this.keyCodePlayerMoveRun2 = keyCodePlayerMoveRun2;
	}

	/**
	 * @param keyCodePlayerMoveJump1
	 */
	public void setKeyCodePlayerMoveJump1(int keyCodePlayerMoveJump1) {
		this.keyCodePlayerMoveJump1 = keyCodePlayerMoveJump1;
	}

	/**
	 * @param keyCodePlayerMoveJump2
	 */
	public void setKeyCodePlayerMoveJump2(int keyCodePlayerMoveJump2) {
		this.keyCodePlayerMoveJump2 = keyCodePlayerMoveJump2;
	}
}
