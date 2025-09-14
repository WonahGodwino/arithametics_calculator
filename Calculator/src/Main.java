import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true;

        System.out.println("Hello and welcome to the Best Calculator!");

        while (continueCalc) {
            // Get first number with validation
            double num1 = getValidNumber(scanner, "Enter first number: ");

            // Get operator with validation
            char operator = getValidOperator(scanner);

            // Get second number with validation
            double num2 = getValidNumber(scanner, "Enter second number: ");

            // Perform calculation
            double result;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.printf("Result: %.2f\n", result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.printf("Result: %.2f\n", result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.printf("Result: %.2f\n", result);
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.printf("Result: %.2f\n", result);
                    } else {
                        System.out.println("Error: Cannot divide by zero.");
                    }
                    break;
                case '%':
                    if (num2 != 0) {
                        result = num1 % num2;
                        System.out.printf("Result: %.2f\n", result);
                    } else {
                        System.out.println("Error: Cannot perform modulus by zero.");
                    }
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    System.out.printf("Result: %.2f\n", result);
                    break;
                default:
                    // No default calculation yet due to validation
                    System.out.println("Error: Unknown operator.");
            }

            // Ask if user wants to continue
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = scanner.next().trim().toLowerCase();
            if (!choice.equals("yes")) {
                continueCalc = false;
                System.out.println("Goodbye! Thanks for using the Best Calculator.");
            }
        }

        scanner.close();
    }

    // Method to get a valid number
    public static double getValidNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next(); // clear the invalid input
        }
        return scanner.nextDouble();
    }

    // Method to get a valid operator
    public static char getValidOperator(Scanner scanner) {
        System.out.print("Enter an operator (+, -, *, /, %, ^): ");
        String input = scanner.next().trim();
        while (input.length() != 1 || "+-*/%^".indexOf(input.charAt(0)) == -1) {
            System.out.print("Invalid operator. Please enter one of (+, -, *, /, %, ^): ");
            input = scanner.next().trim();
        }
        return input.charAt(0);
    }
}
