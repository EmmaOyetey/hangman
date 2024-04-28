package org.hangman;

import org.hangman.Words;
import org.hangman.CaptureGuess;
import org.hangman.HandleGuess;
import org.hangman.CommandLine;

public class Main {
    public static void main(String[] args) {

        String randomWord = Words.generateRandomWord();
        CommandLine.displayRandomWord(randomWord); // to remove
        CommandLine.displayStartGamePrompt();


        HandleGuess handleGuess = new HandleGuess(randomWord);

        boolean isWinner = false;
        boolean isLoser = false;

        while (!isWinner && !isLoser) {
            CommandLine.displayGuessPrompt(handleGuess.getIncorrectGuesses());
            CaptureGuess captureGuess = new CaptureGuess();
            char enteredLetter = captureGuess.getGuess();
            boolean isLetterInWord = handleGuess.checkGuess(randomWord, enteredLetter);
            isWinner = handleGuess.checkIsWinner();
            isLoser = handleGuess.checkIsLoser();

            if (isWinner) {
                System.out.println("Boom! You've guessed the word.");
                CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
            } else if (!isLetterInWord) {
                CommandLine.displayNoLetterMatch(enteredLetter);
                CommandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
                CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
            } else {
                CommandLine.displayLetterMatch(enteredLetter);
                CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
                CommandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
            }
        }

        if (isLoser) {
            System.out.println("Sorry, you've reached the maximum number of guesses. The word was: " + randomWord);
        }
    }
}