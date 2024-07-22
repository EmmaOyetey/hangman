# Hangman Java Game

## Overview
Welcome to the Hangman Java game! This project demonstrates confident use of Object-Oriented Programming (OOP) principles to build a fully functional Hangman game, complete with scorekeeping and a command-line interface.

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
**Abstraction:** Complex functionalities are abstracted into methods and classes.                                      
**Inheritance:** Not explicitly used in this project but the principles of code reuse and organization are followed.                           
**Polymorphism:** Utilized through method overriding and interfaces where necessary (e.g., different display methods in HangmanImage).                             

## How to Play
Start the Game: Run the Main class. Enter your name when prompted.
Guess Letters: Follow the prompts to guess letters one at a time.
Win or Lose: The game will continue until you either guess the word or run out of guesses.
Play Again: After each game, you will be prompted to play again or exit.

## Scorekeeping
Games Played: Incremented after each game.
Games Won: Incremented when the player guesses the word correctly.
Games Lost: Incremented when the player runs out of guesses.

## Code Quality and Improvements
**Static Constants:** Used for maximum guesses, ensuring easy adjustments and clear code.                                                                                  
**Control Flow:** Utilizes loops and conditional statements effectively, with minimal nesting to improve readability.                                                             
**Separation of Concerns:** Clear separation between different functionalities, making the code easier to maintain and extend.                                               

## Next Steps and Enhancements
**Case Insensitivity:** Handle both uppercase and lowercase letter inputs as correct guesses.                                 
**Branch Management:** Merge master into main or set master as the default branch for better codebase visibility.                         
**Code Refactoring:** Simplify the control flow in the play() method to reduce complexity and improve maintainability.                           
**Additional Words:** Expand the list of possible words for more variety in gameplay.                        
**Graphical Interface:** Consider implementing a GUI for a more interactive user experience.                               

Thank you for trying out the Hangman game! Enjoy playing and improving your guessing skills!
