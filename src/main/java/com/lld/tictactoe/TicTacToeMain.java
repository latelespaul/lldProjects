package com.lld.tictactoe;

import java.util.*;

public class TicTacToeMain {

    public static void startGame(int size, int totalPlayer, Character[] playerTypes) {
        if (!validateInputs(size, totalPlayer, playerTypes)) {
            System.out.println("Invalid inputs. Please restart the game with valid inputs.");
            return;
        }
        System.out.println("Game has begun");
        // Proceed with game logic
        Board board = new Board(size);
        Deque<Player> players = new LinkedList<>();
        for (int i = 0; i < totalPlayer; i++) {
            players.add(PlayerFactory.getPlayer(PlayerType.valueOf(playerTypes[i].toString())));
        }
        // print players
        for (int i = 0; i < players.size(); i++) {
            Player player = players.poll();
            System.out.println("Player "+ player.getPlayerType() + " has been registered ");
            players.offer(player);
        }
        // print board
        board.printBoard();
        Scanner sc = new Scanner(System.in);
        boolean isGameOver = false;
        while (!isGameOver) {
            for (int i = 0; i < players.size(); i++) {
                Player player = players.poll();
                System.out.println("Player " + player.getPlayerType() + " turn");
                System.out.println("Enter row and column to insert your symbol");
                int row = sc.nextInt();
                int col = sc.nextInt();
                if (board.insertAtBoardPosition(row, col, player.getSymbol())) {
                    board.printBoard();
                    if (board.getWinner() != null) {
                        System.out.println("Player " + player.getPlayerType() + " wins!");
                        isGameOver = true;
                        break;
                    }
                    if (board.isFull()) {
                        System.out.println("It's a draw!");
                        isGameOver = true;
                        break;
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
                players.offer(player);
            }
        }

    }


    private static boolean validateInputs(int size, int totalPlayer, Character[] playerTypes) {
        // Validate board size
        if (size < 3) {
            System.out.println("Board size must be at least 3.");
            return false;
        }

        // Validate total players
        if (totalPlayer < 2) {
            System.out.println("There must be at least 2 players.");
            return false;
        }

        // Validate player types
        Set<Character> uniquePlayerTypes = new HashSet<>();
        for (Character playerType : playerTypes) {
            if (playerType == null || !isValidPlayerType(playerType)) {
                System.out.println("Player types must match the valid enum values: 'X' or 'O'.");
                return false;
            }
            if (!uniquePlayerTypes.add(playerType)) {
                System.out.println("Player types must be unique.");
                return false;
            }
        }

        // All validations passed
        return true;
    }

    private static boolean isValidPlayerType(Character playerType) {
        for (PlayerType type : PlayerType.values()) {
            if (type.name().equals(playerType.toString())) {
                return true;
            }
        }
        return false;
    }

}