package com.rostifar.wordDistribution;

import java.io.Serializable;
import java.util.*;

public class ScrabbleAlphabet implements Serializable {
    private Map<Character, List<ScrabbleLetter>> letterMap = new HashMap<>();
    private static ScrabbleAlphabet alphabetInstance;

    /**
     *@ScrabbleAlphabet[constructor]
     * when instantiated loads all of the letters within a game instance, to be used for moves
     */
    public ScrabbleAlphabet() {
        alphabetInstance = this;
        loadLetters();
    }

    /**
     * @getInstance
     * purpose-> gets the instance of the alphabet bag
     * */
    public static ScrabbleAlphabet getInstance() {
        return alphabetInstance;
    }

    /**
     *@loadLetters
     * purpose-> loads letters into tile bag
     */
    private void loadLetters() {
        letterMap.put ('_', createDuplicateLetters('_', 2));

        letterMap.put('L', createDuplicateLetters('L', 4));
        letterMap.put('S', createDuplicateLetters('S', 4));
        letterMap.put('U', createDuplicateLetters('U', 4));

        letterMap.put('N', createDuplicateLetters('N', 6));
        letterMap.put('R', createDuplicateLetters('R', 6));
        letterMap.put('T', createDuplicateLetters('T', 6));

        letterMap.put('O', createDuplicateLetters('O', 8));

        letterMap.put('A', createDuplicateLetters('A', 9));
        letterMap.put('I', createDuplicateLetters('I', 9));

        letterMap.put('E', createDuplicateLetters('E', 12));

        letterMap.put('D', createDuplicateLetters('D', 4));
        letterMap.put('G', createDuplicateLetters('G', 3));

        letterMap.put('B', createDuplicateLetters('B', 2));
        letterMap.put('C', createDuplicateLetters('C', 2));
        letterMap.put('M', createDuplicateLetters('M', 2));
        letterMap.put('P', createDuplicateLetters('P', 2));

        letterMap.put('F', createDuplicateLetters('F', 2));
        letterMap.put('H', createDuplicateLetters('H', 2));
        letterMap.put('V', createDuplicateLetters('V', 2));
        letterMap.put('W', createDuplicateLetters('W', 2));
        letterMap.put('Y', createDuplicateLetters('Y', 2));

        letterMap.put('K', createDuplicateLetters('K', 1));

        letterMap.put('J', createDuplicateLetters('J', 1));
        letterMap.put('X', createDuplicateLetters('X', 1));

        letterMap.put('Q', createDuplicateLetters('Q', 1));
        letterMap.put('Z', createDuplicateLetters('Z', 1));
    }


    /**
     * Create multiple instances of the same letter.
     *
     * @param letter scrabble alphabet letter to duplicate
     * @param numberOfDuplications number of duplicates to create
     * @return result List of duplicate letters
     */
    private List<ScrabbleLetter> createDuplicateLetters(char letter, int numberOfDuplications) {
        List<ScrabbleLetter> duplicateListOfLetters = new ArrayList<>();

        for (int dupCntr = 0; dupCntr < numberOfDuplications; dupCntr++) {
            duplicateListOfLetters.add(new ScrabbleLetter(letter));
        }

        return duplicateListOfLetters;
    }

    /**
     * @return a list containing the letters that are available for use
     */
    public List<Character> getAvailableLetters() {
        List<Character> listOfAvaiableLetters = new ArrayList<>();

        for (char letterToCheck : letterMap.keySet()) {
            if (!letterMap.get(letterToCheck).isEmpty()) {
                listOfAvaiableLetters.add(letterToCheck);
            }
        }
        return listOfAvaiableLetters;
    }

    private char randomlySelectedLetterKey(){
        List<Character> availableKeys = getAvailableLetters();
        Random random = new Random();

        int randomKeyIndex = random.nextInt(availableKeys.size());
        return availableKeys.get(randomKeyIndex);
    }

    public List<ScrabbleLetter> getLetters(int numberOfLettersNeeded) {
        List<ScrabbleLetter> letterList;
        List<ScrabbleLetter> lettersToReturn = new ArrayList<>();

        for (int i = 0; i < numberOfLettersNeeded; i++) {
            letterList = letterMap.get(randomlySelectedLetterKey());
            ScrabbleLetter letterToRemove = letterList.iterator().next();
            lettersToReturn.add(letterToRemove);
            letterMap.get(letterToRemove.getLetter()).remove(letterToRemove);
        }
        return lettersToReturn;
    }

    public void getExchangedLetters(ScrabbleLetter scrabbleLetter) {
        letterMap.get(scrabbleLetter.getLetter()).add(scrabbleLetter);
    }

    public int getNumberOfLettersLeft(){
        int bagSize = 0;
        for (char key : letterMap.keySet()) {
            bagSize += letterMap.get(key).size();
        }
        return bagSize;
    }
}