import java.util.Objects;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String userInput = "";
    String YELLOW = "\033[0;33m";

    while (!userInput.equals("EXIT")) {
      String RESET = "\033[0m";
      String RED = "\033[0;31m";
      System.out.println(RESET + "\nPlease enter a temperature value and its unit of measurement (F or C): ");
      userInput = scanner.nextLine();
      userInput = userInput.toUpperCase().trim();
      if (userInput.equals("EXIT")) {
        System.out.println(YELLOW + "Exiting the program. Thanks!" + RESET);
        break;
      }
      String[] splitInput = userInput.split(" ", 2);
      if (splitInput.length != 2) {
        System.out.println(RED + "Invalid input.");
        continue;
      }

      int degree = 0;
      String unit = splitInput[1].toUpperCase();

      try {
        degree = Integer.parseInt(splitInput[0]);
      } catch (Exception e) {
        System.out.println(RED + "Invalid input. " + e.getMessage() + RESET);
        continue;
      }

      switch (unit) {
        case "C" -> System.out.printf(YELLOW + "%s = %.2f F %n", userInput, celsiusToFahrenheitConvert(degree));
        case "F" -> System.out.printf(YELLOW + "%s = %.2f C %n", userInput, fahrenheitToCelsiusConvert(degree));
        default -> System.out.println(RED + "Invalid input. Only 'C' or 'F' (case-insensitive) are accepted.");
      }
    }
  }

  public static double celsiusToFahrenheitConvert(int degree) {
    double converted;
    converted = ((double) (degree * 9) / 5) + 32;
    return converted;
  }

  public static double fahrenheitToCelsiusConvert(int degree) {
    double converted;
    converted = (double) ((degree - 32) * 5) / 9;
    return converted;
  }
}