package com.github.RebeccaStevens;

import keymanager.InputType;
import processing.core.PConstants;

public final class Settings {
	
	// Player Controls
	public final UesrInput inputPlayerMoveLeft1 = new UesrInput(InputType.KeyBoardKey, PConstants.LEFT);
	public final UesrInput inputPlayerMoveLeft2 = new UesrInput(InputType.KeyBoardKey, 'A');
	public final UesrInput inputPlayerMoveRight1 = new UesrInput(InputType.KeyBoardKey, PConstants.RIGHT);
	public final UesrInput inputPlayerMoveRight2 = new UesrInput(InputType.KeyBoardKey, 'D');
	public final UesrInput inputPlayerMoveRun1 = new UesrInput(InputType.KeyBoardKey, PConstants.SHIFT);
	public final UesrInput inputPlayerMoveRun2 = new UesrInput(InputType.KeyBoardKey, 0);
	public final UesrInput inputPlayerMoveJump1 = new UesrInput(InputType.KeyBoardKey, PConstants.UP);
	public final UesrInput inputPlayerMoveJump2 = new UesrInput(InputType.KeyBoardKey, ' ');
	
	public final UesrInput inputPlayerFightPrimary1 = new UesrInput(InputType.KeyBoardKey, PConstants.CONTROL);
	public final UesrInput inputPlayerFightPrimary2 = new UesrInput(InputType.MouseButton, PConstants.LEFT);
}
