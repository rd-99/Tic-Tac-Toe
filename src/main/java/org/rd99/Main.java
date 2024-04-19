package org.rd99;

import org.rd99.model.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(3);
        game.initializeGame();
        game.startGame();
    }
}