package Main;

import models.Cube;
import renderer.CubeRenderer;
import renderer.Window;

import static org.lwjgl.opengl.GL11.*;

public class MainApp {
	public static int width = 512, height = 1000;

	public static void main(String[] args) {
		Window window = new Window();
		window.createWindow(width, height, "hello");

		//SimpleRenderer renderer = new SimpleRenderer();
		CubeRenderer cubeRenderer = CubeRenderer.getInstance();
		Cube cube = new Cube(CalculatePixels.calOff(80, true), .05f, .3f, .3f);
		Cube cube1 = new Cube(-.2f, -.2f, .3f, .3f);
		cubeRenderer.addCube(cube);
		cubeRenderer.addCube(cube1);

		/*
		float[] vertices = {
			-.75f,  .75f,
			 .75f,  .75f,
			 .75f, -.75f,
			-.75f, -.75f,
		};

		float[] vertices1 = {
			0, 0.75f,
			-0.75f, -0.5f,
			0.75f, -0.5f,
		};

		int[] indices = {
			0,1,2
		};


		Vao vao = new Vao();
		vao.bind();
		vao.createFloatAttribute(0, vertices1, 2);
		vao.createIndexBuffer(indices);
		vao.unbind();
		 */

		while(!window.shouldClose()){
			//GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			//GL11.glClearColor(0f, .3f, 0f, 1f);



			glEnable(GL_SCISSOR_TEST);
			glScissor(100, 200, 10, 10);
			glClearColor(1,1,1,1);
			glClear(GL_COLOR_BUFFER_BIT);
			glDisable(GL_SCISSOR_TEST);
			//cubeRenderer.render();

			//renderer.renderVao(vao);

			window.updateWindow();
		}

		window.closeWindow();
	}
}
