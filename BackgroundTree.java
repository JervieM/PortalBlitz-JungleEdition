/**
BackgroundTree is a class that represents a tree object with properties such as x-coordinate, y-coordinate, type, and animation index. 
The constructor initializes these properties with input values and sets a random animation index value. 
The class also has update and getter/setter methods for these properties. 
The update method updates the animation index property after a certain interval.
**/

import java.util.Random;

public class BackgroundTree {

	private int x, y, type, aniIndex, aniTick;

	public BackgroundTree(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;

		// Sets the aniIndex to a random value, to get some variations for the trees so
		// they all don't move in synch.
		Random r = new Random();
		aniIndex = r.nextInt(4);

	}

	public void update() {
		aniTick++;
		if (aniTick >= 35) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= 4)
				aniIndex = 0;
		}
	}

	public int getAniIndex() {
		return aniIndex;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getType() {
		return type;
	}

}
