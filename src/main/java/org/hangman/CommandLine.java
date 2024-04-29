package org.hangman;

import java.util.ArrayList;

public class CommandLine {

    public static void displayRandomWord(String randomWord) {
    System.out.println("Random word: " + randomWord);
}

    public static void displayStartGamePrompt() {
        System.out.println("Welcome to Hangman. Can you guess the word?");
    }

     public static void displayGuessPrompt( ArrayList<Character> incorrectGuesses)  {
   //      System.out.println("Previous incorrect guesses" + incorrectGuesses);
         System.out.println("Guess a letter:");
     }


    public static void displayCorrectLetters(char[] correctedLetters ) {
        System.out.println(correctedLetters);
    }

    public static void displayLetterMatch(char enteredLetter) {
        System.out.println("Nice!, " + enteredLetter + " is in the word");
    }

    public static void displayNumberGuessesRemaining(int guessesLeft){
        System.out.println("You have " + guessesLeft + " guesses remaining");
    }

    public static void displayPreviousGuesses(ArrayList<Character> incorrectGuesses) {
        if (incorrectGuesses != null && !incorrectGuesses.isEmpty()) {
            System.out.print("Your incorrect guesses so far: ");
            for (int i = 0; i < incorrectGuesses.size(); i++) {
                System.out.print(incorrectGuesses.get(i));
                if (i < incorrectGuesses.size() - 1) {
                    System.out.print(", "); // Add comma and space if not the last guess
                }
            }
            System.out.println(); // Print newline after all guesses are displayed
        }
    }

    public static void displayGuessNotUnique(char enteredLetter){
        System.out.println("You already guessed " + enteredLetter);
    }

    public static void displayNoLetterMatch(char enteredLetter) {
        System.out.println("Sorry, " + enteredLetter + " is not in the word.");
    }

    public static void displayLoserMessage(String randomWord) {
        System.out.println("Sorry, you've reached the maximum number of guesses. The word was: " + randomWord);
    }

    public static void displayWinnerMessage() {
        System.out.println("Boom! You've guessed the word.");
    }






}

