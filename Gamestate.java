/**
Gamestate is an enumeration class with 5 predefined values representing the possible states of a game. 
The "state" variable is static and can be accessed and changed from any part of the code.
**/

public enum Gamestate {

	PLAYING, MENU, OPTIONS, QUIT, CREDITS;

	public static Gamestate state = MENU;

}
