package org.hangman;

import java.util.ArrayList;

public class CommandLine {

    public static void displayRandomWord(String randomWord) {
    System.out.println("Random word: " + randomWord);
}

//    public static void displayGuessCount(int guessCount) {
//        System.out.println("Guess count: " + guessCount);
//    }

     public static void displayGuessPrompt(int attempt, ArrayList<String> guesses) {
         System.out.println("Attempt #" + attempt);
         System.out.println("Previous guesses" + guesses);
         System.out.println("Make your guess:");
     }

    public static void displayPreviousGuesses(ArrayList<String> guesses) {
        System.out.print("Your guesses so far: ");
        for (int i = 0; i < guesses.size(); i++) {
            System.out.print(guesses.get(i));
            if (i < guesses.size() - 1) {
                System.out.print(", "); // Add comma and space if not the last guess
            }
        }
        System.out.println(); // Print newline after all guesses are displayed
    }

    public static void displayLetterMatch(ArrayList<Integer> positions) {
        System.out.println("Hooray! The entered letter matches a letter in the random word.");
        System.out.println("It occurred at the following positions:");
        for (int i = 0; i < positions.size(); i++) {
            System.out.print(positions.get(i) + 1); // Adjust position by adding 1
            if (i < positions.size() - 1) {
                System.out.print(", "); // Add a comma and space if not the last position
            }
        }
        System.out.println();
    }

    public static void displayNoLetterMatch() {
        System.out.println("The entered letter does not match any letter in the random word.");
    }
}

