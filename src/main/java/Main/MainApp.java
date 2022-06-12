package Main;

import models.SquareFactory;
import org.lwjgl.opengl.GL11;
import renderer.SquareRenderer;
import renderer.Window;

public class MainApp {
	public static int width = 512, height = 512;
	public static int squareSize = 15; //size of all the squares in the scene in pixels

	public static void main(String[] args) {
		Window window = new Window();
		window.createWindow(width, height, "hello");

		SquareRenderer squareRenderer = SquareRenderer.getInstance();
		SquareFactory squareFactory = new SquareFactory();
		squareFactory.makeSquare("sand", 1 * squareSize, 1 * squareSize);
		squareFactory.makeSquare("wall", 3 * squareSize, 1 * squareSize);

		while(!window.shouldClose()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			GL11.glClearColor(0f, 0f, 0f, 1f);

			squareRenderer.update();
			squareRenderer.render();

			//renderer.render(vao);

			window.updateWindow();
		}

		window.closeWindow();
	}
}
