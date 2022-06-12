package renderer;

import models.Cube;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class CubeRenderer implements RendererInterface{

	private static CubeRenderer firstInstance = null;
	private static ArrayList<Cube> cubes = null;

	//we only want 1 cubeRenderer so I am using singleton
	private CubeRenderer() {}

	public static CubeRenderer getInstance(){
		if (firstInstance == null){
			firstInstance = new CubeRenderer();
			cubes = new ArrayList<>();
		}
		return firstInstance;
	}

	public void addCube(Cube cube){
		cubes.add(cube);
	}

	public void render(){
		for (Cube cube: cubes) {
			glPushMatrix();
			{
				glTranslatef(cube.getxOff(), cube.getyOff(), 0); // Shifts the position
				glRotatef(0, 0, 0, 1);

				glBegin(GL_QUADS);
				{
					glVertex2f(0, 0);
					glVertex2f(0, cube.getHei());
					glVertex2f(cube.getWid(), cube.getHei());
					glVertex2f(cube.getWid(), 0);
				}
				glEnd();
			}
			glPopMatrix();
		}
	}
}
