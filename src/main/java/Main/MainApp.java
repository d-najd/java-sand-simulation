package Main;

import models.Cube;
import models.Square;
import models.Vao;
import renderer.SquareRenderer;
import renderer.SimpleRenderer;
import renderer.Window;

import static org.lwjgl.opengl.GL11.*;

public class MainApp {
	public static int width = 1920, height = 1080;
	public static int squareSize = 25; //in pixels

	public static void main(String[] args) {
		Window window = new Window();
		window.createWindow(width, height, "hello");

		SimpleRenderer renderer = new SimpleRenderer();
		SquareRenderer squareRenderer = SquareRenderer.getInstance();
		//cubeRenderer.addCube(new Cube(100, 200, 50, 50));
		//cubeRenderer.addCube(new Cube(300, 200, 50, 50));

		float[] vertices = {
			-.75f,  .75f,
			 .75f,  .75f,
			 .75f, -.75f,
			-.75f, -.75f,
			-.75f, .75f,
		};

		float[] vertices1 = {
			0, 0.75f,
			-0.75f, -0.5f,
			0.75f, -0.5f,
		};

		int[] indices = {
			0,1,2,3,4,5,6,7
		};


		/*
		Vao vao = new Vao();
		vao.bind();
		vao.createFloatAttribute(0, vertices, 2);
		vao.createIndexBuffer(indices);
		vao.unbind();

		 */


		squareRenderer.addSquare(new Square(10, 10));

		while(!window.shouldClose()){
			//GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			//GL11.glClearColor(0f, .3f, 0f, 1f);

			squareRenderer.render();

			float aspectRatio = width / height;

			//renderer.render(vao);

			window.updateWindow();
		}

		window.closeWindow();
	}
}
