/**
Projectile class creates a projectile in a game, with a hitbox, direction, and active state. 
It has methods to update the projectile's position and set its activity status.
**/

import java.awt.geom.Rectangle2D;

public class Projectile {
	private Rectangle2D.Float hitbox;
	private int dir;
	private boolean active = true;

	public Projectile(int x, int y, int dir) {
		int xOffset = (int) (-3 * Game.SCALE);
		int yOffset = (int) (5 * Game.SCALE);

		if (dir == 1)
			xOffset = (int) (29 * Game.SCALE);

		hitbox = new Rectangle2D.Float(x + xOffset, y + yOffset, Constants.Projectiles.CANNON_BALL_WIDTH, Constants.Projectiles.CANNON_BALL_HEIGHT);
		this.dir = dir;
	}

	public void updatePos() {
		hitbox.x += dir * Constants.Projectiles.SPEED;
	}

	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

}
