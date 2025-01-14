/**
The GameStarter class is a main method that creates a new GameFrame instance with the dimensions 
specified in the Game class, then calls its connectToServer and setUpGUI methods. This class is used 
to start the game by initializing the graphical user interface and connecting to the game server.
**/

import java.util.*;
public class GameStarter{
    
    public static void main(String[] args){
        GameFrame gf = new GameFrame(Game.GAME_WIDTH,Game.GAME_HEIGHT);
        Scanner in = new Scanner(System.in);
        System.out.print("IP Address: ");
        gf.connectToServer(in.nextLine());
        gf.setUpGUI();
        
    }
}
