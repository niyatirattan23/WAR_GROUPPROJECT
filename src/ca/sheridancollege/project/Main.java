/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author parneetkaur
 */
public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the War card game!");

        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        WarPlayer player1 = new WarPlayer(player1Name);

        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();
        WarPlayer player2 = new WarPlayer(player2Name);

        System.out.print("Enter the number of rounds to play (default is 20): ");
        int numRounds = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        WarGame warGame = new WarGame("War", numRounds); // Pass numRounds to WarGame constructor
        warGame.addPlayer(player1);
        warGame.addPlayer(player2);

        System.out.println("Starting the game...");
        warGame.play();

        scanner.close();
    }
}