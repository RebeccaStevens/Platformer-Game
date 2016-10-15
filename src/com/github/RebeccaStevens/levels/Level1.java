package com.github.RebeccaStevens.levels;

import com.github.RebeccaStevens.entities.Player;

import gamelib.game.Level2D;
import gamelib.game.cameras.CameraFollow;
import gamelib.game.entities.platforms.BasicPlatform;
import processing.core.PGraphics;

public class Level1 extends Level2D {
	
	// colors
	private int backgroundColor = 0xFF64B5F6;
	
	private Player player;
	
	private CameraFollow camera;

	public Level1() {
		setGravity(-20F);
		setDrawGrid(true);
		setDrawBoundingBoxes(true);
		
		setZoom(0.67F);
		
		this.player = new Player(this, 2, 3.1F, 1, 2);
		
		this.camera = new CameraFollow(this, this.player);
		setCamera(this.camera);

		float x = 0;
		float y = 1;
		float w = 18;
		float h = 1;
		float gap = 0;
		
		new BasicPlatform(this, x, y, w, h);
		new BasicPlatform(this, x + 10, y + 1, 4F, 1F);
		
		gap = 3;
		x += w + gap;
		w = 8;
		new BasicPlatform(this, x, y, w, h);
		
		gap = 5F;
		x += w + gap;
		w = 6F;
		new BasicPlatform(this, x, y, w, h);
		
		
//		this.camera.setMaxY(this.getGameHeight() / 2);
//		this.player.setMinX(this.player.getWidth() / 2);
	}

	@Override
	public void preUpdate(float delta) {
	}

	@Override
	public void postUpdate(float delta) {
		if (player.getY() < -5) {
			player.setLocation(2, 3.1F);
			player.setVelocity(0, 0);
		}
	}

	@Override
	public void drawBackground(PGraphics g) {
		g.background(backgroundColor);
	}

	@Override
	public void drawOverlay(PGraphics g) {
		
	}
}
