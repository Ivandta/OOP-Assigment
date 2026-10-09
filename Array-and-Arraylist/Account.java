public class Account {
    private double balance;
    private static int totalTransaction = 0;

    public Account(double initBalance) {
        this.balance = initBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            totalTransaction++;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            totalTransaction++;
            return true;
        }
        return false;
    }

    public static int getTotalTransaction() {
        return totalTransaction;
    }
}