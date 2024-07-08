import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equalsIgnoreCase("EXIT")) {
            String RESET = "\033[0m";
            String RED = "\033[0;31m";
            String GREEN = "\033[0;32m";
            System.out.print(RESET + "Please enter a temperature value and its unit of measurement (F or C): ");
            userInput = scanner.nextLine();
            userInput = userInput.toUpperCase();
            String[] splitInput = userInput.split(" ", 2);
            if (splitInput.length != 2) {
                System.out.println(RED + "Invalid input.");
                continue;
            }
            int degree = Integer.parseInt(splitInput[0]);
            String unit = splitInput[1].toUpperCase();
            double converted;
            switch (unit) {
                case "F" -> {
                    converted = (double) ((degree - 32) * 5) / 9;
                    System.out.printf(GREEN + "%s = %.2f C %n", userInput, converted);
                }
                case "C" -> {
                    converted = ((double) (degree * 9) / 5) + 32;
                    System.out.printf(GREEN + "%s = %.2f F %n", userInput, converted);
                }
                default -> System.out.println(RED + "Invalid input.");
            }
        }
    }
}