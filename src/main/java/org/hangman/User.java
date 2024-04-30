package org.hangman;

import java.util.Scanner;

public class User {

        private String name;
        private int gamesPlayed;
        private int gamesWon;
        private int gamesLost;

        public User(String name) {
            this.name=name;
            this.gamesPlayed = 0;
            this.gamesWon = 0;
            this.gamesLost = 0;
        }

        public String getName() {
            return name;
        }

        public int getGamesPlayed() {
            return gamesPlayed;
        }

        public int getGamesWon() {
            return gamesWon;
        }

        public int getGamesLost() {
            return gamesLost;
        }

        public void incrementGamesPlayed() {
            gamesPlayed++;
        }

        public void incrementGamesWon() {
            gamesWon++;
        }

        public void incrementGamesLost() {
            gamesLost++;
        }

        public void resetGames() {
            gamesPlayed = 0;
            gamesWon = 0;
            gamesLost = 0;
        }

        public static User getUserName() {
        Scanner scanner = new Scanner(System.in);
        CommandLine commandLine = new CommandLine();
        commandLine.displayCaptureNamePrompt();
        String name = scanner.nextLine();
        return new User(name);
         }

}


