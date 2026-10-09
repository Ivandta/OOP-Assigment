import java.util.Scanner;

public class BankDemo {

    static void listAll(Bank bank) {
        System.out.println("\n=== CUSTOMERS & ACCOUNTS ===");
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            Customer c = bank.getCustomer(i);
            System.out.println("[" + i + "] " + c.getFirstName() + " " + c.getLastName());
            for (int j = 0; j < c.getNumOfAccounts(); j++) {
                System.out.println("      Account " + j + ": Rp " + c.getAccount(j).getBalance());
            }
        }
    }

    static Customer pickCustomer(Scanner input, Bank bank) {
        listAll(bank);
        System.out.print("Select customer index: ");
        Customer c = bank.getCustomer(input.nextInt());
        if (c == null) {
            System.out.println("Invalid customer.");
        }
        return c;
    }

    static Account pickAccount(Scanner input, Customer c) {
        if (c.getNumOfAccounts() == 0) {
            System.out.println("This customer has no account yet.");
            return null;
        }
        System.out.print("Select account index (0-" + (c.getNumOfAccounts() - 1) + "): ");
        Account a = c.getAccount(input.nextInt());
        if (a == null) {
            System.out.println("Invalid account.");
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Welcome to Bank ABC");

        // Seed data: 3 customers, each with one account of Rp 100000
        String[][] seed = {
            {"Joko", "Widodo"},
            {"Susi", "Susanti"},
            {"Ivan", "Andita"}
        };
        for (String[] s : seed) {
            bank.addCustomer(s[0], s[1]);
        }
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            bank.getCustomer(i).setAccount(new Account(100000));
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== TRANSACTION OPTIONS ===");
            System.out.println("1. List customers & accounts");
            System.out.println("2. Add customer");
            System.out.println("3. Open new account for a customer");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    listAll(bank);
                    break;

                case 2:
                    System.out.print("First name: ");
                    String f = input.next();
                    System.out.print("Last name: ");
                    String l = input.next();
                    if (bank.addCustomer(f, l)) {
                        System.out.println("Customer added. Total customers: " + bank.getNumOfCustomers());
                    } else {
                        System.out.println("Sorry, the bank cannot accept more customers.");
                    }
                    break;

                case 3: {
                    Customer c = pickCustomer(input, bank);
                    if (c != null) {
                        System.out.print("Initial balance: Rp ");
                        c.setAccount(new Account(input.nextDouble()));
                        System.out.println("Account opened. Accounts owned: " + c.getNumOfAccounts());
                    }
                    break;
                }

                case 4: {
                    Customer c = pickCustomer(input, bank);
                    Account a = (c == null) ? null : pickAccount(input, c);
                    if (a != null) {
                        System.out.print("Enter deposit amount: Rp ");
                        if (a.deposit(input.nextDouble())) {
                            System.out.println("Current balance: Rp " + a.getBalance());
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }
                    }
                    break;
                }

                case 5: {
                    Customer c = pickCustomer(input, bank);
                    Account a = (c == null) ? null : pickAccount(input, c);
                    if (a != null) {
                        System.out.print("Enter withdrawal amount: Rp ");
                        if (a.withdraw(input.nextDouble())) {
                            System.out.println("Current balance: Rp " + a.getBalance());
                        } else {
                            System.out.println("Sorry, insufficient balance or invalid amount.");
                        }
                    }
                    break;
                }

                case 6:
                    running = false;
                    System.out.println("\nTotal transactions completed today: " + Account.getTotalTransaction());
                    System.out.println("Thank you.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        }

        input.close();
    }
}