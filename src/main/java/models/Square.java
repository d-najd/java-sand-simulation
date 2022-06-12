package models;

public class Square {
	int xOff, yOff; //how many pixels off

	public Square(int xOff, int yOff) {
		this.xOff = xOff;
		this.yOff = yOff;
	}

	public int getxOff() {
		return xOff;
	}

	public void setxOff(int xOff) {
		this.xOff = xOff;
	}

	public int getyOff() {
		return yOff;
	}

	public void setyOff(int yOff) {
		this.yOff = yOff;
	}
}
