package models.squares;

import java.awt.*;

public class Sand extends Square {

	public Sand(int xPos, int yPos) {
		super(xPos, yPos);
		this.color = new Color(255, 255, 0);
	}

	@Override
	public void update() {
		System.out.print("implement sand physics");
	}
}
