package org.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class CaptureGuess {

    private ArrayList<String> guesses;



    public CaptureGuess(ArrayList<String> guesses) {
        this.guesses = guesses;
        Scanner scanner = new Scanner(System.in);
        String thisGuess = scanner.nextLine();
          guesses.add(thisGuess);
    }

    public int getGuessCount() {
        return guesses.size();
    }
    public ArrayList<String> setGuesses() {
        return guesses;
    }

    public ArrayList<String> getGuesses() {
        return guesses;
    }

}


