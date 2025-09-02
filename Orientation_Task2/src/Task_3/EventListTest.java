package Task_3;

public class EventListTest {
    public static void main(String[] args) {
        EventList eventList = new EventList();// create new event list

        // Generate events with different time and type
        eventList.addEvent(new Event(5.0, EventType.ARRIVAL));
        eventList.addEvent(new Event(2.0, EventType.EXIT));
        eventList.addEvent(new Event(8.0, EventType.ARRIVAL));
        eventList.addEvent(new Event(1.0, EventType.ARRIVAL));
        eventList.addEvent(new Event(6.0, EventType.EXIT));

        // Print contents showing event types
        System.out.println("Generated events:");
        eventList.printOrderedContents();

        // Remove first event
        Event nextEvent = eventList.getNextEvent();
        System.out.println("\nRemoved next event: " + nextEvent);

        // Print remaining events
        System.out.println("\nRemaining events:");
        eventList.printOrderedContents();
    }
}
