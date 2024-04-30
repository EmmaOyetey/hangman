package org.hangman;

import java.util.Scanner;

public class CaptureGuess {

    private char guess;
    Scanner scanner = new Scanner(System.in);


    public char getGuess() {
        String input;
        do {
            input = scanner.next();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Oops! Please enter a single letter.");
            }
        } while (input.length() != 1 || !Character.isLetter(input.charAt(0)));

        this.guess = input.charAt(0);
        return this.guess;
    }
}