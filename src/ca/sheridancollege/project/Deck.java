/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author niyat
 */
public class Deck extends GroupOfCards {

    public Deck() {
        super(52); 
     initializeDeck();
    }

    private void initializeDeck() {
        for (String suit : new String[]{"Hearts", "Diamonds", "Clubs", "Spades"}) {
            for (int rank = 1; rank <= 13; rank++) {
                getCards().add(new WarCard(suit, rank));
            }
        }
        shuffle();
    }
}