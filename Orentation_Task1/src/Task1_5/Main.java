package Task1_5;

public class
Main {
    public static void main(String[] args) {
        ServicePoint sp = new ServicePoint();

        // Generate 5 customers into the service point
        CustomerGenerator.generateCustomers(5, sp);

        // Start serving customers
        sp.serve();
    }
}
