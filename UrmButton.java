/**
UrmButton is a class for creating a button with a custom image. It has methods for updating and drawing 
the button based on mouse behavior, and it also includes a rectangle for collision detection. Additionally, 
it has a method for setting the game state when the button is clicked.
**/

import java.awt.*;
import java.awt.image.BufferedImage;

public class UrmButton{
	private BufferedImage[] imgs;
	protected int x, y, width, height;
	private int rowIndex, index;
	private boolean mouseOver, mousePressed;
	protected Rectangle bounds;
	private Gamestate state;

	public UrmButton(int x, int y, int width, int height, int rowIndex) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rowIndex = rowIndex;
		state = Gamestate.QUIT;
		loadImgs();
		createBounds();
	}

	private void loadImgs() {
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.URM_BUTTONS);
		imgs = new BufferedImage[3];
		for (int i = 0; i < imgs.length; i++)
			imgs[i] = temp.getSubimage(i * Constants.UI.URMButtons.URM_DEFAULT_SIZE, rowIndex * Constants.UI.URMButtons.URM_DEFAULT_SIZE, Constants.UI.URMButtons.URM_DEFAULT_SIZE, Constants.UI.URMButtons.URM_DEFAULT_SIZE);

	}

	public void update() {
		index = 0;
		if (mouseOver)
			index = 1;
		if (mousePressed)
			index = 2;

	}

	public void draw(Graphics g) {
		g.drawImage(imgs[index], x, y, Constants.UI.URMButtons.URM_SIZE, Constants.UI.URMButtons.URM_SIZE, null);
	}

	public void resetBools() {
		mouseOver = false;
		mousePressed = false;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	private void createBounds(){
		bounds = new Rectangle(x, y, width, height);
	}

	public Rectangle getBounds(){
		return bounds;
	}

	public void applyGamestate() {
		Gamestate.state = state;
	}
}
