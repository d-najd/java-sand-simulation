package models;

import models.squares.Sand;
import models.squares.Square;
import models.squares.Wall;
import renderer.SquareRenderer;

import java.awt.*;
import java.util.Locale;

public class SquareFactory {
	public Square makeSquare(String type, int xOff, int yOff) {
		type = type.toLowerCase(Locale.ROOT); //in case I mess up the type
		SquareRenderer squareRenderer = SquareRenderer.getInstance();
		Square square = null;

		switch (type){
			case "sand":
				square = new Sand(xOff, yOff);
				break;
			case "wall":
				square = new Wall(xOff, yOff);
			default:
				System.out.println("invalid square type: " + type);
		}

		squareRenderer.addSquare(square);
		return square;
	}
}
