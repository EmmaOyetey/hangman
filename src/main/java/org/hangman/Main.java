package org.hangman;

import org.hangman.Words;
import org.hangman.CaptureGuess;
import org.hangman.HandleGuess;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String randomWord = Words.generateRandomWord();
        System.out.println( "checking I get a random word it is  " + randomWord);

        CaptureGuess captureGuess = new CaptureGuess();


        String enteredLetter = captureGuess.getGuesses().get(0);
        ArrayList<Integer> positions = new ArrayList<>();

        boolean letterMatch = HandleGuess.checkGuess(randomWord, enteredLetter, positions);

        System.out.println("Guess count: " + captureGuess.getGuessCount());
        System.out.println("Your guesses so far: " + enteredLetter);



        if (letterMatch) {
            System.out.println("Hooray! The entered letter matches a letter in the random word.");
            System.out.println("it occurred at the following positions");
            for (int i = 0; i < positions.size(); i++) {
                System.out.print(positions.get(i)+1);
                if (i < positions.size() - 1) {
                    System.out.print(" , "); // Add a comma and space if not the last position
                }
            }
            System.out.println();
        } else {
            System.out.println("The entered letter does not match any letter in the random word.");
        }

//        CaptureGuess captureGuess = new CaptureGuess();
//        HandleGuess handleGuess = new HandleGuess();
//        boolean isCorrect = handleGuess.checkGuess(captureGuess.getGuesses().get(0)); // Example logic, assuming only 1 guess
//        System.out.println("Is the guess correct? " + isCorrect);
    }
}
