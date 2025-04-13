import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class OptionMenu {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();
    int customerNumber;
    int pinNumber;
    double checkingBalance = 1000.00;
    double savingBalance = 1500.00;
    public static void main(String[] args) throws IOException {
        OptionMenu obj = new OptionMenu();
        obj.getLogin();
    }
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(9446243, 6321);
                data.put(8988470, 9012);
                data.put(5637113, 4092);
                System.out.println("Welcome to the ATM Project!");
                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\nInvalid characters(s). Only numbers.\n");
                menuInput.nextLine(); // clear buffer
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                    return;
                }
            }
            System.out.println("\nWrong Customer Number or Pin Number.\n");

        } while (x == 1);
    }
    public void getAccountType() {
        System.out.println("Select the Account you want to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");
        int selection = menuInput.nextInt();
        switch (selection) {
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thank you for using this ATM... Byee..");
            default -> {
                System.out.println("\nInvalid Choice.\n");
                getAccountType();
            }
        }
    }
    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");
        System.out.print("Choice: ");
        int selection = menuInput.nextInt();
        switch (selection) {
            case 1 -> {
                System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
                getAccountType();
            }
            case 2 -> {
                System.out.print("Amount to withdraw: ");
                double amount = menuInput.nextDouble();
                if (amount <= checkingBalance) {
                    checkingBalance -= amount;
                } else {
                    System.out.println("Insufficient Funds.");
                }
                getAccountType();
            }
            case 3 -> {
                System.out.print("Amount to deposit: ");
                double amount = menuInput.nextDouble();
                checkingBalance += amount;
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using this ATM... Byee..");
            default -> {
                System.out.println("Invalid choice.");
                getChecking();
            }
        }
    }
    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");
        System.out.print("Choice: ");
        int selection = menuInput.nextInt();
        switch (selection) {
            case 1 -> {
                System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
                getAccountType();
            }
            case 2 -> {
                System.out.print("Amount to withdraw: ");
                double amount = menuInput.nextDouble();
                if (amount <= savingBalance) {
                    savingBalance -= amount;
                } else {
                    System.out.println("Insufficient Funds.");
                }
                getAccountType();
            }
            case 3 -> {
                System.out.print("Amount to deposit: ");
                double amount = menuInput.nextDouble();
                savingBalance += amount;
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using this ATM... Byee..");
            default -> {
                System.out.println("Invalid choice.");
                getSaving();
            }
        }
    }
    public int getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
    public int getPinNumber() {
        return pinNumber;
    }
    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
}
