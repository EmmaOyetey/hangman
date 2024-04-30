package org.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User player = User.getUserName();

        HangmanGame hangmanGame = new HangmanGame(player);
        hangmanGame.play();
    }
}