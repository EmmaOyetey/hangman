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
                CommandLine.displayWinnerMessage();
                CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
            } else if (!isLetterInWord) {
                CommandLine.displayNoLetterMatch(enteredLetter);
                CommandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
                CommandLine.displayNumberGuessesRemaining(handleGuess.getIncorrectAttempts());
                CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
            } else {
                CommandLine.displayLetterMatch(enteredLetter);
                CommandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
                CommandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
            }
        }

        if (isLoser) {
        CommandLine.displayLoserMessage(randomWord);
        }
    }

}
