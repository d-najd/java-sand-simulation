package Main;

import models.squares.Sand;
import models.squares.SquareFactory;
import models.squares.SquarePhysics;
import org.lwjgl.opengl.GL11;
import renderer.SquareRenderer;
import renderer.Window;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class MainApp {
	public static int squareSize = 10; //size of all the squares in the scene in pixels
	public static int squaresFitX = 35, squaresFitY = 35; //how many squares we want to be able to fit
	public static int width = squaresFitX * squareSize, height = squaresFitY * squareSize;

	public static void main(String[] args) {
		Window window = new Window();
		window.createWindow(width, height, "hello");

		setup();

		SquareRenderer squareRenderer = SquareRenderer.getInstance();
		SquareFactory squareFactory = new SquareFactory();
		squareFactory.makeMultiple("wall", 0, 0, squaresFitX, 1);
		squareFactory.makeSquare("wall", 5, 3);
		squareFactory.makeSquare("sand", 5, 10);

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

	private static void setup(){
		SquarePhysics.squareSize = squareSize;
	}
}
