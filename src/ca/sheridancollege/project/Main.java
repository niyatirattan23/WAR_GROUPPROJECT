package ca.sheridancollege.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameLauncher gameLauncher = new GameLauncher();

        System.out.println("Welcome to the War card game!");

        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();

        System.out.print("Enter the number of rounds to play (default is 20): ");
        int numRounds;
        try {
            numRounds = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            numRounds = 20; // Default value
        }

        gameLauncher.startGame(player1Name, player2Name, numRounds);

        scanner.close();
    }
}