package com.github.RebeccaStevens.scenes;

import java.awt.Font;

import com.github.RebeccaStevens.Window;

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
	private static final int backgroundColor = 0xFF0D47A1;
	private static final int titleColor = 0xFFECEFF1;
	
	// gui manager
	private final ControlP5 cp5;
	
	// button settings
	private static final int buttonWidth = 250;
	private static final int buttonHeight = 100;
	private static final int buttonYGap = 25;
	private static final PFont buttonFont = new PFont(new Font("Verdana", Font.PLAIN, 32), true);
	private static final int buttonColorBackground = 0xFF5bc0de;
	private static final int buttonColorForeground = 0xFF31b0d5;
	private static final int buttonColorActive = 0xFF0275d8;
	private static final int buttonColorLabel = 0xFFFFFFFF;
	
	/** 
	 * Create the menu scene.
	 */
	public MainMenuScene() {
		Window window = Window.getWindow();

		cp5 = new ControlP5(window);
		cp5.setAutoDraw(false);
		cp5.hide();
		
		int xOffset = (window.getWidth() - buttonWidth) / 2;
		int yOffset = window.getHeight() * 2 / 5;
		cp5.addButton("playButton")
			.setLabel("Play")
			.setPosition(xOffset, yOffset)
			.setSize(buttonWidth, buttonHeight)
			.setColorBackground(buttonColorBackground)
			.setColorForeground(buttonColorForeground)
			.setColorActive(buttonColorActive)
			.setColorLabel(buttonColorLabel)
			.setFont(buttonFont)
			.addListener(new ControlListener() {
				@Override
				public void controlEvent(ControlEvent e) {
					Window window = Window.getWindow();
					Scene.setCurrentScene(window.createGameScene());
				}
			});
		
		yOffset += buttonHeight + buttonYGap;
		cp5.addButton("optionsButton")
			.setLabel("Options")
			.setPosition(xOffset, yOffset)
			.setSize(buttonWidth, buttonHeight)
			.setSize(buttonWidth, buttonHeight)
			.setColorBackground(buttonColorBackground)
			.setColorForeground(buttonColorForeground)
			.setColorActive(buttonColorActive)
			.setColorLabel(buttonColorLabel)
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
			.setSize(buttonWidth, buttonHeight)
			.setColorBackground(buttonColorBackground)
			.setColorForeground(buttonColorForeground)
			.setColorActive(buttonColorActive)
			.setColorLabel(buttonColorLabel)
			.setFont(buttonFont)
			.addListener(new ControlListener() {
				@Override
				public void controlEvent(ControlEvent e) {
					Window.getWindow().exit();
				}
			});
	}

	@Override
	protected void enter() {
		cp5.show();
	}

	@Override
	protected void leave() {
		cp5.hide();
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
		g.text(Window.getWindow().getTitle(), g.width / 2, g.height / 5);
		
		cp5.controlWindow.draw(g);
		
		g.popStyle();
	}

}
