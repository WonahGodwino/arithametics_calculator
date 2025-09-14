import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true;

        System.out.println("Hello and welcome to the Best Scientific Calculator!");

        while (continueCalc) {
            System.out.println("\nChoose operation type:");
            System.out.println("1. Basic (+, -, *, /, %, ^)");
            System.out.println("2. Scientific (sqrt, log, sin, cos, tan)");
            System.out.print("Enter 1 or 2: ");
            int mode = getValidChoice(scanner);

            if (mode == 1) {
                // Binary operation (requires two numbers)
                double num1 = getValidNumber(scanner, "Enter first number: ");
                char operator = getValidOperator(scanner);
                double num2 = getValidNumber(scanner, "Enter second number: ");
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
                }

            } else if (mode == 2) {
                // Unary scientific function
                String function = getValidFunction(scanner);
                double num = getValidNumber(scanner, "Enter number: ");
                double result;

                switch (function.toLowerCase()) {
                    case "sqrt":
                        if (num >= 0) {
                            result = Math.sqrt(num);
                            System.out.printf("Result (√%.2f): %.2f\n", num, result);
                        } else {
                            System.out.println("Error: Cannot take square root of a negative number.");
                        }
                        break;
                    case "log":
                        if (num > 0) {
                            result = Math.log10(num);
                            System.out.printf("Result (log10(%.2f)): %.2f\n", num, result);
                        } else {
                            System.out.println("Error: Logarithm only defined for positive numbers.");
                        }
                        break;
                    case "sin":
                        result = Math.sin(Math.toRadians(num));
                        System.out.printf("Result (sin(%.2f°)): %.4f\n", num, result);
                        break;
                    case "cos":
                        result = Math.cos(Math.toRadians(num));
                        System.out.printf("Result (cos(%.2f°)): %.4f\n", num, result);
                        break;
                    case "tan":
                        double radians = Math.toRadians(num);
                        if (Math.cos(radians) == 0) {
                            System.out.println("Error: Tangent undefined at this angle.");
                        } else {
                            result = Math.tan(radians);
                            System.out.printf("Result (tan(%.2f°)): %.4f\n", num, result);
                        }
                        break;
                }
            }

            // Ask to continue
            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String choice = scanner.next().trim().toLowerCase();
            if (!choice.equals("yes")) {
                continueCalc = false;
                System.out.println("Goodbye! Thanks for using the Best Scientific Calculator.");
            }
        }

        scanner.close();
    }

    // Helper methods

    public static double getValidNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static int getValidChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter 1 or 2: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.print("Please enter 1 or 2: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter 1 or 2: ");
                scanner.next();
            }
            choice = scanner.nextInt();
        }
        return choice;
    }

    public static char getValidOperator(Scanner scanner) {
        System.out.print("Enter an operator (+, -, *, /, %, ^): ");
        String input = scanner.next().trim();
        while (input.length() != 1 || "+-*/%^".indexOf(input.charAt(0)) == -1) {
            System.out.print("Invalid operator. Please enter one of (+, -, *, /, %, ^): ");
            input = scanner.next().trim();
        }
        return input.charAt(0);
    }

    public static String getValidFunction(Scanner scanner) {
        System.out.print("Enter function (sqrt, log, sin, cos, tan): ");
        String func = scanner.next().trim().toLowerCase();
        while (!func.matches("sqrt|log|sin|cos|tan")) {
            System.out.print("Invalid function. Choose from (sqrt, log, sin, cos, tan): ");
            func = scanner.next().trim().toLowerCase();
        }
        return func;
    }
}
