package org.hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Random;

public class Words {

    private static Random random = new Random();

    public static String generateWord() {
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    private static ArrayList<String> words = new ArrayList<>();

    static {

        words.Add("rabbit");
        words.Add("bicycle");
        words.Add("popcorn");
        words.Add("diamond");
        words.Add("elephant");
        words.Add("balloon");
        words.Add("pineapple");
        words.Add("computer");
        words.Add("strawberry");
        words.Add("butterfly");
        words.Add("treasure ");
        words.Add("universe
        words.Add("mountain");
        words.Add("elephant");
        words.Add("firework");
        words.Add("backpack");
        words.Add("pineapple");
        words.Add("kangaroo");
        words.Add("adventure");
        words.Add("cucumber");
        words.Add("crocodile");
        words.Add("telescope");
        words.Add("skateboard");
        words.Add("waterfall");
        words.Add("spaceship");
        words.Add("chocolate");
        words.Add("snowflake");
        words.Add("telephone");
        words.Add("helicopter");
        words.Add("watermelon");
        words.Add("friendship");
        words.Add("croissant");
        words.Add("strawberry");
        words.Add("toothpaste");
        words.Add("dragonfly");
        words.Add("skateboard");
        words.Add("microphone");
        words.Add("skyscraper");
        words.Add("sunglasses");
        words.Add("calculator");
        words.Add("television");
        words.Add("basketball");
        words.Add("sunglasses");
        words.Add("toothbrush");
        words.Add("helicopter");
        words.Add("skyscraper");
        words.Add("telephone");
        words.Add("watermelon");
    }


}
