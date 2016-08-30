package com.github.RebeccaStevens;

import com.github.RebeccaStevens.scenes.GameScene;
import com.github.RebeccaStevens.scenes.MainMenuScene;
import com.github.RebeccaStevens.scenes.Scene;

import multikey.MultiKeyManager;
import processing.core.PApplet;

/**
 * The main file that contains the entry point and has references to each top level scene.
 * 
 * @author Rebecca Stevens
 *
 */
public class App extends PApplet {
	
	/**
	 * The main Game Object.
	 */
	private static App me;
	
	/**
	 * The title of the game.
	 */
	private final String title = "Platformer Game";

	/**
	 * The game settings
	 */
	private final Settings settings;

	/**
	 * Manages the game time.
	 */
	private final Time time;

	/**
	 * The scene currently being displayed.
	 */
	private Scene currentScene;

	/**
	 * The menu scene.
	 */
	private MainMenuScene mainMenuScene;
	
	/**
	 * The game scene.
	 */
	private GameScene gameScene;
	
	/**
	 * Construct a the Game Object.
	 */
	public App() {
		App.me = this;
		this.settings = new Settings();
		this.time = new Time();
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
		new MultiKeyManager(this);
		this.mainMenuScene = new MainMenuScene();
		this.setCurrentScene(this.mainMenuScene);
	}
	
	/**
	 * The draw loop.
	 *
	 * @see https://processing.org/reference/draw_.html
	 */
	public void draw() {
		Scene scene = this.getCurrentScene();
		this.time.update();
		if (scene != null) {
			scene.update();
			scene.draw(this.g);
		}
	}
	
	/**
	 * Get the window.
	 * 
	 * @return
	 */
	public static App getApp() {
		return App.me;
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
	 * Get the Time object.
	 * 
	 * @return
	 */
	public Time getTime() {
		return this.time;
	}

	/**
	 * Get the width in pixels of the game.
	 * 
	 * @return
	 */
	public int getWidth() {
		return this.g.width;
	}
	
	/**
	 * Get the height in pixels of the game
	 * 
	 * @return
	 */
	public int getHeight() {
		return this.g.height;
	}
	
	/**
	 * Get the current scene.
	 * @return
	 */
	public Scene getCurrentScene() {
		return this.currentScene;
	}

	/**
	 * Change the scene.
	 * 
	 * @param changeTo - The scene to change to.
	 */
	public void setCurrentScene(Scene changeTo) {
		if (this.currentScene != null) {
			this.currentScene.leave();
		}
		this.currentScene = changeTo;
		this.currentScene.enter();
	}

	/**
	 * Get the menu scene.
	 * 
	 * @return The menu scene
	 */
	public MainMenuScene getMainMenuScene() {
		return this.mainMenuScene;
	}

	/**
	 * Get the game scene.
	 * 
	 * @return The game scene
	 */
	public GameScene getGameScene() {
		return this.gameScene;
	}

	/**
	 * Create a new game scene.
	 */
	public GameScene createGameScene() {
		this.gameScene = new GameScene();
		this.gameScene.setLevel(1);
		return this.gameScene;
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
