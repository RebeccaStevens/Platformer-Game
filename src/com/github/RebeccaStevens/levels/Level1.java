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
		setGravity(-5);
		setDrawGrid(true);
		
		this.player = new Player(this, 2, 3, 1, 2);
		
		this.camera = new CameraFollow(this, this.player);
		setCamera(this.camera);

		new BasicPlatform(this, 0F, 1F, 18F, 1F);
		new BasicPlatform(this, 10F, 2F, 4F, 1F);

//		this.camera.setMaxY(this.getGameHeight() / 2);
//		this.player.setMinX(this.player.getWidth() / 2);
	}

	@Override
	public void drawBackground(PGraphics g) {
		g.background(backgroundColor);
	}

	@Override
	public void drawOverlay(PGraphics g) {
		
	}
}
