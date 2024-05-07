import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.printf("I'm thinking of a number between %d and %d.%n", lowerBound, upperBound);
        
        int rounds = 1;
        int totalAttempts = 0;
        
        while (true) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.printf("\nRound %d:%n", rounds);
            int attempts = playGame(scanner, targetNumber, lowerBound, upperBound);
            totalAttempts += attempts;
            rounds++;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        System.out.printf("%nGame Over! Your total score is %d attempts.%n", totalAttempts);
        scanner.close();
    }
    
    public static int playGame(Scanner scanner, int targetNumber, int lowerBound, int upperBound) {
        int attempts = 0;
        
        while (true) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.printf("Congratulations! You've guessed the correct number in %d attempts.%n", attempts);
                break;
            }
        }
        
        return attempts;
    }
}