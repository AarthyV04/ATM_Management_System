import java.text.DecimalFormat;

public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // Setters & Getters
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

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    // Withdraw Logic
    public boolean withdrawChecking(double amount) {
        if (amount <= checkingBalance) {
            checkingBalance -= amount;
            return true;
        }
        return false;
    }

    public boolean withdrawSaving(double amount) {
        if (amount <= savingBalance) {
            savingBalance -= amount;
            return true;
        }
        return false;
    }

    // Deposit Logic
    public void depositChecking(double amount) {
        checkingBalance += amount;
    }

    public void depositSaving(double amount) {
        savingBalance += amount;
    }
}

