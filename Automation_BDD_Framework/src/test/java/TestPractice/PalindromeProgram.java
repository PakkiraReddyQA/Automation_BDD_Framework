package TestPractice;

import java.util.Scanner;

public class PalindromeProgram {
	
	public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();

        // Convert the string to lowercase to make it case-insensitive
        String normalized = input.toLowerCase();

        // Initialize pointers for comparison
        int start = 0;
        int end = normalized.length() - 1;

        // Check for palindrome
        boolean isPalindrome = true;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Print the result
        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is not a palindrome.");
        }

        // Close the scanner
        scanner.close();
    }

}
