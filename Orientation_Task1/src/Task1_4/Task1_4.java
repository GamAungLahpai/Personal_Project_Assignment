package Task1_4;

import java.util.LinkedList;
import java.util.Scanner;

public class Task1_4 {
    public static void main(String[] args) {
        // LinkedList used as a queue (FIFO principle)
        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main loop for user interaction
        while (running) {
            // Menu options
            System.out.println("\n--- Queue System ---");
            System.out.println("1. Queue a customer");
            System.out.println("2. Dequeue a customer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Queue a new customer
                    long start = System.nanoTime();  // Record current time
                    Customer newCustomer = new Customer(start);
                    queue.addFirst(newCustomer);     // Add to front of queue
                    System.out.println("Customer " + newCustomer.getId() + " has entered the queue.");
                    break;

                case 2:
                    // Dequeue a customer (FIFO: remove oldest)
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty. No customer to dequeue.");
                    } else {
                        Customer removed = queue.removeLast(); // Remove the one who has waited longest
                        removed.setEndTime(System.nanoTime()); // Record end time
                        System.out.println("Customer " + removed.getId() + " has left the queue.");
                        System.out.println("Time spent in queue: " + removed.getTimeSpent() + " nanoseconds");
                    }
                    break;

                case 3:
                    // Exit the program
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close(); // Close scanner to avoid resource leaks
    }
}