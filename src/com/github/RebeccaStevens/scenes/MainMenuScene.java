package com.github.RebeccaStevens.scenes;

import java.awt.Font;

import com.github.RebeccaStevens.Game;

import g4p_controls.G4P;
import g4p_controls.GButton;
import g4p_controls.GEvent;
import processing.core.PConstants;
import processing.core.PGraphics;

/**
 * This scene will be used to display the main menu.
 *
 * @author Rebecca Stevens
 */
public class MainMenuScene extends Scene {

	// colors
	private int backgroundColor = 0xFF0D47A1;
	private int titleColor = 0xFFECEFF1;
	
	// buttons
	private GButton playButton;
	private GButton optionsButton;
	private GButton exitButton;
	
	// button settings
	private int buttonWidth = 250;
	private int buttonHeight = 100;
	private int buttonYGap = 25;
	private int buttonColorScheme = G4P.CYAN_SCHEME;
	private Font buttonFont = new Font("Verdana", Font.PLAIN, 32);
	
	/** 
	 * Create the menu scene.
	 */
	public MainMenuScene() {
		Game game = Game.getGame();
		PGraphics g = game.getGraphics();
		int yOffset = 0;
		
		playButton = new GButton(game, (g.width - buttonWidth) / 2, g.height * 2 / 5 + yOffset, buttonWidth, buttonHeight, "Play");
		playButton.setFont(buttonFont);
		playButton.setLocalColorScheme(buttonColorScheme);
		playButton.setEnabled(false);
		playButton.setVisible(false);
		playButton.addEventHandler(this, "playButtonEventHandler");
		
		yOffset += buttonHeight + buttonYGap;
		optionsButton = new GButton(game, (g.width - buttonWidth) / 2, g.height * 2 / 5 + yOffset, buttonWidth, buttonHeight, "Options");
		optionsButton.setFont(buttonFont);
		optionsButton.setLocalColorScheme(buttonColorScheme);
		optionsButton.setEnabled(false);
		optionsButton.setVisible(false);
		optionsButton.addEventHandler(this, "optionsButtonEventHandler");
		
		yOffset += buttonHeight + buttonYGap;
		exitButton = new GButton(game, (g.width - buttonWidth) / 2, g.height * 2 / 5 + yOffset, buttonWidth, buttonHeight, "Exit");
		exitButton.setFont(buttonFont);
		exitButton.setLocalColorScheme(buttonColorScheme);
		exitButton.setEnabled(false);
		exitButton.setVisible(false);
		exitButton.addEventHandler(this, "exitButtonEventHandler");
	}

	@Override
	protected void enter() {
		playButton.setEnabled(true);
		playButton.setVisible(true);

		optionsButton.setEnabled(true);
		optionsButton.setVisible(true);

		exitButton.setEnabled(true);
		exitButton.setVisible(true);
	}

	@Override
	protected void leave() {
		playButton.setEnabled(false);
		playButton.setVisible(false);

		optionsButton.setEnabled(false);
		optionsButton.setVisible(false);

		exitButton.setEnabled(false);
		exitButton.setVisible(false);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(PGraphics g) {
		g.pushStyle();
		
		g.background(backgroundColor);
		
		g.fill(titleColor);
		g.textAlign(PConstants.CENTER, PConstants.CENTER);
		g.textSize(Math.min(g.width / 15, g.height / 10));
		g.text(Game.getGame().getTitle(), g.width / 2, g.height / 5);
		
		g.popStyle();
	}
	
	/**
	 * Handles the play button's events.
	 * 
	 * @param button
	 * @param event
	 */
	public void playButtonEventHandler(GButton button, GEvent event) {
		if (event == GEvent.CLICKED) {
			Game game = Game.getGame();
			Scene.setCurrentScene(game.createGameScene());
		}
	}
	
	/**
	 * Handles the options button's events.
	 * 
	 * @param button
	 * @param event
	 */
	public void optionsButtonEventHandler(GButton button, GEvent event) {
		if (event == GEvent.CLICKED) {
			System.out.println("Not Implemented"); // TODO show settings
		}
	}
	
	/**
	 * Handles the exit button's events.
	 * 
	 * @param button
	 * @param event
	 */
	public void exitButtonEventHandler(GButton button, GEvent event) {
		if (event == GEvent.CLICKED) {
			Game.getGame().exit();
		}
	}

}
