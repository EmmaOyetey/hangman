package org.hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Random;

public class Words {

    private static Random random = new Random();

    public static String generateRandomWord() {
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    public static int getWordLength(String word) {
        return word.length();
    }

    public static String[] generateGuessedLettersArray(String word) {
        int length = getWordLength(word);
        String[] guessedLettersArray = new String[length];
        for (int i = 0; i < length; i++) {
            guessedLettersArray [i] = "_";
        }
        return guessedLettersArray ;
    }

    private static ArrayList<String> words = new ArrayList<>();

    static {

        words.add("rabbit");
        words.add("bicycle");
        words.add("popcorn");
        words.add("diamond");
        words.add("elephant");
        words.add("balloon");
        words.add("pineapple");
        words.add("computer");
        words.add("strawberry");
        words.add("butterfly");
        words.add("universe");
        words.add("treasure ");
        words.add("mountain");
        words.add("elephant");
        words.add("firework");
        words.add("backpack");
        words.add("pineapple");
        words.add("kangaroo");
        words.add("adventure");
        words.add("cucumber");
        words.add("crocodile");
        words.add("telescope");
        words.add("skateboard");
        words.add("waterfall");
        words.add("spaceship");
        words.add("chocolate");
        words.add("snowflake");
        words.add("telephone");
        words.add("helicopter");
        words.add("watermelon");
        words.add("friendship");
        words.add("croissant");
        words.add("strawberry");
        words.add("toothpaste");
        words.add("dragonfly");
        words.add("skateboard");
        words.add("microphone");
        words.add("skyscraper");
        words.add("sunglasses");
        words.add("calculator");
        words.add("television");
        words.add("basketball");
        words.add("sunglasses");
        words.add("toothbrush");
        words.add("helicopter");
        words.add("skyscraper");
        words.add("telephone");
        words.add("watermelon");
    }


}
