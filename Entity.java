/**
Entity is an abstract class which is used for creating game entities that have certain properties and methods. 
It includes variables and methods for the entity's position, size, health, movement, animation, and hitboxes for 
both attacks and collisions. The class is intended to be extended by other classes to create specific types of game entities.
**/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public abstract class Entity {

	protected float x, y;
	protected int width, height;
	protected Rectangle2D.Float hitbox;
	protected int aniTick, aniIndex;
	protected int state;
	protected float airSpeed;
	protected boolean inAir = false;
	protected int maxHealth;
	protected int currentHealth;
	protected Rectangle2D.Float attackBox;
	protected float walkSpeed;

	protected int pushBackDir;
	protected float pushDrawOffset;
	protected int pushBackOffsetDir = Constants.Directions.UP;

	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	protected void updatePushBackDrawOffset() {
		float speed = 0.95f;
		float limit = -30f;

		if (pushBackOffsetDir == Constants.Directions.UP) {
			pushDrawOffset -= speed;
			if (pushDrawOffset <= limit)
				pushBackOffsetDir = Constants.Directions.DOWN;
		} else {
			pushDrawOffset += speed;
			if (pushDrawOffset >= 0)
				pushDrawOffset = 0;
		}
	}

	protected void pushBack(int pushBackDir, int[][] lvlData, float speedMulti) {
		float xSpeed = 0;
		if (pushBackDir == Constants.Directions.LEFT)
			xSpeed = -walkSpeed;
		else
			xSpeed = walkSpeed;

		if (HelpMethods.CanMoveHere(hitbox.x + xSpeed * speedMulti, hitbox.y, hitbox.width, hitbox.height, lvlData))
			hitbox.x += xSpeed * speedMulti;
	}

	protected void initHitbox(int width, int height) {
		hitbox = new Rectangle2D.Float(x, y, (int) (width * Game.SCALE), (int) (height * Game.SCALE));
	}

	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

	public int getState() {
		return state;
	}

	public int getAniIndex() {
		return aniIndex;
	}

	protected void newState(int state) {
		this.state = state;
		aniTick = 0;
		aniIndex = 0;
	}

	public float getX(){
		return hitbox.x;
	}

	public float getY(){
		return hitbox.y;
	}

}
