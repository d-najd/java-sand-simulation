package models.squares;

import CustomStuff.Pair;
import Main.MainApp;
import renderer.SquareRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class SquarePhysics {
	private final float gravity; //now many frames till we update the gravity
	private float curGravityFrame;
	public static int squareSize;
	public SquarePhysics(float gravity){
		this.gravity = gravity;
	}

	public Pair sandGravity(int x, int y){
		Pair temp = updateGravity(x, y);
		//checking if we can move sand down
		if ((int) temp.getVal2() != y){ //x doesn't move
			return temp;
		}
		//checking if we can move sand left
		Pair temp1 = updateGravity(x - squareSize, y);
		if ((int) temp1.getVal1() != x - squareSize){ //x and y both move, so I can just check 1 of them
			return temp1;
		}
		temp1 = updateGravity(x + squareSize, y);
		if ((int) temp1.getVal1() != x + squareSize){
			return temp1;
		}
		return temp;
	}

	public Pair updateGravity(int x, int y){
		if (curGravityFrame == squareSize){
			ArrayList<Square> positions = new ArrayList<>(SquareRenderer.getInstance().getSquares());
			curGravityFrame = 0;

			if(positions.parallelStream().noneMatch(o -> simpleCheckX(o, x) && (simpleCheckY(o, y - squareSize)))){
				return new Pair(x, y - squareSize);
			}
		} else if (squareSize < curGravityFrame) {
			ArrayList<Square> positions = new ArrayList<>(SquareRenderer.getInstance().getSquares());
			int traveled = 0;

			for(int i = 0; i < Math.floor(curGravityFrame/squareSize); i++){
				int finalTraveled = traveled;
				if(positions.parallelStream().anyMatch(o -> simpleCheckX(o, x)
					&& simpleCheckY(o, y-(finalTraveled * squareSize) - squareSize))){
					curGravityFrame -= traveled * squareSize;
					return new Pair(x, y - (traveled * squareSize));
				}
				traveled++;
			}
			curGravityFrame -= traveled * squareSize;
			return new Pair(x, y - (traveled * squareSize));
		} else
			curGravityFrame += gravity;
		return new Pair(x, y);
	}

	/**
	 * checks whether the square will overlap with other given square
	 * @param o the square that we check against
	 * @param x y value on the bottom left
	 */
	public static boolean advancedCheckX(Square o, int x){
		return o.xPos < x && (o.xPos + squareSize) >= x;
	}

	/**
	 * checks whether the square will overlap with other given square
	 * @param o the square that we check againt
	 * @param y the y value on the bottom left
	 */
	public static boolean advancedCheckY(Square o, int y){
		return o.yPos < y && (o.yPos + squareSize) >= y;
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
