package ca.sheridancollege.project.test;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.Hand;
import ca.sheridancollege.project.TestCard; // Assume you have this for testing
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class HandTest {

    private Hand hand;

    @BeforeEach
    public void setUp() {
        // Create a Hand with a size of 10
        hand = new Hand(10);

        // Add some cards to the hand for testing
        hand.addCard(new TestCard("Card 1"));
        hand.addCard(new TestCard("Card 2"));
        hand.addCard(new TestCard("Card 3"));
    }

    @Test
    public void testAddCard() {
        // Act
        hand.addCard(new TestCard("Card 4"));

        // Assert
        assertEquals(4, hand.getCards().size(), "The number of cards should be 4.");
        assertTrue(hand.getCards().stream().anyMatch(card -> card.toString().equals("Card 4")),
                   "Card 4 should be in the hand.");
    }

    @Test
    public void testPlayCard() {
        // Act
        Card playedCard = hand.playCard();

        // Assert
        assertEquals("Card 1", playedCard.toString(), "The played card should be Card 1.");
        assertEquals(2, hand.getCards().size(), "The number of cards should be 2 after playing one.");
    }

    @Test
    public void testAddCards() {
        // Arrange
        ArrayList<Card> newCards = new ArrayList<>();
        newCards.add(new TestCard("Card 4"));
        newCards.add(new TestCard("Card 5"));

        // Act
        hand.addCards(newCards);

        // Assert
        assertEquals(5, hand.getCards().size(), "The number of cards should be 5.");
        assertTrue(hand.getCards().stream().anyMatch(card -> card.toString().equals("Card 4")),
                   "Card 4 should be in the hand.");
        assertTrue(hand.getCards().stream().anyMatch(card -> card.toString().equals("Card 5")),
                   "Card 5 should be in the hand.");
    }
}
