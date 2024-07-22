# Hangman Java Game

## Overview
Welcome to the Hangman Java Game! This command-line version of the classic Hangman game, implemented uses object-oriented principles in Java, to build a fully functional Hangman game, complete with scorekeeping and a command-line interface.. The game includes features like score tracking, a variety of words to guess, and a visual representation of the hangman. Switch to master to view code.

## Features
Interactive Gameplay: Players can guess letters of a randomly selected word.
Scorekeeping: Tracks games played, won, and lost for each user.
Command-Line Interface: Provides prompts and feedback throughout the game.
Visual Representation: Displays the Hangman image as the game progresses.
Play Again Option: Allows users to start a new game without restarting the application.

## Key Classes and Responsibilities
**Main:** Entry point of the application.Initializes the user and starts the game.                       
**HangmanGame:** Manages the core game logic. Controls game flow, checking guesses, and determining win/loss conditions. Handles user interaction and game state updates.              
**HandleGuess:** Manages guesses and tracks the game's state. Checks if guesses are correct, unique, and updates the list of correct/incorrect guesses. Determines if the player has won or lost.              
**CaptureGuess:** Captures and validates user input. Ensures the input is a single valid letter.                
**CommandLine**: Handles all command-line outputs and prompts. Displays game prompts, messages, and updates.              
**HangmanImage:** Displays the Hangman image based on the number of incorrect guesses.                  
**User:** Stores user information and game statistics. Tracks games played, won, and lost.                            
**Words:** Provides a random word for the game. Maintains a list of possible words and selects one randomly.                                    

## Demonstration of OOP Principles
**Encapsulation:** Each class has a well-defined responsibility and maintains its own state.                            
Encapsulation involves bundling the data (fields) and the methods (functions) that operate on the data into a single unit or class, and restricting access to some of the object's components.    
Example :  the User class encapsulates the user's data and provides public methods to access and modify this data. The internal state (fields) is kept private to prevent unauthorized access and modification.     

**Abstraction:** Complex functionalities are abstracted into methods and classes. 
Abstraction involves hiding the complex implementation details and showing only the necessary features of an object.
Example: The HandleGuess class abstracts the complexity of managing guesses, checking if a guess is correct, and tracking the game state. The user of this class does not need to know the internal implementation details.

**Inheritance:** Not explicitly used in this project but the principles of code reuse and organization are followed. 
Example: Abstract User Class (Potential Enhancement.)If this game were expanded, inheritance could be used to create a hierarchy of classes. For example, an abstract User class could be extended for different types of users or players.

                              package org.hangman;
                              
                              public abstract class User {
                                  private String name;
                              
                                  public User(String name) {
                                      this.name = name;
                                  }
                              
                                  public String getName() {
                                      return name;
                                  }
                              
                                  public abstract void incrementGamesPlayed();
                                  public abstract void incrementGamesWon();
                                  public abstract void incrementGamesLost();
                              }
                              
                              class SinglePlayer extends User {
                                  private int gamesPlayed;
                                  private int gamesWon;
                                  private int gamesLost;
                              
                                  public SinglePlayer(String name) {
                                      super(name);
                                      this.gamesPlayed = 0;
                                      this.gamesWon = 0;
                                      this.gamesLost = 0;
                                  }
                              
                                  @Override
                                  public void incrementGamesPlayed() {
                                      this.gamesPlayed++;
                                  }
                              
                                  @Override
                                  public void incrementGamesWon() {
                                      this.gamesWon++;
                                  }
                              
                                  @Override
                                  public void incrementGamesLost() {
                                      this.gamesLost++;
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
                              }
In this example, an abstract User class is used to define a common interface for all user types. The SinglePlayer class extends the User class and provides specific implementations for its methods.

**Polymorphism:** Utilized through method overriding and interfaces where necessary (e.g., different display methods in HangmanImage).                             
Polymorphism allows objects to be treated as instances of their parent class rather than their actual class. This is typically achieved through method overriding and interfaces.
Example: HangmanImage Class (Potential Enhancement)

                              package org.hangman;
                              
                              public interface HangmanImage {
                                  void displayImage(int guessesLeft);
                              }
                              
                              class SimpleHangmanImage implements HangmanImage {
                                  @Override
                                  public void displayImage(int guessesLeft) {
                                      // Simple text-based hangman image display logic
                                      System.out.println("Guesses left: " + guessesLeft);
                                  }
                              }
                              
                              class DetailedHangmanImage implements HangmanImage {
                                  @Override
                                  public void displayImage(int guessesLeft) {
                                      // Detailed graphical hangman image display logic
                                      System.out.println("Detailed image with guesses left: " + guessesLeft);
                                  }
                              }
In this example, HangmanImage is an interface that defines a method displayImage. The SimpleHangmanImage and DetailedHangmanImage classes implement this interface, providing different ways of displaying the hangman image. This allows the game to use different image display strategies interchangeably.

## How to Play
Start the Game: Run the Main class. Enter your name when prompted.
Guess Letters: Follow the prompts to guess letters one at a time.
The game will provide feedback on your guesses and display the current state of the hangman.
Win or Lose: The game will continue until you either guess the word or run out of guesses.
Play Again: After each game, you will be told number of games played, won and lost and prompted to play again or exit.

## Scorekeeping
Games Played: Incremented after each game.
Games Won: Incremented when the player guesses the word correctly.
Games Lost: Incremented when the player runs out of guesses.

## Code Quality
**Static Constants:** Used for maximum guesses, ensuring easy adjustments and clear code.  Use of static final variables for constants ensures that values remain unchanged throughout the game.                    
**Control Flow:** Utilizes loops and conditional statements effectively, with minimal nesting to improve readability.                                                                          
**Separation of Concerns:** Clear separation between different functionalities, making the code easier to maintain and extend.                                                                    

## Next Steps and Enhancements
**Case Insensitivity:** Handle both uppercase and lowercase letter inputs as correct guesses.                                               
**Branch Management:** Merge master into main or set master as the default branch for better codebase visibility.                         
**Code Refactoring:** Simplify the control flow in the play() method to reduce complexity and improve maintainability; reduce nesting and improve readability                                                       
**Graphical Interface:** Consider implementing a GUI for a more interactive user experience.                                     
**Abstract User Class:** Consider making the User class abstract and enable multiple players to extend it for a multiplayer game.                               
**Additional Words:** Expand the list of possible words for more variety in gameplay.                                
                             
Thank you for trying out the Hangman game! Enjoy playing and improving your guessing skills!
