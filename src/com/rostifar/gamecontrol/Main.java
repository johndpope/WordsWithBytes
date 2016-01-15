package com.rostifar.gamecontrol;

/**
 * Created by ross on 7/20/15. entry point to set a new game in motion
 */
public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        main.startGame();
    }

    public void startGame() {
       GameManager gameManager = new ScrabbleGameManager();
       gameManager.runGame();
    }
}