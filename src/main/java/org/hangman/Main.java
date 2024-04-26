package org.hangman;

import org.hangman.Words;
import org.hangman.CaptureGuess;
import org.hangman.HandleGuess;
import org.hangman.CommandLine;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> guesses = new ArrayList<>();
        ArrayList<String> incorrectGuesses = new ArrayList<>();
        boolean letterIsInWord = false;
        boolean winner = false;

        String randomWord = Words.generateRandomWord();
        String[] correctLetters = Words.generateGuessedLettersArray(randomWord);

        CommandLine.displayRandomWord(randomWord); // to remove

        for (int attempt = 1; attempt <= HandleGuess.getMaxGuesses(); attempt++) {
            CommandLine.displayGuessPrompt(attempt, guesses);
            CaptureGuess captureGuess = new CaptureGuess(guesses);
            String enteredLetter = guesses.get(guesses.size() - 1);
            letterIsInWord = HandleGuess.checkGuess(randomWord, enteredLetter, correctLetters, incorrectGuesses);
        //    CommandLine.displayLetterMatch(positions);
            System.out.println(guesses);
            System.out.println(Arrays.toString(correctLetters));
        //    System.out.println(incorrectGuesses);

            if (letterIsInWord) {
                CommandLine.displayPreviousGuesses(guesses);
            } else {
                CommandLine.displayNoLetterMatch();
            }

//            if (correctLetters.length() == randomWord.length()) {
//                System.out.println("Congratulations! You've guessed the word.");
//                break; // Exit loop if all letters have been found
//            }
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


