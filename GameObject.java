/**
GameObject class defines properties and methods for game objects, including their position, type, 
hitbox, animation, and other attributes. It includes methods for updating animations, resetting the 
object, initializing hitboxes, and drawing hitboxes. The class is designed to be used in a game development context.
**/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class GameObject {

	protected int x, y, objType;
	protected Rectangle2D.Float hitbox;
	protected boolean doAnimation, active = true;
	protected int aniTick, aniIndex;
	protected int xDrawOffset, yDrawOffset;

	public GameObject(int x, int y, int objType) {
		this.x = x;
		this.y = y;
		this.objType = objType;
	}

	protected void updateAnimationTick() {
		aniTick++;
		if (aniTick >= Constants.ANI_SPEED) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= Constants.ObjectConstants.GetSpriteAmount(objType)) {
				aniIndex = 0;
				if (objType == Constants.ObjectConstants.BARREL || objType == Constants.ObjectConstants.BOX) {
					doAnimation = false;
					active = false;
				} else if (objType == Constants.ObjectConstants.CANNON_LEFT || objType == Constants.ObjectConstants.CANNON_RIGHT)
					doAnimation = false;
			}
		}
	}

	public void reset() {
		aniIndex = 0;
		aniTick = 0;
		active = true;

		if (objType == Constants.ObjectConstants.BARREL || objType == Constants.ObjectConstants.BOX || objType == Constants.ObjectConstants.CANNON_LEFT || objType == Constants.ObjectConstants.CANNON_RIGHT)
			doAnimation = false;
		else
			doAnimation = true;
	}

	protected void initHitbox(int width, int height) {
		hitbox = new Rectangle2D.Float(x, y, (int) (width * Game.SCALE), (int) (height * Game.SCALE));
	}

	public int getObjType() {
		return objType;
	}

	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAnimation(boolean doAnimation) {
		this.doAnimation = doAnimation;
	}

	public int getxDrawOffset() {
		return xDrawOffset;
	}

	public int getyDrawOffset() {
		return yDrawOffset;
	}

	public int getAniIndex() {
		return aniIndex;
	}

	public int getAniTick() {
		return aniTick;
	}

}
