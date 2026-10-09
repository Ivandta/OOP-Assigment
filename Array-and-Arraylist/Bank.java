public class Bank {
    private static final int MAX_CUSTOMERS = 10;


    private Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        customers = new Customer[MAX_CUSTOMERS];
        numberOfCustomers = 0;
    }

    public boolean addCustomer(String f, String l) {
        if (numberOfCustomers >= customers.length) {
            return false; // array is full
        }
        customers[numberOfCustomers++] = new Customer(f, l);
        return true;
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= numberOfCustomers) {
            return null;
        }
        return customers[index];
    }
}