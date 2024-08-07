package ca.sheridancollege.project.test;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.TestCard;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    public void testToString() {
        // Arrange
        Card card = new TestCard("Ace of Spades");

        // Act
        String result = card.toString();

        // Assert
        assertEquals("Ace of Spades", result, "The toString method should return the correct card description.");
    }
}
