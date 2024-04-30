package org.hangman;

import java.util.ArrayList;

public class CommandLine {

    public void displayRandomWord(String randomWord) {
    System.out.println("Random word: " + randomWord);
}

    public void displayStartGamePrompt() {
        System.out.println("Welcome to Hangman. Can you guess the word?");
    }

     public void displayGuessPrompt( ArrayList<Character> incorrectGuesses)  {
   //      System.out.println("Previous incorrect guesses" + incorrectGuesses);
         System.out.println("Guess a letter:");
     }

    public void displayLetterMatch(char currentGuess) {
        System.out.println("Nice!, " + currentGuess + " is in the word");
    }

    public void displayCorrectLetters(char[] correctedLetters ) {
        System.out.println(correctedLetters);
    }

    public void displayNoLetterMatch(char currentGuess) {
        System.out.println("Sorry, " + currentGuess + " is not in the word.");
    }

    public void displayNumberGuessesRemaining(int guessesLeft){
        System.out.println(" Guesses remaining : " + guessesLeft );
    }

    public void displayPreviousGuesses(ArrayList<Character> incorrectGuesses) {
        if (incorrectGuesses != null && !incorrectGuesses.isEmpty()) {
            System.out.print("Previous Guesses: ");
            for (int i = 0; i < incorrectGuesses.size(); i++) {
                System.out.print(incorrectGuesses.get(i));
                if (i < incorrectGuesses.size() - 1) {
                    System.out.print(", "); // Add comma and space if not the last guess
                }
            }
            System.out.println(); // Print newline after all guesses are displayed
        }
    }

    public void displayGuessNotUnique(char currentGuess){
        System.out.println("You already guessed " + currentGuess);
    }

    public void displayLoserMessage(String randomWord) {
        System.out.println("Sorry, you loose! The word was: " + randomWord);
    }

    public void displayWinnerMessage() {
        System.out.println("Boom! You've guessed the word.");
    }






}

