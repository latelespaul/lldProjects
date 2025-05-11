package com.lld;

import com.lld.tictactoe.TicTacToeMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("src/main/resources/input.txt"))) {
            System.out.println("Welcome to Tic Tac Toe");
            int size = sc.nextInt();
            if (size < 3) {
                System.out.println("Size should be greater than 2");
                return;
            }

            int totalPlayer = sc.nextInt();
            if (totalPlayer < 2) {
                System.out.println("Total player should be greater than 1");
                return;
            }
            sc.nextLine(); // Consume the newline character
            Character[] playerTypes = new Character[totalPlayer];
            for (int i = 0; i < totalPlayer; i++) {
                playerTypes[i] = Character.toUpperCase(sc.nextLine().charAt(0));
            }
            TicTacToeMain.startGame(size, totalPlayer, playerTypes);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage());
        }
    }
}