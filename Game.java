/**
Game class implements the Runnable interface, which allows the class to be executed as a thread. 
The class contains methods for updating and rendering the game, as well as initializing classes for 
the game's menu, gameplay, and game options. It also includes a game loop that continually updates 
and renders the game, while tracking the frames per second (FPS) and updates per second (UPS).
**/

import java.awt.Graphics;

public class Game {

	private Playing playing1, playing2;
	Menu menu;
	GameOptions gameOptions;

	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;


	public Game() {
		System.out.println("size: " + GAME_WIDTH + " : " + GAME_HEIGHT);
		initClasses();
	}

	private void initClasses() {
		menu = new Menu(this);
		playing1 = new Playing(this,1);
		playing2 = new Playing(this,2);
		gameOptions = new GameOptions(this);
	}

	public void update() {
		switch (Gamestate.state) {
			case MENU:
				menu.update();
				break;
			case PLAYING:
				playing1.update();
				playing2.update();
				break;
			case OPTIONS:
				gameOptions.update();
				break;
			case QUIT:
				System.exit(0);
		}
	}

	@SuppressWarnings("incomplete-switch")
	public void render(Graphics g) {
		switch (Gamestate.state) {
			case MENU:
				menu.draw(g);
				break;
			case PLAYING:
				playing1.draw(g);
				playing2.draw(g);
				break;
			case OPTIONS:
				gameOptions.draw(g);
				break;
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public Playing getPlaying() {
		return playing1;
	}

	public GameOptions getGameOptions() {
		return gameOptions;
	}

	
}
