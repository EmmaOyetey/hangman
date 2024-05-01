package org.hangman;
import java.util.Scanner;

public class NewGame {

    Scanner scanner = new Scanner(System.in);

    public boolean getPlayAgainChoice() {

        char choice;

        do {
            String input = scanner.next();
            choice = input.charAt(0);

            if (choice != 'y' && choice != 'n') {
                System.out.println("Oops! Please enter y or n");
            }
        } while (choice != 'y' && choice != 'n');

        return choice == 'y';
    }

}
