package org.hangman;

public class HangmanGame {

    private final String randomWord;
    private boolean isWinner;
    private boolean isLoser;
    private boolean isGuessUnique;
    private boolean isLetterInWord;
    private char currentGuess;

    public HangmanGame() {
        this.randomWord = Words.generateRandomWord();
        this.isWinner = false;
        this.isLoser = false;
        this.isGuessUnique = true;
        this.isLetterInWord = false;
        this.currentGuess = '\0';
    }

    public void play(){

        CommandLine commandLine = new CommandLine();
        HandleGuess handleGuess = new HandleGuess(randomWord);
        HangmanImage hangmanImage = new HangmanImage();

        commandLine.displayStartGamePrompt();

        while (!isWinner && !isLoser) {
            commandLine.displayGuessPrompt(handleGuess.getIncorrectGuesses());
            CaptureGuess captureGuess = new CaptureGuess();
            currentGuess = captureGuess.getGuess();
            isGuessUnique = handleGuess.checkIsUnique(currentGuess);
            isLetterInWord = handleGuess.checkGuess(randomWord, currentGuess);
            isWinner = handleGuess.checkIsWinner();
            isLoser = handleGuess.checkIsLoser();

            if (!isGuessUnique) {
                commandLine.displayGuessNotUnique(currentGuess);
                continue;
            }
            if (isWinner) {
                displayWinnerMessage(handleGuess);
            } else if (!isLetterInWord) {
                displayNoLetterMatchMessage(currentGuess, handleGuess, hangmanImage);
//                hangmanImage.displayHangman(handleGuess.getGuessesLeft());
            } else {
                displayLetterMatchMessage(currentGuess, handleGuess);
            }
        }

        if (isLoser) {
            commandLine.displayLoserMessage(randomWord);
            hangmanImage.displayHangman(handleGuess.getGuessesLeft());
        }
    }

    private void displayWinnerMessage(HandleGuess handleGuess) {
        CommandLine commandLine = new CommandLine();
        commandLine.displayWinnerMessage();
        commandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
    }

    private void displayNoLetterMatchMessage(char enteredLetter, HandleGuess handleGuess, HangmanImage hangmanImage) {
        CommandLine commandLine = new CommandLine();
        commandLine.displayNoLetterMatch(enteredLetter);
        hangmanImage.displayHangman(handleGuess.getGuessesLeft());
        commandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
        commandLine.displayNumberGuessesRemaining(handleGuess.getGuessesLeft());
        commandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
    }

    private void displayLetterMatchMessage(char enteredLetter, HandleGuess handleGuess) {
        CommandLine commandLine = new CommandLine();
        commandLine.displayLetterMatch(enteredLetter);
        commandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
        commandLine.displayNumberGuessesRemaining(handleGuess.getGuessesLeft());
        commandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
    }
}
