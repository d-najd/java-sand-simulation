package models.squares;

import Main.MainApp;

import java.awt.*;

public class Sand extends Square {
	public Sand(int xPos, int yPos) {
		super(xPos, yPos);
		this.color = new Color(255, 255, 0);
		this.physics = new SquarePhysics(MainApp.squareSize * 1f);
	}
}
