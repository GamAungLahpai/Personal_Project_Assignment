package Task_7;

import java.util.LinkedList;
import java.util.Queue;

public class ServicePoint {
    private Queue<Customer> queue;
    private boolean busy;
    private Customer currentCustomer;

    public ServicePoint() {
        this.queue = new LinkedList<>();
        this.busy = false;
        this.currentCustomer = null;
    }


    public void addCustomerToQueue(Customer customer) {
        queue.add(customer);
        System.out.printf("Customer %d added to queue at time %.2f%n",
                customer.getId(), customer.getArrivalTime());
    }


    public Customer serveNext() {
        if (queue.isEmpty()) {
            return null;
        }

        currentCustomer = queue.poll();
        busy = true;

        Clock clock = Clock.getInstance();
        currentCustomer.setDepartureTime(clock.getTime());

        System.out.printf("Serving Customer %d (departure time: %.2f, time in system: %.2f)%n",
                currentCustomer.getId(), currentCustomer.getDepartureTime(),
                currentCustomer.getTimeInSystem());

        busy = false;
        Customer servedCustomer = currentCustomer;
        currentCustomer = null;

        return servedCustomer;
    }


    public void serveAllCustomers() {
        System.out.println("\n=== Serving All Customers ===");
        while (!queue.isEmpty()) {
            serveNext();
        }
        System.out.println("All customers served.\n");
    }

    public int getQueueLength() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return String.format("ServicePoint[queueLength=%d, busy=%s]",
                queue.size(), busy);
    }
}