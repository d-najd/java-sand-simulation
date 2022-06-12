package models.squares;

import java.awt.*;

abstract public class Square {
	int xPos, yPos; //how many pixels off
	Color color;

	public Square(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}

	abstract public void update();

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
