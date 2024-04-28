package org.hangman;

import java.util.Arrays;
import java.util.ArrayList;

public class HandleGuess {

    private static final int MAX_GUESSES = 10;
    private char [] correctLetters;
    private ArrayList<Character> incorrectGuesses;
    private int incorrectAttempts = 0;

    public HandleGuess(String randomWord) {
        int wordLength = Words.getWordLength(randomWord);
        correctLetters = new char[wordLength];
        Arrays.fill(correctLetters, '_');
        incorrectGuesses = new ArrayList<>();
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

//    public int getIncorrectAttempts() {
//        return incorrectAttempts;
//    }

  //  public void setIncorrectAttempts(int incorrectAttempts) {
   //     this.incorrectAttempts = incorrectAttempts;
 //   }

    public boolean checkGuess(String randomWord, char enteredLetter){
        boolean isLetterIsInWord = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == enteredLetter) {
                isLetterIsInWord= true;
                correctLetters[i] = enteredLetter;
            }
        }

        if (!isLetterIsInWord) {
            incorrectGuesses.add(enteredLetter);
            incorrectAttempts ++;
            }
        return isLetterIsInWord;
    }

    public boolean checkIsWinner() {
        for (char letter : correctLetters) {
            if (letter == '_') {
                return false;
            }
        }
        return true; // No underscores found, all letters have been guessed
    }

    public boolean checkIsLoser() {
        return incorrectGuesses.size() == 5;
    }
}

