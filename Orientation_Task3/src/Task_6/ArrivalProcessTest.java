package Task_6;

public class ArrivalProcessTest {
    public static void main(String[] args) {
        System.out.println("=== ArrivalProcess Test Program ===\n");

        // Initialize clock
        Clock clock = Clock.getInstance();
        clock.reset(); // Start at time 0

        // Create event list
        EventList eventList = new EventList();

        // Create ArrivalProcess with mean interval of 5.0 time units
        ArrivalProcess arrivalProcess = new ArrivalProcess(EventType.ARRIVAL, 5.0, 123);

        System.out.println("Initial clock time: " + clock.getTime());
        System.out.println("Generating 10 arrival events with mean interval 5.0...\n");

        // Generate 10 events
        arrivalProcess.generateEvents(eventList, 10);

        System.out.println("Final clock time: " + clock.getTime());
        System.out.println("Number of events generated: " + eventList.size());
        System.out.println();

        // Print all events in the list
        eventList.printEvents();

        // Test with different parameters
        System.out.println("\n=== Testing Different Parameters ===");

        // Reset for new test
        clock.reset();
        EventList eventList2 = new EventList();

        // Create ArrivalProcess with different mean interval
        ArrivalProcess arrivalProcess2 = new ArrivalProcess(EventType.ARRIVAL, 2.0, 456);

        System.out.println("Generating 5 events with mean interval 2.0...");
        arrivalProcess2.generateEvents(eventList2, 5);

        eventList2.printEvents();

        // Test reproducibility with same seed
        System.out.println("\n=== Testing Reproducibility ===");

        clock.reset();
        EventList eventList3 = new EventList();
        ArrivalProcess arrivalProcess3 = new ArrivalProcess(EventType.ARRIVAL, 5.0, 123); // Same seed as first

        System.out.println("Generating 10 events with same seed (123)...");
        arrivalProcess3.generateEvents(eventList3, 10);

        eventList3.printEvents();
        System.out.println("\nNote: This should produce the same sequence as the first test!");

        System.out.println("\n=== Test Complete ===");
    }
}