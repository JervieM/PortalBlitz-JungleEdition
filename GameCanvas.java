/**
GameCanvas class extends JComponent and is responsible for painting the game graphics. 
It also creates instances of the Player, Playing, and Game classes and uses their methods to draw the game's background, 
levels, objects, enemies, and players. The GameCanvas also updates the game and player positions.
**/

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GameCanvas extends JComponent{
    private int width, height;
    public Player player1, player2;
    public Game game;

    public GameCanvas(int w, int h){
        width = w;
        height = h;
        game = new Game();
        player1 = game.getPlaying().getPlayer1();
        player2 = game.getPlaying().getPlayer2();
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        g.drawImage(game.getPlaying().backgroundImg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        
        game.getPlaying().drawClouds(g);

        game.getPlaying().levelManager.draw(g, game.getPlaying().  xLvlOffset);
        game.getPlaying().objectManager.draw(g, game.getPlaying().xLvlOffset);
        game.getPlaying().objectManager.drawBackgroundTrees(g2d, game.getPlaying().xLvlOffset);
        game.getPlaying().enemyManager.draw(g, game.getPlaying().xLvlOffset);

        player2.render(g2d, game.getPlaying().xLvlOffset);
        player1.render(g2d, game.getPlaying().xLvlOffset);

        game.getPlaying().objectManager.drawBackgroundTrees(g, game.getPlaying().xLvlOffset);

        game.render(g2d);
        game.getPlaying().update();
        
        
    }

    public Game getGame(){
        return game;
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }
}
