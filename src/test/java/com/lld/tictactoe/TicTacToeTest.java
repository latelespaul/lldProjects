package com.lld.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TicTacToeTest {

    @Test
    public void testPlayerXWins() throws Exception {
        // Redirect system output to capture game output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Simulate input from file
        File inputFile = new File("src/test/resources/tictactoeInput.txt");
        try (Scanner sc = new Scanner(inputFile)) {
            int size = sc.nextInt();
            int totalPlayer = sc.nextInt();
            sc.nextLine(); // Consume newline
            Character[] playerTypes = new Character[totalPlayer];
            for (int i = 0; i < totalPlayer; i++) {
                playerTypes[i] = sc.nextLine().charAt(0);
            }

            // Prepare simulated moves as input
            StringBuilder simulatedInput = new StringBuilder();
            while (sc.hasNextLine()) {
                simulatedInput.append(sc.nextLine()).append(System.lineSeparator());
            }
            System.setIn(new java.io.ByteArrayInputStream(simulatedInput.toString().getBytes()));

            // Start the game
            TicTacToeMain.startGame(size, totalPlayer, playerTypes);
        } finally {
            // Reset System.in and System.out
            System.setIn(System.in);
            System.setOut(System.out);
        }

        // Verify output contains the expected winner
        String gameOutput = outputStream.toString();
        assertTrue(gameOutput.contains("Player X wins!"));
    }
}