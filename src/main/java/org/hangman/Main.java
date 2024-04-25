package org.hangman;

import org.hangman.Words;
import org.hangman.CaptureGuess;
import org.hangman.HandleGuess;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String randomWord = Words.generateRandomWord();
        CommandLine.displayRandomWord(randomWord);

        CaptureGuess captureGuess = new CaptureGuess();
        String enteredLetter = captureGuess.getGuesses().get(0);
        ArrayList<Integer> positions = new ArrayList<>();
        boolean letterMatch = HandleGuess.checkGuess(randomWord, enteredLetter, positions);

        CommandLine.displayGuessCount(captureGuess.getGuessCount());
        CommandLine.displayGuessesSoFar(enteredLetter);

        if (letterMatch) {
            CommandLine.displayLetterMatch(positions);
        } else {
            CommandLine.displayNoLetterMatch();
        }
    }
//        CaptureGuess captureGuess = new CaptureGuess();
//        HandleGuess handleGuess = new HandleGuess();
//        boolean isCorrect = handleGuess.checkGuess(captureGuess.getGuesses().get(0)); // Example logic, assuming only 1 guess
//        System.out.println("Is the guess correct? " + isCorrect);

}
