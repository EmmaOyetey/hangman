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

        CaptureGuess captureGuess;
        ArrayList<Integer> positions = new ArrayList<>();
        ArrayList<String> guesses = new ArrayList<>();
        boolean letterMatch = false;


        for (int attempt = 1; attempt <= HandleGuess.getMaxGuesses(); attempt++) {
            CommandLine.displayGuessPrompt(attempt, guesses);
            captureGuess = new CaptureGuess();
            String enteredLetter = captureGuess.getGuesses().get(captureGuess.getGuessCount() - 1);
            letterMatch = HandleGuess.checkGuess(randomWord, enteredLetter, positions);

            if (letterMatch) {
                CommandLine.displayLetterMatch(positions);
            } else {
                CommandLine.displayNoLetterMatch();
            }

            if (positions.size() == randomWord.length()) {
                System.out.println("Congratulations! You've guessed the word.");
                break; // Exit loop if all letters have been found
            }
        }

        if (!letterMatch) {
            System.out.println("You've reached the maximum number of guesses. The word was: " + randomWord);
        }
    }
}
//        CaptureGuess captureGuess = new CaptureGuess();
//        HandleGuess handleGuess = new HandleGuess();
//        boolean isCorrect = handleGuess.checkGuess(captureGuess.getGuesses().get(0)); // Example logic, assuming only 1 guess
//        System.out.println("Is the guess correct? " + isCorrect);


