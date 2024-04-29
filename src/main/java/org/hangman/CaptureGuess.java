package org.hangman;

import java.util.Scanner;

public class CaptureGuess {

    private char guess;

    public CaptureGuess() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.next(); // Read the whole line and trim any leading/trailing whitespace

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Oops! Please enter a single letter.");
            }
        } while (input.length() != 1 || !Character.isLetter(input.charAt(0)));

        this.guess = input.charAt(0);
    }

    public char getGuess() {
        return guess;
    }
}