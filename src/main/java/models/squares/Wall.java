package models.squares;

import java.awt.*;

public class Wall extends Square{
	public Wall(int xPos, int yPos) {
		super(xPos, yPos);
		this.color = new Color(188, 74, 60);
	}
}
