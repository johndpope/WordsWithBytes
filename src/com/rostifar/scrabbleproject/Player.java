package com.rostifar.scrabbleproject;

import com.rostifar.wordDistribution.ScrabbleLetter;
import com.rostifar.wordDistribution.ScrabbleWord;
import com.rostifar.gamecontrol.ScoreKeeper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dad and Ross on 10/4/2015.
 */
public class Player implements Serializable {
    private Rack rack;
    private String name;
    private ScoreKeeper scoreKeeper;
    protected static final int RACK_MAX_CAPACITY = 7;
    private int indx;


    public Player(String aName, int indx) {
        name = aName;
        rack = new Rack();
        scoreKeeper = new ScoreKeeper();
        this.indx = indx;
    }

    public String getName() {
        return name;
    }

    public boolean hasRack(){
        return rack != null;
    }

    public void addPointsToPlayerScore(int val) {
        scoreKeeper.addPoints(val);
    }

    public int getPlayerScore() {
        return scoreKeeper.getPlayerScore();
    }

    public Rack getRack() {
        return rack;
    }

    public String toString() {
        return "Player " + getName() + "\n" + getRack();
    }

    public boolean needsLetters() { //if true getNumberOfLettersNeeded

        return rack.getNumberOfLettersOnRack() < 7;
    }

    public int getNumberOfLettersNeeded() {
        return needsLetters() ? RACK_MAX_CAPACITY - rack.getNumberOfLettersOnRack() : 0;
    }

    public void getLettersToExchange(char[] lettersToExchange) {
        rack.exchangeLetters(lettersToExchange);
    }

    public void addLetters(List<ScrabbleLetter> letters) {
        rack.addLetters(letters);
    }

    public void removeLetters(ScrabbleWord scrabbleWord) {rack.removeLetters(scrabbleWord);}

    public boolean equals(Object otherPlayer) {
        Player playerToCompare = (Player) otherPlayer;
       return this.getName().equals(playerToCompare.getName());
    }
}