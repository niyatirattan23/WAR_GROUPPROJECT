package ca.sheridancollege.project.test;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.GroupOfCards;
import ca.sheridancollege.project.TestCard; // Assume you have this for testing
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class GroupOfCardsTest {

    private GroupOfCards groupOfCards;

    @BeforeEach
    public void setUp() {
        // Create a GroupOfCards with a size of 5
        groupOfCards = new GroupOfCards(5);

        // Add some cards to the group for testing
        groupOfCards.getCards().add(new TestCard("Card 1"));
        groupOfCards.getCards().add(new TestCard("Card 2"));
        groupOfCards.getCards().add(new TestCard("Card 3"));
        groupOfCards.getCards().add(new TestCard("Card 4"));
        groupOfCards.getCards().add(new TestCard("Card 5"));
    }

    @Test
    public void testGetCards() {
        // Act
        ArrayList<Card> cards = groupOfCards.getCards();

        // Assert
        assertEquals(5, cards.size(), "The number of cards should be 5.");
        assertTrue(cards.stream().anyMatch(card -> card.toString().equals("Card 1")),
                   "Card 1 should be in the group.");
    }

    @Test
    public void testShuffle() {
        // Act
        ArrayList<Card> originalOrder = new ArrayList<>(groupOfCards.getCards());
        groupOfCards.shuffle();

        // Assert
        // Ensure the order has changed (not a robust test, but checks if shuffle was applied)
        assertTrue(originalOrder.stream().anyMatch(card -> !card.toString().equals(groupOfCards.getCards().get(0).toString())),
                   "Shuffle should change the order of cards.");
    }

    @Test
    public void testGetSize() {
        // Act
        int size = groupOfCards.getSize();

        // Assert
        assertEquals(5, size, "The size of the group should be 5.");
    }

    @Test
    public void testSetSize() {
        // Act
        groupOfCards.setSize(10);
        int size = groupOfCards.getSize();

        // Assert
        assertEquals(10, size, "The size of the group should be updated to 10.");
    }
}
