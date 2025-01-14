/**
State is an abstract class representing a state in a game, with a method to check if a mouse 
event occurred within the bounds of a given menu button and a getter method for the game object.
**/

import java.awt.event.MouseEvent;

public class State {

	protected Game game;

	public State(Game game) {
		this.game = game;
	}

	public boolean isIn(MouseEvent e, MenuButton mb) {
		return mb.getBounds().contains(e.getX(), e.getY());
	}

	public Game getGame() {
		return game;
	}

}
