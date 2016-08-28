package com.github.RebeccaStevens.scenes;

import java.awt.Font;

import com.github.RebeccaStevens.Game;

import controlP5.ControlEvent;
import controlP5.ControlListener;
import controlP5.ControlP5;
import processing.core.PConstants;
import processing.core.PFont;
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
	
	// gui manager
	private ControlP5 cp5;
	
	// button settings
	private int buttonWidth = 250;
	private int buttonHeight = 100;
	private int buttonYGap = 25;
	private PFont buttonFont = new PFont(new Font("Verdana", Font.PLAIN, 32), true);
	
	/** 
	 * Create the menu scene.
	 */
	public MainMenuScene() {
		Game game = Game.getGame();

		cp5 = new ControlP5(game);
		cp5.setAutoDraw(false);
		
		int xOffset = (game.getWidth() - buttonWidth) / 2;
		int yOffset = game.getHeight() * 2 / 5;
		cp5.addButton("playButton")
			.setLabel("Play")
			.setPosition(xOffset, yOffset)
			.setSize(buttonWidth, buttonHeight)
			.setFont(buttonFont)
			.addListener(new ControlListener() {
				@Override
				public void controlEvent(ControlEvent e) {
					Game game = Game.getGame();
					Scene.setCurrentScene(game.createGameScene());
				}
			});
		
		yOffset += buttonHeight + buttonYGap;
		cp5.addButton("optionsButton")
			.setLabel("Options")
			.setPosition(xOffset, yOffset)
			.setSize(buttonWidth, buttonHeight)
			.setFont(buttonFont)
			.addListener(new ControlListener() {
				@Override
				public void controlEvent(ControlEvent e) {
					System.out.println("Not Implemented"); // TODO show settings
				}
			});
		
		yOffset += buttonHeight + buttonYGap;
		cp5.addButton("exitButton")
			.setLabel("Exit")
			.setPosition(xOffset, yOffset)
			.setSize(buttonWidth, buttonHeight)
			.setFont(buttonFont)
			.addListener(new ControlListener() {
				@Override
				public void controlEvent(ControlEvent e) {
					Game.getGame().exit();
				}
			});
	}

	@Override
	protected void enter() {
	}

	@Override
	protected void leave() {
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
		
		cp5.controlWindow.draw(g);
		
		g.popStyle();
	}

}
