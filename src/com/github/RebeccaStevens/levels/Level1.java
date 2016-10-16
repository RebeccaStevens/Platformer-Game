package com.github.RebeccaStevens.levels;

import com.github.RebeccaStevens.App;
import com.github.RebeccaStevens.entities.CrossHair;
import com.github.RebeccaStevens.entities.Player;

import gamelib.game.Level2D;
import gamelib.game.cameras.CameraFollow;
import gamelib.game.entities.platforms.BasicPlatform;
import processing.core.PGraphics;

public class Level1 extends Level2D {
	
	// colors
	private int backgroundColor = 0xFF64B5F6;
	
	private Player player;
	private CrossHair crosshair;
	
	private CameraFollow camera;

	public Level1() {
		setGravity(-20F);
//		setDrawGrid(true);
//		setDrawBoundingBoxes(true);
		
		setZoom(0.67F);
		
		this.player = new Player(this, 0, 0, 1, 2);
		resetPlayer();
		this.crosshair = new CrossHair(this, 5, 5);
		
		this.camera = new CameraFollow(this, this.player);
		setCamera(this.camera);

		// Create the platforms
		float x = 0;
		float y = 0;
		float w = 25;
		float h = 4;
		float gap = 0;
		
		new BasicPlatform(this, x, y, w, h);
		new BasicPlatform(this, x + 10, y + h - 0.5F, 4F, 1.75F);
		new BasicPlatform(this, x + 13, y + h - 0.5F, 4F, 3F);
		new BasicPlatform(this, x + 16, y + h - 0.5F, 3F, 4.25F);
		
		gap = 3.5F;
		x += w + gap;
		w = 8;
		new BasicPlatform(this, x, y, w, h);
		
		gap = 5F;
		x += w + gap;
		w = 6F;
		new BasicPlatform(this, x, y, w, h);
		
		// Apply limits
		App app = App.getApplet();
		this.player.limitXMin(this.player.getWidth() / 2);
		this.camera.limitAbsoluteXMin(app.getViewportWidth() / 2);
		this.camera.limitAbsoluteYMax(app.getViewportHeight() / 2);
	}

	@Override
	public void preUpdate(float delta) {
		App app = App.getApplet();
		crosshair.setLocationOnScreen(app.mouseX, app.mouseY);
		player.getWeapon().setCrossHairLocation(crosshair.getLocation());
	}

	@Override
	public void postUpdate(float delta) {
		if (player.getY() < -5) {
			resetPlayer();
		}
	}

	@Override
	public void drawBackground(PGraphics g) {
		g.background(backgroundColor);
	}

	@Override
	public void drawOverlay(PGraphics g) {
		this.crosshair.draw(g);
	}
	
	/**
	 * Reset the player.
	 */
	private void resetPlayer() {
		player.setLocation(2, 6.1F);
		player.setVelocity(0, 0);
	}
}
