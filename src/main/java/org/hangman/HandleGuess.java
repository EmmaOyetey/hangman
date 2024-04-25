package org.hangman;

import java.util.ArrayList;

public class HandleGuess {

    private static int maxGuesses = 10;

    public static int getMaxGuesses() {
        return maxGuesses;
    }

    public static boolean checkGuess(String randomWord, String enteredLetter, ArrayList<Integer> positions) {
        boolean letterMatch = false;
        positions.clear(); // Clear positions list before populating it

        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == enteredLetter.charAt(0)) {
                letterMatch = true;
                positions.add(i);

            }
        }
        return letterMatch;
    }
}