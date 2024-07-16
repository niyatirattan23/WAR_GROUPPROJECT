/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author niyat
 */


public class WarGame extends Game {
     private GroupOfCards deck;

    public WarGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        initializeDeck();
    }

    private void initializeDeck() {
        // Initialize the deck with 52 WarCards
        for (String suit : new String[]{"Hearts", "Diamonds", "Clubs", "Spades"}) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.getCards().add(new WarCard(suit, rank));
            }
        }
        deck.shuffle();
    }

    @Override
    public void play() {
        // War game logic goes here
        // Deal cards to players
        // Play rounds until one player wins
    }

    @Override
    public void declareWinner() {
        // Determine the winner and display the result
    }
}
