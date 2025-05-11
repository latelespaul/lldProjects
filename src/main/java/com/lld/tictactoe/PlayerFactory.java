package com.lld.tictactoe;

public class PlayerFactory {
    public static Player getPlayer(PlayerType playerType) {
        if (playerType == null) {
            throw new IllegalArgumentException("Player type cannot be null");
        }
        return new Player(playerType.name(), playerType.name(), playerType);
    }
}
