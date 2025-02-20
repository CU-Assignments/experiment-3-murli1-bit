import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        
        try {
            double number = Double.parseDouble(scanner.nextLine());
            if (number < 0) {
                throw new IllegalArgumentException("Error: Cannot calculate the square root of a negative number.");
            }
            double squareRoot = Math.sqrt(number);
            System.out.println("The square root of " + number + " is " + squareRoot);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
