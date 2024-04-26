package org.hangman;

import java.util.ArrayList;
import java.util.Arrays;

public class HandleGuess {

    private static int maxGuesses = 10;

    public static int getMaxGuesses() {
        return maxGuesses;
    }

    public static boolean checkGuess(String randomWord, String enteredLetter, String[] correctLetters, ArrayList<String> incorrectGuesses) {
        boolean letterIsInWord = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == enteredLetter.charAt(0)) {
                letterIsInWord = true;
                correctLetters[i] = enteredLetter;
                System.out.println(Arrays.toString(correctLetters));
                System.out.println(incorrectGuesses);
            } else {
                incorrectGuesses.add(enteredLetter);
                System.out.println(Arrays.toString(correctLetters));
                System.out.println(incorrectGuesses);
            }
        }
        return letterIsInWord;
    }
}