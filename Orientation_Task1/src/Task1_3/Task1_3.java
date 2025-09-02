package Task1_3;

public class Task1_3 {
    public static void main(String[] args) {
        // Example using manual times
        Customer c1 = new Customer(1000, 5000);
        Customer c2 = new Customer(2000, 8000);

        System.out.println("Customer " + c1.getId() + " spent " + c1.getTimeSpent() + " ms");
        System.out.println("Customer " + c2.getId() + " spent " + c2.getTimeSpent() + " ms");

        // Example using System.currentTimeMillis()
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000); // simulate 1 sec wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        Customer c3 = new Customer(start, end);
        System.out.println("Customer " + c3.getId() + " spent " + c3.getTimeSpent() + " ms");
    }
}
