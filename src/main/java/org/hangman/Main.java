package org.hangman;

import org.hangman.Words;
import org.hangman.CaptureGuess;
import org.hangman.HandleGuess;
import org.hangman.CommandLine;

public class Main {
    public static void main(String[] args) {
            HangmanGame hangmanGame = new HangmanGame();
            hangmanGame.play();
        }

}