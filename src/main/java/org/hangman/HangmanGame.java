package org.hangman;

public class HangmanGame {

    private final User user;
    private String randomWord;
    private boolean isWinner;
    private boolean isLoser;
    private boolean isGuessUnique;
    private boolean isLetterInWord;
    private char currentGuess;


    public HangmanGame(User user) {
        this.user = user;
        this.randomWord = Words.generateRandomWord();
        this.isWinner = false;
        this.isLoser = false;
        this.isGuessUnique = true;
        this.isLetterInWord = false;
        this.currentGuess = '\0';

    }

    public void play() {

        CommandLine commandLine = new CommandLine();
        HandleGuess handleGuess = new HandleGuess(randomWord);
        HangmanImage hangmanImage = new HangmanImage();

        commandLine.displayStartGamePrompt(user.getName(), handleGuess.getCorrectLetters());
        CaptureGuess captureGuess = new CaptureGuess();
        NewGame newGame = new NewGame();

        while (!isWinner && !isLoser) {
            commandLine.displayGuessPrompt();
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
                commandLine.displayWinnerMessage();
                commandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
                user.incrementGamesWon();
            } else {
                if (isLoser) {
                    commandLine.displayLoserMessage(randomWord);
                    user.incrementGamesLost();
                } else {
                    if (isLetterInWord) {
                        commandLine.displayLetterMatch(currentGuess);
                    } else {
                        commandLine.displayNoLetterMatch(currentGuess);
                        hangmanImage.displayHangman(handleGuess.getGuessesLeft());
                    }
                    commandLine.displayPreviousGuesses(handleGuess.getIncorrectGuesses());
                    commandLine.displayNumberGuessesRemaining(handleGuess.getGuessesLeft());
                    commandLine.displayCorrectLetters(handleGuess.getCorrectLetters());
                }
            }
        }

        handleGameEnd(commandLine, handleGuess, hangmanImage, newGame);
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
        this.randomWord = Words.generateRandomWord();
    }
}
