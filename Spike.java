/**
The Spike class is a subclass of GameObject and represents a spike object. 
It initializes the hitbox and draw offset of the spike.
**/

public class Spike extends GameObject{

	public Spike(int x, int y, int objType) {
		super(x, y, objType);
		initHitbox(32, 16);
		xDrawOffset = 0;
		yDrawOffset = (int)(Game.SCALE * 16);
		hitbox.y += yDrawOffset;
	}
}
