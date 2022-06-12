package renderer;

import Main.MainApp;
import com.sun.tools.javac.Main;
import models.Cube;
import models.Square;

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

	//pain
	private static int findAspectRatio(int in1, int in2){
		int curVal = 2;
		while(curVal <= in1 && curVal <= in2){
			if (in1 % curVal == 0 && in2 % curVal == 0){
				in1 /= curVal;
				in2 /= curVal;
				curVal = 2;
			}

			curVal++;
		}
		return in1;
	}

	public void render(){
		int appWid = MainApp.width;
		int appHei = MainApp.height;
		int squareSize = 200;

		int xAspect = findAspectRatio(appWid, appHei);
		int yAspect = findAspectRatio(appHei, appWid);


		int offset = 0;

		float offsetX = (float) offset/appWid;
		float offsetY = (float) offset/appHei;

		float squareWid = (float) squareSize/appWid;
		float squareHei = (float) squareSize/appHei;

		float aspectX = (float) (appWid/appHei);
		float aspectY = (float) (appHei/appWid);

		float test = (-1f + offsetX);
		float test1 = (-1f + offsetX + squareWid);

		float test2 = (-1f + offsetY);
		float test3 = (-1f + offsetY + squareHei);

		/*
		glBegin(GL_QUADS);
			glColor3f(1.0f, 0.0f, 0.0f);
			glVertex2f(100, 100);
			glVertex2f(200, 100);
			glVertex2f(200, 200);
			glVertex2f(100, 200);
		glEnd();

		 */

		/*
		glBegin(GL_TRIANGLES);
			glColor3f(1.0f, 0.0f, 0.0f);
			glVertex2f(test, test3);
			glVertex2f(test, test2);
			glVertex2f(test1, test3);
			glVertex2f(test1, test3);
			glVertex2f(test, test2);
			glVertex2f(test1, test2);
		glEnd();

		 */



		/*
		glBegin(GL_TRIANGLES);
		glColor3f(1.0f, 0.0f, 0.0f);
		glVertex2f( -1, -1 + (squareHei));
		glVertex2f(-1, -1);
		glVertex2f(-1 + squareWid, -1 + (squareHei));
		glVertex2f(-1 + (squareWid ), -1 + (squareHei));
		glVertex2f(-1, -1);
		glVertex2f(-1 + (squareWid), -1);
		glEnd();

		 */


		/*
			glVertex2f( offsetX, offsetY + squareHei);
			glVertex2f(offsetX, offsetY);
			glVertex2f(offsetX + squareWid, offsetY + squareHei);
			glVertex2f(offsetX + squareWid, offsetY + squareHei);
			glVertex2f(offsetX, offsetY);
			glVertex2f(offsetX + squareWid, offsetY);

		 */

		/*
		glBegin(GL_TRIANGLES);
			glColor3f(1.0f, 0.0f, 0.0f);
			glVertex2f(-0.5f, 0.5f);
			glVertex2f(-0.5f, -0.5f);
			glVertex2f(0.5f, 0.5f);
			glVertex2f(0.5f, 0.5f);
			glVertex2f(-0.5f, -0.5f);
			glVertex2f(0.5f, -0.5f);
		glEnd();

		 */

	}
}
