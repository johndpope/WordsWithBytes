package com.rostifar.gamecontrol;

import org.atmosphere.cpr.Broadcaster;

/**
 * Created by Dad and Rosstifar on 6/12/2016.
 * This will hold whatever it is we would like to store as the value in the GameCache
 */
public class GameCacheValues {
    ScrabbleGameManager gameManager;
    Broadcaster broadcaster;

    public GameCacheValues(ScrabbleGameManager gameManager, Broadcaster broadcaster) {
        this.gameManager = gameManager;
        this.broadcaster = broadcaster;
    }

    public ScrabbleGameManager getGameManager() {
        return gameManager;
    }

    public Broadcaster getBroadcaster() {
        return broadcaster;
    }
}