/**
Grass class represents a patch of grass in a game. It has attributes for its x and y coordinates and the type of grass it is, 
as well as getter methods for these attributes.
**/

public class Grass {

	private int x, y, type;

	public Grass(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;

	}

	public int getType() {
		return type;
	}
}
