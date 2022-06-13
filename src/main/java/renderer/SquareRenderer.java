package renderer;

import Main.MainApp;
import models.squares.Square;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class SquareRenderer implements RendererInterface{

	private static SquareRenderer firstInstance = null;
	private static ArrayList<Square> squares = null;

	//we only want 1 cubeRenderer so I am using singleton
	private SquareRenderer() {}

	public static SquareRenderer getInstance(){
		if (firstInstance == null){
			firstInstance = new SquareRenderer();
			squares = new ArrayList<>();
		}
		return firstInstance;
	}

	public void addSquare(Square square){
		squares.add(square);
	}

	public void update(){
		for (Square square : squares){
			square.update();
		}
	}

	public ArrayList<Square> getSquares(){
		return squares;
	}

	public void render(){
		double converter = 0.00392156862745098; //used for turning 255 color into a value to 0-1f
		for(Square square : squares)
		{
			float r = (float) (square.getColor().getRed() * converter);
			float g = (float) (square.getColor().getGreen() * converter);
			float b = (float) (square.getColor().getBlue() * converter);
			glBegin(GL_QUADS);
			{
				glColor3f(r, g, b);
				glVertex2f(square.getxPos(), square.getyPos());
				glVertex2f(square.getxPos() + MainApp.squareSize, square.getyPos());
				glVertex2f(square.getxPos() + MainApp.squareSize, square.getyPos() + MainApp.squareSize);
				glVertex2f(square.getxPos(), square.getyPos() + MainApp.squareSize);
			}
			glEnd();
		}
	}
}
