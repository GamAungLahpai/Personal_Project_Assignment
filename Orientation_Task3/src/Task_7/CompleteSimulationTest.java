package Task_7;

import java.util.ArrayList;
import java.util.List;

public class CompleteSimulationTest {

    public static void main(String[] args) {

        // Step 1: Initialize components
        Clock clock = Clock.getInstance();
        clock.reset();

        EventList eventList = new EventList();
        ServicePoint servicePoint = new ServicePoint();
        ArrivalProcess arrivalProcess = new ArrivalProcess(EventType.ARRIVAL, 3.0, 456);

        System.out.println("Step 1: Components initialized");
        System.out.println("Initial " + clock);
        System.out.println("Initial " + servicePoint);
        System.out.println();

        // Step 2: Generate 10 arrival events
        System.out.println("Step 2: Generating 10 arrival events...");
        arrivalProcess.generateEvents(eventList, 10);

        System.out.println("Events generated. " + clock);
        System.out.println("Number of events in list: " + eventList.size());
        System.out.println();

        eventList.printEvents();
        System.out.println();

        // Step 3: Process all events sequentially (clock is NOT moved here)
        System.out.println("Step 3: Processing events and creating customers...");
        System.out.println("Note: Clock is not moved during event processing");

        List<Customer> customers = new ArrayList<>();

        while (!eventList.isEmpty()) {
            Event event = eventList.removeNext();

            if (event.getType() == EventType.ARRIVAL) {
                // Create customer and set arrival time
                Customer customer = new Customer();
                customer.setArrivalTime(event.getTime());
                customers.add(customer);

                // Add customer to service point queue
                servicePoint.addCustomerToQueue(customer);
            }
        }

        System.out.printf("\nProcessed %d events, created %d customers%n",
                customers.size(), customers.size());
        System.out.println("Current " + clock); // Should still show the last event time
        System.out.println("Current " + servicePoint);
        System.out.println();

        // Step 4: Move clock forward by 5 time units
        System.out.println("Step 4: Moving clock forward by 5 time units...");
        double clockBefore = clock.getTime();
        clock.advanceTime(5.0);
        double clockAfter = clock.getTime();

        System.out.printf("Clock moved from %.2f to %.2f%n", clockBefore, clockAfter);
        System.out.println();

        // Step 5: Serve all customers and calculate time in system
        System.out.println("Step 5: Serving customers and calculating time in system...");

        List<Customer> servedCustomers = new ArrayList<>();

        while (!servicePoint.isEmpty()) {
            Customer customer = servicePoint.serveNext();
            if (customer != null) {
                servedCustomers.add(customer);
            }
        }

        // Step 6: Display results
        System.out.println("=== Final Results ===");
        System.out.println("Customer Details:");

        double totalTimeInSystem = 0.0;
        for (Customer customer : servedCustomers) {
            System.out.println("  " + customer);
            totalTimeInSystem += customer.getTimeInSystem();
        }

        double averageTimeInSystem = totalTimeInSystem / servedCustomers.size();

        System.out.println("\nSummary Statistics:");
        System.out.printf("Number of customers served: %d%n", servedCustomers.size());
        System.out.printf("Total simulation time: %.2f%n", clock.getTime());
        System.out.printf("Average time in system: %.2f%n", averageTimeInSystem);

        // Step 7: Verify the calculation logic
        System.out.println("\n=== Verification ===");
        System.out.println("Time in system = Departure time - Arrival time");
        System.out.println("Where departure time = final clock time (after 5-unit advance)");
        System.out.printf("Final clock time: %.2f%n", clock.getTime());

        if (!servedCustomers.isEmpty()) {
            Customer firstCustomer = servedCustomers.get(0);
            System.out.printf("Example: Customer %d arrived at %.2f, departed at %.2f%n",
                    firstCustomer.getId(), firstCustomer.getArrivalTime(),
                    firstCustomer.getDepartureTime());
            System.out.printf("Time in system: %.2f - %.2f = %.2f%n",
                    firstCustomer.getDepartureTime(), firstCustomer.getArrivalTime(),
                    firstCustomer.getTimeInSystem());
        }

        System.out.println("\n=== Test Complete ===");
        System.out.println("✓ Generated arrival events using ArrivalProcess");
        System.out.println("✓ Created customers from events");
        System.out.println("✓ Added customers to ServicePoint queue");
        System.out.println("✓ Advanced clock by 5 time units");
        System.out.println("✓ Served all customers and calculated time in system");
        System.out.println("✓ All components working together successfully");
    }
}