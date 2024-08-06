/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author niyat
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
        // Create players and distribute cards
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");
        warPlayers.add(player1);
        warPlayers.add(player2);

        int playerIndex = 0;
        for (Card card : deck.getCards()) {
            warPlayers.get(playerIndex).addCardToHand(card);
            playerIndex = (playerIndex + 1) % warPlayers.size();
        }
    }

    private void playRound(Scanner scanner) {
    ArrayList<Card> cardsOnTable = new ArrayList<>();
    for (WarPlayer player : warPlayers) {
        System.out.print(player.getName() + ", press enter to play your card: ");
        scanner.nextLine(); // Wait for player input
        Card playedCard = player.playCard();
        cardsOnTable.add(playedCard);
        System.out.println(player.getName() + " plays " + playedCard.toString());
    }

    // Determine round winner
    WarCard winningCard = (WarCard) cardsOnTable.get(0);
    int winningIndex = 0;

    for (int i = 1; i < cardsOnTable.size(); i++) {
        WarCard currentCard = (WarCard) cardsOnTable.get(i);
        if (currentCard.getRank() > winningCard.getRank()) {
            winningCard = currentCard;
            winningIndex = i;
        }
    }

    warPlayers.get(winningIndex).getHand().addCards(cardsOnTable);
    System.out.println(warPlayers.get(winningIndex).getName() + " wins the round.");
}


    private void warScenario(Scanner scanner, ArrayList<Card> cardsOnTable) {
        // Each player adds three cards face down and one card face up
        ArrayList<Card> cardsToBattle = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                cardsToBattle.add(warPlayers.get(i).playCard());
            }
            cardsOnTable.addAll(cardsToBattle);
            cardsToBattle.clear();
            cardsToBattle.add(warPlayers.get(i).playCard());
            cardsOnTable.addAll(cardsToBattle);
        }

        // Determine winner of the war
        WarCard warCard1 = (WarCard) cardsToBattle.get(0);
        WarCard warCard2 = (WarCard) cardsToBattle.get(1);

        if (warCard1.getRank() > warCard2.getRank()) {
            warPlayers.get(0).getHand().addCards(cardsOnTable);
            System.out.println(warPlayers.get(0).getName() + " wins the war.");
        } else if (warCard1.getRank() < warCard2.getRank()) {
            warPlayers.get(1).getHand().addCards(cardsOnTable);
            System.out.println(warPlayers.get(1).getName() + " wins the war.");
        } else {
            // Recursive war if there's another tie
            System.out.println("Another tie! Initiating another war.");
            warScenario(scanner, cardsOnTable);
        }
    }

    private boolean isGameOver() {
        // Game ends after numRounds or when a player has all cards
        return warPlayers.stream().anyMatch(player -> player.getHand().getCards().isEmpty())
                || warPlayers.stream().anyMatch(player -> player.getHand().getCards().size() > 52);
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
