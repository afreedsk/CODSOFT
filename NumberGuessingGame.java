import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean hasWon = false;
            
            System.out.println("I have selected a number between 1 and 100. Can you guess it?");
            
            while (!hasWon && numberOfAttempts < 5) {
                System.out.print("Enter your guess: ");
                int playerGuess = scanner.nextInt();
                numberOfAttempts++;
                
                if (playerGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (playerGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasWon = true;
                    System.out.println("Congratulations! You've guessed the number in " + numberOfAttempts + " attempts.");
                }
            }
            
            if (!hasWon) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }
}
