package ca.sheridancollege.project;

public class GameLauncher {

    public void startGame(String player1Name, String player2Name, int numRounds) {
        // Initialize the game
        WarGame warGame = new WarGame("War Card Game", numRounds);

        // Add players to the game
        WarPlayer player1 = new WarPlayer(player1Name);
        WarPlayer player2 = new WarPlayer(player2Name);

        warGame.addPlayer(player1);
        warGame.addPlayer(player2);

        // Start the game
        warGame.play();
    }
}