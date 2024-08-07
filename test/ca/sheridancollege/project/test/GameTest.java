package ca.sheridancollege.project.test;

import ca.sheridancollege.project.Player;
import ca.sheridancollege.project.TestGame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    private TestGame testGame;

    @BeforeEach
    public void setUp() {
        testGame = new TestGame("Test Game");
    }

    @Test
    public void testGetName() {
        // Act
        String name = testGame.getName();

        // Assert
        assertEquals("Test Game", name, "The game name should be 'Test Game'.");
    }

    @Test
    public void testSetPlayers() {
        // Arrange
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player 1") {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        players.add(new Player("Player 2") {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        // Act
        testGame.setPlayers(players);
        ArrayList<Player> returnedPlayers = testGame.getPlayers();

        // Assert
        assertEquals(players.size(), returnedPlayers.size(), "The number of players should match.");
        assertTrue(returnedPlayers.stream().anyMatch(p -> p.getName().equals("Player 1")),
                   "Player 1 should be in the list.");
        assertTrue(returnedPlayers.stream().anyMatch(p -> p.getName().equals("Player 2")),
                   "Player 2 should be in the list.");
    }

    // Additional tests can be added here to test play() and declareWinner() if needed
}
