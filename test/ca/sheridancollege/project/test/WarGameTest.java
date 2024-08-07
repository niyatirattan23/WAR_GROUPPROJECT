package ca.sheridancollege.project.test;

import ca.sheridancollege.project.WarCard;
import ca.sheridancollege.project.WarGame;
import ca.sheridancollege.project.WarPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarGameTest {

    private WarGame warGame;
    private WarPlayer player1;
    private WarPlayer player2;

    @BeforeEach
    public void setUp() {
        warGame = new WarGame("Test War Game", 1);
        player1 = new WarPlayer("Player1");
        player2 = new WarPlayer("Player2");
        warGame.addPlayer(player1);
        warGame.addPlayer(player2);
    }

    @Test
    public void testGameInitialization() {
        assertNotNull(warGame, "WarGame should be initialized");
        assertEquals(2, warGame.getPlayers().size(), "There should be 2 players in the game");
    }

    @Test
    public void testPlayRound() {
        // Add initial cards to players' hands
        WarCard card1 = new WarCard("Hearts", 10);
        WarCard card2 = new WarCard("Spades", 9);
        player1.addCardToHand(card1);
        player2.addCardToHand(card2);

        warGame.playRound(null); // Pass a mock or real Scanner if needed

        assertTrue(player1.getHand().getCards().isEmpty(), "Player1's hand should be empty after playing a card");
        assertTrue(player2.getHand().getCards().isEmpty(), "Player2's hand should be empty after playing a card");
    }
}
