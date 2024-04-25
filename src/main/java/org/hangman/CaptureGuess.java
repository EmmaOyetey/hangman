package org.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class CaptureGuess {

    private ArrayList<String> guesses = new ArrayList<>();
    private String enteredLetter;

    public CaptureGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make your guess:");
        String thisGuess = scanner.nextLine();
        enteredLetter = thisGuess;
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

    public String getEnteredLetter() {
        return enteredLetter;
    }

    public static void main(String[] args) {
        CaptureGuess captureGuess = new CaptureGuess();
        System.out.println("Guess count: " + captureGuess.getGuessCount());
        System.out.println("Your guesses so far: " + captureGuess.getGuesses());
    }
}// extends UserInteraction

