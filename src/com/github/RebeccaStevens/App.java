package com.github.RebeccaStevens;

import com.github.RebeccaStevens.scenes.MainMenuScene;

import gamelib.GameManager;
import keymanager.KeyManager;
import processing.core.PApplet;

/**
 * The main file that contains the entry point and has references to each top level scene.
 * 
 * @author Rebecca Stevens
 *
 */
public class App extends PApplet {
	
	/**
	 * The main applet.
	 */
	private static App me;

	/**
	 * The game settings
	 */
	private final Settings settings;
	
	/**
	 * The Game Manager
	 */
	private GameManager gameManager;
	
	/**
	 * The Key Manager
	 */
	@SuppressWarnings("unused")
	private KeyManager keyManager;

	/**
	 * The title of the game.
	 */
	private String title = "Platformer Game";

	/**
	 * The main menu scene.
	 */
	private MainMenuScene mainMenuScene;

	/**
	 * Construct a the applet.
	 */
	public App() {
		App.me = this;
		this.settings = new Settings();
	}
	
	/**
	 * @see https://processing.org/reference/settings_.html
	 */
	public void settings() {
		this.size(1024, 768);
	}
	
	/**
	 * @see https://processing.org/reference/setup_.html
	 */
	public void setup() {
		this.surface.setTitle(this.title);
		this.gameManager = new GameManager(this);
		this.keyManager = new KeyManager(this);
		this.mainMenuScene = new MainMenuScene();
		this.gameManager.setActiveScene(this.mainMenuScene);
	}
	
	/**
	 * The draw loop.
	 *
	 * @see https://processing.org/reference/draw_.html
	 */
	public void draw() {
	}
	
	/**
	 * Get the applet.
	 * 
	 * @return
	 */
	public static App getApplet() {
		return App.me;
	}
	
	/**
	 * Get the Game Manager.
	 * 
	 * @return
	 */
	public GameManager getGameManager() {
		return gameManager;
	}

	/**
	 * Get the title of the Game.
	 * 
	 * @return The Game's title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Get the game settings.
	 * 
	 * @return
	 */
	public Settings getSettings() {
		return this.settings;
	}

	/**
	 * Get the width of the viewport (in pixels).
	 * 
	 * @return
	 */
	public int getViewportWidth() {
		return this.g.width;
	}
	
	/**
	 * Get the height of the viewport (in pixels).
	 * 
	 * @return
	 */
	public int getViewportHeight() {
		return this.g.height;
	}

	/**
	 * The entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(App.class.getName());
	}

}
