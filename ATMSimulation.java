import java.util.Scanner;

public class ATMSimulation {
    private static final String PIN = "1234";
    private static double balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();

        try {
            if (!PIN.equals(inputPin)) {
                throw new Exception("Invalid PIN");
            }

            System.out.print("Withdraw Amount: ");
            double withdrawAmount = scanner.nextDouble();

            if (withdrawAmount > balance) {
                throw new Exception("Insufficient balance");
            }

            balance -= withdrawAmount;
            System.out.println("Withdrawal successful. New Balance: " + balance);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + ". Current Balance: " + balance);
        } finally {
            System.out.println("Remaining Balance: " + balance);
        }
    }
}
