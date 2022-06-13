package models.squares;

import CustomStuff.Pair;
import Main.MainApp;
import renderer.SquareRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class SquarePhysics {
	private final int gravity;

	public SquarePhysics(int gravity){
		this.gravity = gravity;
	}

	/**
	 * tells the square where it needs to be based on the effect from the gravity
	 * @param x the current x pos of the square
	 * @param y the current y pos of the Nsquare
	 * @return the new position of the square, if something fails returns the old position
	 */
	public Pair updateGravity(int x, int y) {
		ArrayList<Square> positions = new ArrayList<>(SquareRenderer.getInstance().getSquares());

		int squareSize = MainApp.squareSize;
		int xSP = x/squareSize, ySP = (int) Math.floor((y + 0f)/squareSize); // finding the tile which the square occupies
		//used if the square is falling faster than the size of the square ex square is 10 but gravity is 100 so without
		//this we could fall through the square entirely and that won't be good
		if (squareSize < gravity){
			for(int i = 0; i < Math.ceil((gravity + 0f)/squareSize); i++){
				int finalYSP = ySP;
				if (positions.parallelStream().anyMatch(o ->
						(o.xPos / squareSize == xSP) &&
						(o.yPos / squareSize < finalYSP && (o.yPos + squareSize) / squareSize >= finalYSP))) {
					return new Pair(x, ySP * squareSize);
				}
				ySP--;
			}
			return new Pair(x, y - gravity);
		} else {
			int finalYSP1 = ySP;
			//we are not moving squares in the x-axis (for now at least) so we don't need to calculate that
			if (positions.parallelStream().noneMatch(o ->
					(o.xPos / squareSize == xSP) &&
					(o.yPos / squareSize < finalYSP1 && (o.yPos + squareSize) / squareSize >= finalYSP1))) {
				return new Pair(x, y - gravity);
			}
			//for making sure the square falls fully, ex we have gravity of 10 and squares are 15, we start at 30 then
			// we get to 20 and after that without this it would just stay there but with this we manage to get to 15
			// or in other words where the "floor" is
			else if (y % squareSize != 0) {
				return new Pair(x, y - (y % squareSize));
			}
		}
		//nothing changed so we are returning the old position
		return new Pair(x, y);
	}
}
