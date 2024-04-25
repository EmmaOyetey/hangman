package org.hangman;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        CaptureGuess captureGuess = new CaptureGuess();
        HandleGuess handleGuess = new HandleGuess();
        boolean isCorrect = handleGuess.checkGuess(captureGuess.getGuesses().get(0)); // Example logic, assuming only 1 guess
        System.out.println("Is the guess correct? " + isCorrect);
    }
}
        }
    }
}