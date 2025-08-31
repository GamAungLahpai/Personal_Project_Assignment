package Task1_5;

class CustomerGenerator {
    public static void generateCustomers(int count, ServicePoint servicePoint) {
        for (int i = 0; i < count; i++) {
            long arrival = System.currentTimeMillis();
            Customer c = new Customer(arrival);
            servicePoint.addToQueue(c);
            // Simulate small gap between arrivals
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}