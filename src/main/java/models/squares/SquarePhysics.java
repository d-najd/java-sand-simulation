package models.squares;

import CustomStuff.Pair;
import Main.MainApp;
import renderer.SquareRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class SquarePhysics {
	private final int gravity; //now many frames till we update the gravity
	private int curGravityFrame;

	public SquarePhysics(int gravity){
		this.gravity = gravity;
	}

	/**
	 * tells the square where it needs to be based on the effect from the gravity
	 * @param x the current x pos of the square
	 * @param y the current y pos of the Nsquare
	 * @return the new position of the square, if something fails returns the old position
	 */
	public Pair updateGravity1(int x, int y) {
		ArrayList<Square> positions = new ArrayList<>(SquareRenderer.getInstance().getSquares());

		int squareSize = MainApp.squareSize;
		//used if the square is falling faster than the size of the square ex square is 10 but gravity is 100 so without
		//this we could fall through the square entirely and that won't be good
		int tempY = y;
		if (squareSize < gravity){
			for(int i = 0; i < Math.ceil((gravity + 0f)/squareSize); i++){
				//basically gets the square that is overlapping with the current one
				int finalTempY = tempY;
				Optional<Square> overLappingSquare = positions.parallelStream().filter
					(o -> simpleCheckX(o, x) &&
					(advancedCheckY(o, finalTempY))).findAny();
				if (overLappingSquare.isPresent()){
					return new Pair(x, overLappingSquare.get().yPos + squareSize);
				}
				tempY -= squareSize;
			}
			return new Pair(x, y - gravity);
		} else {
			//we are not moving squares in the x-axis (for now at least) so we don't need to calculate that
			if (positions.parallelStream().noneMatch
					(o -> simpleCheckX(o, x) &&
					(advancedCheckY(o, y)))) {
				return new Pair(x, y - gravity);
			}
			//for making sure the square falls fully, ex we have gravity of 10 and squares are 15, we start at 30 then
			// we get to 20 and after that without this it would just stay there but with this we manage to get to 15
			// or in other words where the "floor" is
			else if (y % squareSize != 0) {
				//apparently the parallel stream doesn't have the most correct y positions for checking, and I can't be
				//bothered to test for the right one
				if (y % squareSize > gravity)
					return new Pair(x, y - gravity);
				return new Pair(x, y - (y % squareSize));
			}
		}
		//nothing changed so we are returning the old position
		return new Pair(x, y);
	}

	public Pair updateGravity(int x, int y){
		if (curGravityFrame == gravity){
			curGravityFrame = 0;
			int squareSize = MainApp.squareSize;

			ArrayList<Square> positions = new ArrayList<>(SquareRenderer.getInstance().getSquares());
			if (positions.parallelStream().noneMatch(o -> simpleCheckX(o, x) &&
				(simpleCheckY(o, y - squareSize)))){
				return new Pair(x, y - squareSize);
			}
		} else
			curGravityFrame++;
		return new Pair(x, y);
	}

	/**
	 * checks whether the square will overlap with other given square
	 * @param o the square that we check against
	 * @param the y value on the bottom left
	 */
	public static boolean advancedCheckX(Square o, int x){
		return o.xPos < x && (o.xPos + MainApp.squareSize) >= x;
	}

	/**
	 * checks whether the square will overlap with other given square
	 * @param square the square that we check againt
	 * @param value the y value on the bottom left
	 */
	public static boolean advancedCheckY(Square o, int y){
		return o.yPos < y && (o.yPos + MainApp.squareSize) >= y;
	}

	/**
	 * simple check to see whether the square x and the value are the same
	 * @return true if they are false if they aren't
	 */
	public static boolean simpleCheckX(Square square, int x){
		return square.xPos == x;
	}

	/**
	 * simple check to see whether the square Y and the value are the same
	 * @return true if they are false if they aren't
	 */
	public static boolean simpleCheckY(Square square, int y){
		return square.yPos == y;
	}
}
