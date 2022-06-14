package models.squares;

import java.awt.*;

public class Sand extends Square {
	public Sand(int xPos, int yPos) {
		super(xPos, yPos);
		this.color = new Color(255, 255, 0);
		this.physics = new SquarePhysics(.1f);
	}

	//TODO this should be removed using it now just for testing
	public void setG(float gravity){
		this.physics = new SquarePhysics(gravity);
	}
}
