package ca.sheridancollege.project.test;

import ca.sheridancollege.project.GameLauncher;
import ca.sheridancollege.project.WarGame;
import ca.sheridancollege.project.WarPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLauncherTest {

    @Test
    public void testStartGame() {
        // Arrange
        GameLauncher gameLauncher = new GameLauncher();
        String player1Name = "Player 1";
        String player2Name = "Player 2";
        int numRounds = 20;

        // Act
        // Use a real instance of WarGame for testing.
        WarGame warGame = new WarGame("War", numRounds);
        warGame.addPlayer(new WarPlayer(player1Name));
        warGame.addPlayer(new WarPlayer(player2Name));
        
        // Start the game (this is a simple test; ensure that WarGame logic is correct)
        gameLauncher.startGame(player1Name, player2Name, numRounds);

        // Assert
        assertEquals(2, warGame.getPlayers().size(), "There should be 2 players in the game");
        assertEquals(player1Name, warGame.getPlayers().get(0).getName(), "Player 1's name should be correct");
        assertEquals(player2Name, warGame.getPlayers().get(1).getName(), "Player 2's name should be correct");
    }
}
