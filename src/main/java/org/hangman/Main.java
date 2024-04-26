package org.hangman;

import org.hangman.Words;
import org.hangman.CaptureGuess;
import org.hangman.HandleGuess;
import org.hangman.CommandLine;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String randomWord = Words.generateRandomWord();
        CommandLine.displayRandomWord(randomWord); // to remove

        ArrayList<Integer> positions = new ArrayList<>();
        ArrayList<String> guesses = new ArrayList<>();
        boolean letterIsInWord = false;


        for (int attempt = 1; attempt <= HandleGuess.getMaxGuesses(); attempt++) {
            CommandLine.displayGuessPrompt(attempt, guesses);
            CaptureGuess captureGuess = new CaptureGuess(guesses);
            String enteredLetter = guesses.get(guesses.size() - 1);
            letterIsInWord = HandleGuess.checkGuess(randomWord, enteredLetter, positions);
            CommandLine.displayLetterMatch(positions);
            if (letterIsInWord) {
                CommandLine.displayPreviousGuesses(guesses);
            } else {
                CommandLine.displayNoLetterMatch();
            }

            if (positions.size() == randomWord.length()) {
                System.out.println("Congratulations! You've guessed the word.");
                break; // Exit loop if all letters have been found
            }
        }

        if (!letterIsInWord) {
            System.out.println("You've reached the maximum number of guesses. The word was: " + randomWord);
        }
    }
}
//        CaptureGuess captureGuess = new CaptureGuess();
//        HandleGuess handleGuess = new HandleGuess();
//        boolean isCorrect = handleGuess.checkGuess(captureGuess.getGuesses().get(0)); // Example logic, assuming only 1 guess
//        System.out.println("Is the guess correct? " + isCorrect);


