package models.squares;

import CustomStuff.Pair;

import java.awt.*;

abstract public class Square {
	int xPos, yPos; //how many pixels off
	Color color;
	SquarePhysics physics = null;

	public Square(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void update(){
		if (physics != null) {
			Pair pair = physics.sandGravity(xPos, yPos);
			this.xPos = (int) pair.getVal1();
			this.yPos = (int) pair.getVal2();
		}
	};

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
