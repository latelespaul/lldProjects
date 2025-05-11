package com.lld.tictactoe;

public class Board {
    private final String[][] board;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.board = new String[size][size];
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print((board[i][j] != null ? board[i][j] : "-") + " ");
            }
            System.out.println();
        }
    }

    public boolean insertAtBoardPosition(int row, int col, String player) {
        if (validate(row, col)) {
            board[row][col] = player;
            return true;
        } else {
            return false;
        }
    }

    public boolean validate(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }
        if (board[row][col] != null) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public String[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public String getWinner() {
        // Check rows
        for (int i = 0; i < size; i++) {
            if (board[i][0] != null && checkRow(i)) {
                return board[i][0];
            }
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            if (board[0][j] != null && checkColumn(j)) {
                return board[0][j];
            }
        }

        // Check diagonals
        if (board[0][0] != null && checkDiagonal()) {
            return board[0][0];
        }
        if (board[0][size - 1] != null && checkAntiDiagonal()) {
            return board[0][size - 1];
        }

        return null;
    }

    public boolean checkRow(int row) {
        for (int j = 1; j < board[row].length; j++) {
            if (board[row][j] == null || !board[row][j].equals(board[row][j - 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col) {
        String firstCell = board[0][col];
        for (int i = 1; i < size; i++) {
            if (board[i][col] == null || !board[i][col].equals(firstCell)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal() {
        String firstCell = board[0][0];
        for (int i = 1; i < size; i++) {
            if (board[i][i] == null || !board[i][i].equals(firstCell)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal() {
        String firstCell = board[0][size - 1];
        for (int i = 1; i < size; i++) {
            if (board[i][size - 1 - i] == null || !board[i][size - 1 - i].equals(firstCell)) {
                return false;
            }
        }
        return true;
    }
}