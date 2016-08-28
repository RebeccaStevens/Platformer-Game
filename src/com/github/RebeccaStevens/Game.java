package com.github.RebeccaStevens;

import com.github.RebeccaStevens.scenes.GameScene;
import com.github.RebeccaStevens.scenes.MainMenuScene;
import com.github.RebeccaStevens.scenes.Scene;

import multikey.MultiKeyManager;
import processing.core.PApplet;
import processing.core.PGraphics;

/**
 * The main file that contains the entry point and has references to each top level scene.
 * 
 * @author Rebecca Stevens
 *
 */
public class Game extends PApplet {
	
	/**
	 * The main Game Object.
	 */
	private static Game me;
	
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
	public Game() {
		Game.me = this;
		settings = new Settings();
		time = new Time();
	}
	
	/**
	 * @see https://processing.org/reference/settings_.html
	 */
	public void settings() {
		size(1024, 768);
	}
	
	/**
	 * @see https://processing.org/reference/setup_.html
	 */
	public void setup() {
		surface.setTitle(title);
		new MultiKeyManager(this);
		mainMenuScene = new MainMenuScene();
		Scene.setCurrentScene(mainMenuScene);
	}
	
	/**
	 * The draw loop.
	 *
	 * @see https://processing.org/reference/draw_.html
	 */
	public void draw() {
		Scene scene = Scene.getCurrentScene();
		time.update();
		if (scene != null) {
			scene.update();
			scene.draw(g);
		}
	}
	
	/**
	 * Get the Game Object.
	 * 
	 * @return
	 */
	public static Game getGame() {
		return me;
	}
	
	/**
	 * Get the title of the Game.
	 * 
	 * @return The Game's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Get the Graphics Object.
	 * 
	 * @return The Graphics Object
	 */
	public PGraphics getGraphics() {
		return g;
	}
	
	/**
	 * Get the game settings.
	 * 
	 * @return
	 */
	public Settings getSettings() {
		return settings;
	}
	
	/**
	 * Get the Time object.
	 * 
	 * @return
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * Get the width in pixels of the game.
	 * 
	 * @return
	 */
	public int getWidth() {
		return g.width;
	}
	
	/**
	 * Get the height in pixels of the game
	 * 
	 * @return
	 */
	public int getHeight() {
		return g.height;
	}
	
	/**
	 * Get the menu scene.
	 * 
	 * @return The menu scene
	 */
	public MainMenuScene getMainMenuScene() {
		return mainMenuScene;
	}

	/**
	 * Get the game scene.
	 * 
	 * @return The game scene
	 */
	public GameScene getGameScene() {
		return gameScene;
	}

	/**
	 * Create a new game scene.
	 */
	public GameScene createGameScene() {
		return gameScene = new GameScene();
	}

	/**
	 * The entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(Game.class.getName());
	}

}
