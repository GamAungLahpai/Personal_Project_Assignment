package Task1_5;

import java.util.LinkedList;

class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();

    // Add customer to queue
    public void addToQueue(Customer a) {
        queue.addLast(a);  // Normal FIFO: add at end
    }

    // Remove customer from queue
    public Customer removeFromQueue() {
        if (queue.isEmpty()) return null;
        return queue.removeFirst(); // FIFO: remove from front
    }

    // Serve all customers in the queue
    public void serve() {
        while (!queue.isEmpty()) {
            Customer c = removeFromQueue();

            // Record service start time
            c.setServiceStartTime(System.currentTimeMillis());

            // Simulate service time (random between 0.5s and 2s)
            int sleeptime = (int)(500 + Math.random() * 1500);
            try {
                Thread.sleep(sleeptime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Record service end time
            c.setServiceEndTime(System.currentTimeMillis());

            // Print results
            System.out.println("Customer " + c.getId() +
                    " | Waiting time: " + c.getWaitingTime() + " ms" +
                    " | Service time: " + c.getServiceTime() + " ms" +
                    " | Response time: " + c.getResponseTime() + " ms");
        }
        System.out.println("All customers have been served.");
    }
}