package com.github.RebeccaStevens;

import com.github.RebeccaStevens.scenes.GameScene;
import com.github.RebeccaStevens.scenes.MainMenuScene;
import com.github.RebeccaStevens.scenes.Scene;

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
	 * The menu scene.
	 */
	private MainMenuScene mainMenuScene;
	
	/**
	 * The game scene.
	 */
	private GameScene gameScene;

	/**
	 * The title of the game.
	 */
	private String title = "Platformer Game";

	/**
	 * Construct a the Game Object.
	 */
	public Game() {
		Game.me = this;
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
		Time.update();
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
	 * Get the title of the Game.
	 * 
	 * @return The Game's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Create a new game scene.
	 */
	public GameScene createGameScene() {
		return gameScene = new GameScene();
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
	 * The entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(Game.class.getName());
	}

}
