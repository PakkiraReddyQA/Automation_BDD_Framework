package TestPractice;

import java.util.Scanner;

public class RevStringProgram {
	public static void main(String[] args) {
		
	
	// Create a Scanner object to read input
    Scanner scanner = new Scanner(System.in);

    // Prompt user for input
    System.out.print("Enter a string to reverse: ");
    String input = scanner.nextLine();

    // Initialize an empty string for the reversed result
    String reversed = " ";

    // Reverse the string using a loop
    for (int i = input.length() - 1; i >= 0; i--) {
        reversed += input.charAt(i); // Append each character in reverse order
    }

    // Print the reversed string
    System.out.println("Reversed string: " + reversed);

    // Close the scanner
    scanner.close();
}

}
