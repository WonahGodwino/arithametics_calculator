import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Hello and welcome to the Best Calculator!");

        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Get first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        // Get operator
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Get second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result;

        // Perform calculation
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
        }

        scanner.close();
    }
}
