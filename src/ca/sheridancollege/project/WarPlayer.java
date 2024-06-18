/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author niyat
 */

import java.util.ArrayList;

public class WarPlayer extends Player {
    private ArrayList<WarCard> hand;

    public WarPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public void addCardToHand(WarCard card) {
        hand.add(card);
    }

    public WarCard playCard() {
        return hand.remove(0);
    }

    @Override
    public void play() {
        // War game logic goes here
    }
}
