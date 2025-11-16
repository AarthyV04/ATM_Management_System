import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu {

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // Stores multiple accounts
    HashMap<Integer, Account> accounts = new HashMap<>();

    public OptionMenu() {
        // Preloaded users
        addAccount(9446243, 6321);
        addAccount(8988470, 9012);
        addAccount(5637113, 4092);
        addAccount(9342764, 9087);
    }

    private void addAccount(int customerNumber, int pinNumber) {
        Account acc = new Account();
        acc.setCustomerNumber(customerNumber);
        acc.setPinNumber(pinNumber);
        accounts.put(customerNumber, acc);
    }

    public void getLogin() throws IOException {
        System.out.println("\nWelcome to the ATM Project!");

        while (true) {
            try {
                System.out.print("Enter Customer Number: ");
                int customerNum = input.nextInt();

                System.out.print("Enter PIN: ");
                int pin = input.nextInt();

                if (accounts.containsKey(customerNum) &&
                    accounts.get(customerNum).getPinNumber() == pin) {

                    getAccountType(accounts.get(customerNum));
                    break;
                } else {
                    System.out.println("\nWrong Customer Number or PIN.\n");
                }

            } catch (Exception e) {
                System.out.println("\nInvalid Input. Enter only numbers.\n");
                input.nextLine();
            }
        }
    }

    public void getAccountType(Account acc) {
        System.out.println("\nSelect the Account:");
        System.out.println("1 - Checking Account");
        System.out.println("2 - Saving Account");
        System.out.println("3 - Exit");
        System.out.print("Choice: ");

        int selection = input.nextInt();

        switch (selection) {
            case 1 -> getChecking(acc);
            case 2 -> getSaving(acc);
            case 3 -> System.out.println("Thank you for using the ATM.\n");
            default -> {
                System.out.println("Invalid choice.");
                getAccountType(acc);
            }
        }
    }

    public void getChecking(Account acc) {
        System.out.println("\nChecking Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Deposit");
        System.out.println("4 - Exit");
        System.out.print("Choice: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Balance: " + moneyFormat.format(acc.getCheckingBalance()));
                getChecking(acc);
            }
            case 2 -> {
                System.out.print("Enter withdraw amount: ");
                double amt = input.nextDouble();

                if (acc.withdrawChecking(amt))
                    System.out.println("Withdrawal successful!");
                else
                    System.out.println("Insufficient Funds!");

                getChecking(acc);
            }
            case 3 -> {
                System.out.print("Enter deposit amount: ");
                acc.depositChecking(input.nextDouble());
                System.out.println("Deposit successful!");
                getChecking(acc);
            }
            case 4 -> getAccountType(acc);
            default -> getChecking(acc);
        }
    }

    public void getSaving(Account acc) {
        System.out.println("\nSaving Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Deposit");
        System.out.println("4 - Exit");
        System.out.print("Choice: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Balance: " + moneyFormat.format(acc.getSavingBalance()));
                getSaving(acc);
            }
            case 2 -> {
                System.out.print("Enter withdraw amount: ");
                double amt = input.nextDouble();

                if (acc.withdrawSaving(amt))
                    System.out.println("Withdrawal successful!");
                else
                    System.out.println("Insufficient Funds!");

                getSaving(acc);
            }
            case 3 -> {
                System.out.print("Enter deposit amount: ");
                acc.depositSaving(input.nextDouble());
                System.out.println("Deposit successful!");
                getSaving(acc);
            }
            case 4 -> getAccountType(acc);
            default -> getSaving(acc);
        }
    }
}
