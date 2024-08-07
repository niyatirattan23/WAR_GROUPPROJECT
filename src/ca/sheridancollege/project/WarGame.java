/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rabia
 */


public class WarGame extends Game {
    private Deck deck;
    private ArrayList<WarPlayer> warPlayers;
    private int numRounds;

    public WarGame(String name, int numRounds) {
        super(name);
        this.numRounds = numRounds;
        deck = new Deck();
        warPlayers = new ArrayList<>();
    }

    @Override
    public void play() {
        initializeGame();
        int round = 1;
        Scanner scanner = new Scanner(System.in);

        while (round <= numRounds && !isGameOver()) {
            System.out.println("Round " + round);
            playRound(scanner);
            round++;
        }

        scanner.close();
        declareWinner();
    }

    private void initializeGame() {
        deck.shuffle();
        int playerIndex = 0;
        for (Card card : deck.getCards()) {
            warPlayers.get(playerIndex).addCardToHand(card);
            playerIndex = (playerIndex + 1) % warPlayers.size();
        }
    }

    public void playRound(Scanner scanner) {
        ArrayList<Card> cardsOnTable = new ArrayList<>();
        for (WarPlayer player : warPlayers) {
            System.out.print(player.getName() + ", press enter to play your card: ");
            scanner.nextLine();
            Card playedCard = player.playCard();
            cardsOnTable.add(playedCard);
            System.out.println(player.getName() + " plays " + playedCard.toString());
        }

        determineRoundWinner(scanner, cardsOnTable);
    }

    private void determineRoundWinner(Scanner scanner, ArrayList<Card> cardsOnTable) {
        WarCard winningCard = (WarCard) cardsOnTable.get(0);
        int winningIndex = 0;
        boolean isTie = false;

        for (int i = 1; i < cardsOnTable.size(); i++) {
            WarCard currentCard = (WarCard) cardsOnTable.get(i);
            if (currentCard.getRank() > winningCard.getRank()) {
                winningCard = currentCard;
                winningIndex = i;
                isTie = false;
            } else if (currentCard.getRank() == winningCard.getRank()) {
                isTie = true;
            }
        }

        
        if (isTie) {
            System.out.println("It's a tie! Playing an extra round.");
            playExtraRound(scanner, cardsOnTable);
        } else {
            warPlayers.get(winningIndex).getHand().addCards(cardsOnTable);
            System.out.println(warPlayers.get(winningIndex).getName() + " wins the round.");
        }
    }

    private void playExtraRound(Scanner scanner, ArrayList<Card> previousCardsOnTable) {
        ArrayList<Card> cardsOnTable = new ArrayList<>(previousCardsOnTable);
        System.out.println("Starting extra round...");

        for (WarPlayer player : warPlayers) {
            System.out.print(player.getName() + ", press enter to play your extra round card: ");
            scanner.nextLine();
            Card playedCard = player.playCard();
            cardsOnTable.add(playedCard);
            System.out.println(player.getName() + " plays " + playedCard.toString());
        }

        determineExtraRoundWinner(cardsOnTable);
    }

    private void determineExtraRoundWinner(ArrayList<Card> cardsOnTable) {
        WarCard winningCard = (WarCard) cardsOnTable.get(0);
        int winningIndex = 0;
        boolean isTie = false;

        for (int i = 1; i < cardsOnTable.size(); i++) {
            WarCard currentCard = (WarCard) cardsOnTable.get(i);
            if (currentCard.getRank() > winningCard.getRank()) {
                winningCard = currentCard;
                winningIndex = i;
                isTie = false;
            } else if (currentCard.getRank() == winningCard.getRank()) {
                isTie = true;
            }
        }

        if (isTie) {
            System.out.println("It's a tie again! Playing another extra round.");
            playExtraRound(new Scanner(System.in), cardsOnTable);
        } else {
            warPlayers.get(winningIndex % warPlayers.size()).getHand().addCards(cardsOnTable);
            System.out.println(warPlayers.get(winningIndex % warPlayers.size()).getName() + " wins the extra round.");
        }
    }

    private boolean isGameOver() {
        // Game ends after numRounds or when a player has all cards
        return warPlayers.size() <= 1
                || warPlayers.stream().anyMatch(player -> player.getHand().getCards().size() == 0);
    }

    @Override
    public void declareWinner() {
        // Determine and print the winner based on cards collected
        int maxCards = 0;
        String winner = "";

        for (WarPlayer player : warPlayers) {
            int numCards = player.getHand().getCards().size();
            if (numCards > maxCards) {
                maxCards = numCards;
                winner = player.getName();
            }
        }

        System.out.println("Game over! The winner is: " + winner);
    }
    
    public void addPlayer(WarPlayer player) {
        warPlayers.add(player);
    }
}