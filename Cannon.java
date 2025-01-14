/**
Cannon class extends the "GameObject" class and represents a cannon object in a game. 
The constructor initializes the cannon object with an x-coordinate, a y-coordinate, and an object type. 
The class has a tileY property, an initHitbox method for setting the hitbox properties of the object, an 
update method, and a getter method for the tileY property. The update method checks if the object needs 
animation and updates the animation tick.
**/

public class Cannon extends GameObject {

	private int tileY;

	public Cannon(int x, int y, int objType) {
		super(x, y, objType);
		tileY = y / Game.TILES_SIZE;
		initHitbox(40, 26);
		hitbox.y += (int) (6 * Game.SCALE);
	}

	public void update() {
		if (doAnimation)
			updateAnimationTick();
	}

	public int getTileY() {
		return tileY;
	}

}
