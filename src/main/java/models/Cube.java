package models;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Cube {
	private float xOff, yOff, wid, hei;

	public Cube(float xOff, float yOff, float wid, float hei){
		this.xOff = xOff;
		this.yOff = yOff;
		this.wid = wid;
		this.hei = hei;
	}

	public float getxOff() {
		return xOff;
	}

	public void setxOff(float xOff) {
		this.xOff = xOff;
	}

	public float getyOff() {
		return yOff;
	}

	public void setyOff(float yOff) {
		this.yOff = yOff;
	}

	public float getWid() {
		return wid;
	}

	public void setWid(float wid) {
		this.wid = wid;
	}

	public float getHei() {
		return hei;
	}

	public void setHei(float hei) {
		this.hei = hei;
	}
}
