/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;


/**
 *
 * @author ravjot
 */
public class Hand extends GroupOfCards {

    public Hand(int size) {
        super(size); 
    }
 public void addCard(Card card) {
        getCards().add(card);
    }

    public Card playCard() {
        return getCards().remove(0);
    }

    public void addCards(ArrayList<Card> cards) {
        getCards().addAll(cards);
    }
}