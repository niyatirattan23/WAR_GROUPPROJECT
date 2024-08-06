/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author sumit
 */

import java.util.ArrayList;

public class WarPlayer extends Player {
     private Hand hand;

public WarPlayer(String name) {
        super(name);
        hand = new Hand(0); // Hand size will be managed during the game
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public Card playCard() {
        return hand.playCard();
    }

    @Override
    public void play() {
        // Specific game logic for playing a turn
    }
}