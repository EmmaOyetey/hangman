package org.hangman;

public class HangmanGame {

    boolean isWinner = false;
    boolean isLoser = false;
    boolean isGuessUnique = true;
    boolean isLetterInWord;
    char enteredLetter;

    public void play(){

        String randomWord = Words.generateRandomWord();
        CommandLine.displayRandomWord(randomWord); // to remove
        CommandLine.displayStartGamePrompt();
        HandleGuess handleGuess = new HandleGuess(randomWord);

        while (!isWinner && !isLoser) {
            CommandLine.displayGuessPrompt(handleGuess.getIncorrectGuesses());
            CaptureGuess captureGuess = new CaptureGuess();
            enteredLetter = captureGuess.getGuess();
            isGuessUnique = handleGuess.checkIsUnique(enteredLetter);
            isLetterInWord = handleGuess.checkGuess(randomWord, enteredLetter);
            isWinner = handleGuess.checkIsWinner();
            isLoser = handleGuess.checkIsLoser();

            if (!isGuessUnique) {
                CommandLine.displayGuessNotUnique(enteredLetter);
                continue;
            }
            if (isWinner) {
                displayWinnerMessage(handleGuess);
            } else if (!isLetterInWord) {
                displayNoLetterMatchMessage(enteredLetter, handleGuess);
            } else {
                displayLetterMatchMessage(enteredLetter, handleGuess);
            }
        }

        if (isLoser) {
            CommandLine.displayLoserMessage(randomWord);
        }
    }

    private void displayWinnerMessage(HandleGuess handleGuess) {
        CommandLine.displayWinnerMessage();
        CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
    }

    private void displayNoLetterMatchMessage(char enteredLetter, HandleGuess handleGuess) {
        CommandLine.displayNoLetterMatch(enteredLetter);
        CommandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
        CommandLine.displayNumberGuessesRemaining(handleGuess.getGuessesLeft());
        CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
    }

    private void displayLetterMatchMessage(char enteredLetter, HandleGuess handleGuess) {
        CommandLine.displayLetterMatch(enteredLetter);
        CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
        CommandLine.displayNumberGuessesRemaining(handleGuess.getGuessesLeft());
        CommandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
    }
}
