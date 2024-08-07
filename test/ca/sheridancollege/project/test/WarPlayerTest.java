package ca.sheridancollege.project.test;

import ca.sheridancollege.project.WarCard;
import ca.sheridancollege.project.WarPlayer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarPlayerTest {

    @Test
    public void testPlayerHandManagement() {
        WarPlayer player = new WarPlayer("Player1");
        WarCard card = new WarCard("Diamonds", 5);
        player.addCardToHand(card);

        assertEquals(1, player.getHand().getCards().size(), "Player should have 1 card in hand");
        assertEquals(card, player.playCard(), "Player should play the card added");
        assertTrue(player.getHand().getCards().isEmpty(), "Player's hand should be empty after playing the card");
    }
}
