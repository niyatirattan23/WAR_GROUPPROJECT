package ca.sheridancollege.project.test;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.Deck;
import ca.sheridancollege.project.WarCard;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDeckInitialization() {
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();
        assertEquals(52, cards.size(), "Deck should contain 52 cards");
        
        // Check for duplicates and missing cards
        assertTrue(cards.stream().allMatch(card -> card instanceof WarCard), "All cards should be instances of WarCard");
        assertEquals(4, cards.stream().map(card -> ((WarCard) card).getSuit()).distinct().count(), "There should be 4 distinct suits");
        assertEquals(13, cards.stream().map(card -> ((WarCard) card).getRank()).distinct().count(), "There should be 13 distinct ranks per suit");
    }
}
