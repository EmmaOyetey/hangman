package org.hangman;

public class HangmanGame {

    private final User user;
    private String randomWord;
    private boolean isWinner;
    private boolean isLoser;
    private boolean isGuessUnique;
    private boolean isLetterInWord;
    private char currentGuess;
    private boolean playAgain;

    public HangmanGame(User user) {
        this.user = user;
        this.randomWord = Words.generateRandomWord();
        this.isWinner = false;
        this.isLoser = false;
        this.isGuessUnique = true;
        this.isLetterInWord = false;
        this.currentGuess = '\0';
        this.playAgain = false;
    }

    public void play(){

        CommandLine commandLine = new CommandLine();
        HandleGuess handleGuess = new HandleGuess(randomWord);
        HangmanImage hangmanImage = new HangmanImage();

        commandLine.displayStartGamePrompt();
        CaptureGuess captureGuess = new CaptureGuess();
        NewGame newGame = new NewGame();

        while (!isWinner && !isLoser) {
            commandLine.displayGuessPrompt(handleGuess.getIncorrectGuesses());
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
                user.incrementGamesWon();

            } else {
                displayFeedback(isLetterInWord, currentGuess, handleGuess, hangmanImage);
            }
        }

        if (isLoser) {
            commandLine.displayLoserMessage(randomWord);
            user.incrementGamesLost();
        }

        handleGameEnd(commandLine, handleGuess, hangmanImage, newGame );
    }

    private void displayWinnerMessage(HandleGuess handleGuess) {
        CommandLine commandLine = new CommandLine();
        commandLine.displayWinnerMessage();
        commandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
    }

    private void displayFeedback(boolean isLetterInWord, char enteredLetter, HandleGuess handleGuess, HangmanImage hangmanImage) {
        CommandLine commandLine = new CommandLine();
        if (isLetterInWord) {
            commandLine.displayLetterMatch(enteredLetter);
        } else {
            commandLine.displayNoLetterMatch(enteredLetter);
            hangmanImage.displayHangman(handleGuess.getGuessesLeft());
        }
        commandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
        commandLine.displayNumberGuessesRemaining(handleGuess.getGuessesLeft());
        commandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
    }

    private void handleGameEnd(CommandLine commandLine, HandleGuess handleGuess, HangmanImage hangmanImage, NewGame newGame) {
        user.incrementGamesPlayed();
        CommandLine.displayPlayerPerformance(user.getName(), user.getGamesPlayed(), user.getGamesLost(), user.getGamesWon());
        CommandLine.displayPlayAgainPrompt(user.getName());

        if (newGame.getPlayAgainChoice()) {
            resetGame();
            play();
        } else {
            CommandLine.displayGoodbyeMessage(user.getName());
        }
    }

    private void resetGame() {
        this.isWinner = false;
        this.isLoser = false;
        this.isGuessUnique = true;
        this.isLetterInWord = false;
        this.currentGuess = '\0';
        this.playAgain = false;
        this.randomWord = Words.generateRandomWord();
    }
}
