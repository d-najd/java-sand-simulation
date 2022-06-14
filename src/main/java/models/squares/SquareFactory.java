package models.squares;

import Main.MainApp;
import models.squares.Sand;
import models.squares.Square;
import models.squares.Wall;
import renderer.SquareRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

public class SquareFactory {
	/**
	 * makes a square at given position and type on the screen and adds it for rendering
	 * @param type the type of square
	 * @param xOff how many blocks on the x from the left
	 * @param yOff how many blocks on the y from the bottom
	 * @return the square
	 */
	public Square makeSquare(String type, int xOff, int yOff) {
		if (xOff > MainApp.squaresFitX || yOff > MainApp.squaresFitY){
			System.out.println("a square is out of bounds, this may be intentional");
		}

		type = type.toLowerCase(Locale.ROOT); //in case I mess up the type
		SquareRenderer squareRenderer = SquareRenderer.getInstance();
		Square square = null;
		xOff *= MainApp.squareSize;
		yOff *= MainApp.squareSize;
		switch (type){
			case "sand":
				square = new Sand(xOff, yOff);
				break;
			case "wall":
				square = new Wall(xOff, yOff);
				break;
			default:
				System.out.println("invalid square type: " + type);
		}

		squareRenderer.addSquare(square);
		return square;
	}

	/**
	 *
	 * @apiNote makes stuff between 2 given points for ex if we say off1 to be (1,1) and off2 (3,2) it will make rectangle like so
	 * <pre>
	 *     0 1 1 1
	 *     0 1 1 1
	 *     0 0 0 0
	 * </pre>
	 * 1 are filled spots 0 are not
	 * @return returns arraylist of the squares if nothing went wrong and null if something did
	 * @see {@link #makeSquare(String, int, int)}
	 */
	public ArrayList<Square> makeMultiple(String type, int xOff1, int yOff1, int xOff2, int yOff2){
		if (xOff2 < xOff1 || yOff2 < yOff1) {
			System.out.println("$Off1 should be smaller than $Off2");
			return null;
		}
		ArrayList<Square> returnList = new ArrayList<>();

		for(int x = xOff1; x < xOff2; x++){
			for(int y = yOff1; y < yOff2; y++){
				Square curSquare = makeSquare(type, x, y);
				if (curSquare == null){
					System.out.println("unable to make squares between (" + xOff1 + ", " + yOff1 + ") " +
						"and (" + xOff2 + "," + yOff2 + ")");
					return null;
				}
				returnList.add(curSquare);
			}
		}
		return returnList;
	}
}
