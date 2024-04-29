package org.hangman;

import java.util.Arrays;
import java.util.ArrayList;

public class HandleGuess {

    private static final int MAX_GUESSES = 7;
    private char [] correctLetters;
    private ArrayList<Character> incorrectGuesses;
    private int guessesLeft;

    public HandleGuess(String randomWord) {
        if (randomWord == null || randomWord.isEmpty()){
            throw new IllegalArgumentException("Random word cannot be null or empty ");
        }
        int wordLength = Words.getWordLength(randomWord);
        correctLetters = new char[wordLength];
        Arrays.fill(correctLetters, '_');
        incorrectGuesses = new ArrayList<>();
        guessesLeft = MAX_GUESSES;
    }

    public  int getMaxGuesses() {
        return MAX_GUESSES;
    }

    public char[] getCorrectLetters() {
        return correctLetters;
    }
    public void setCorrectLetters(char[] correctLetters) {
        this.correctLetters = correctLetters;
    }

    public ArrayList<Character> getIncorrectGuesses() {
        return incorrectGuesses;
    }
    public void setIncorrectGuesses(ArrayList<Character> incorrectGuesses) {
        this.incorrectGuesses = incorrectGuesses;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

//    public void setIncorrectAttempts(int incorrectAttempts) {
//        this.incorrectAttempts = incorrectAttempts;
//    }



    public boolean checkGuess(String randomWord, char enteredLetter){
        boolean isLetterInWord = false;
        boolean isUniqueGuess = checkIsUnique(enteredLetter);

        if (!isUniqueGuess) {
            return false;
        }

        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == enteredLetter) {
                isLetterInWord = true;
                correctLetters[i] = enteredLetter;
            }
        }

        if (!isLetterInWord) {
            incorrectGuesses.add(enteredLetter);
            guessesLeft--;
        }

        return isLetterInWord;
    }


    public boolean checkIsUnique(char enteredLetter){
        for (char letter : incorrectGuesses) {
            if (letter == enteredLetter) {
                return false;
            }
        }
        for (char letter : correctLetters) {
            if (letter == enteredLetter) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIsWinner() {
        for (char letter : correctLetters) {
            if (letter == '_') {
                return false;
            }
        }
        return true;
    }

    public boolean checkIsLoser() {
        return incorrectGuesses.size() == MAX_GUESSES;
    }
}

