package TestPractice;

import java.util.Scanner;

import common.Main;

public class ArmStrongNumberProgram {
	public static void main(String[] args) {
		
	
	 // Create a Scanner object to read input
    Scanner scanner = new Scanner(System.in);

    // Prompt user for input
    System.out.print("Enter a number to check if it is an Armstrong number: ");
    int number = scanner.nextInt();

    // Store the original number for comparison
    int originalNumber = number;

    // Find the number of digits
    int digits = String.valueOf(number).length();

    // Initialize sum for storing the sum of powers
    int sum = 0;

    // Calculate the sum of digits raised to the power of digits
    while (number > 0) {
        int digit = number % 10; // Extract the last digit
        sum += Math.pow(digit, digits); // Add digit^digits to the sum
        number /= 10; // Remove the last digit
    }

    // Check if the original number equals the calculated sum
    if (sum == originalNumber) {
        System.out.println(originalNumber + " is an Armstrong number.");
    } else {
        System.out.println(originalNumber + " is not an Armstrong number.");
    }

    // Close the scanner
    scanner.close();
}
}


