package org.hangman;

import java.util.ArrayList;

public class CommandLine {

  //  public void displayRandomWord(String randomWord) {
  //  System.out.println("Random word: " + randomWord);
  //  }

    public void displayCaptureNamePrompt(){
        System.out.println("Welcome to Hangman. Please enter your name : ");
    }
    public void displayStartGamePrompt(String name,char[] correctLetters ) {
        System.out.println("Hi "+ name + " Can you guess the word?");
        System.out.println(correctLetters);
    }

    public void displayGuessPrompt()  {
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
        System.out.println("Guesses remaining : " + guessesLeft );
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

    public static void displayPlayerPerformance(String name, int gamesPlayed, int gamesLost, int gamesWon){
        System.out.println(name + " You have played " + gamesPlayed + " games of which you have won " + gamesWon + " and lost " + gamesLost );
    }

    public static void displayPlayAgainPrompt(String name) {
        System.out.println(name + " Fancy another game? Enter 'y' for yes and 'n' for no");
    }

    public static void displayGoodbyeMessage(String name) {
        System.out.println("Thank you for playing " + name + "Bye!");
    }

}

