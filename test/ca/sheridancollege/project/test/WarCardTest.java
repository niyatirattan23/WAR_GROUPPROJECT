package ca.sheridancollege.project.test;

import ca.sheridancollege.project.WarCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarCardTest {

    @Test
    public void testCardCreation() {
        WarCard card = new WarCard("Hearts", 10);
        assertEquals("Hearts", card.getSuit(), "Card suit should be Hearts");
        assertEquals(10, card.getRank(), "Card rank should be 10");
    }

    @Test
    public void testCardToString() {
        WarCard card = new WarCard("Spades", 1);
        assertEquals("1 of Spades", card.toString(), "Card string representation should be '1 of Spades'");
    }
}
