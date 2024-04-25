package org.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class CaptureGuess {

    private ArrayList<String> guesses = new ArrayList<>();

    public CaptureGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make your guess:");
        String thisGuess = scanner.nextLine();
        addGuess(thisGuess);
    }

    public void addGuess(String guess) {
        guesses.add(guess);
    }

    public int getGuessCount() {
        return guesses.size();
    }

    public ArrayList<String> getGuesses() {
        return guesses;
    }

    public static void main(String[] args) {

        System.out.println("Guess count: " + captureGuess.getGuessCount());
        System.out.println("Your guesses so far: " + captureGuess.getGuesses());
    }
}// extends UserInteraction

