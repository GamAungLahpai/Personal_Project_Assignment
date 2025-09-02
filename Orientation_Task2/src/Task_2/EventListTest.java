package Task_2;

public class EventListTest {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // a) Generate a list of events
        eventList.addEvent(new Event(5.0));
        eventList.addEvent(new Event(2.0));
        eventList.addEvent(new Event(8.0));
        eventList.addEvent(new Event(1.0));

        // c) Print contents ordered by event time
        eventList.printOrderedContents();

        // b) Remove first event from list
        Event nextEvent = eventList.getNextEvent();
        System.out.println("\nRemoved next event: " + nextEvent);

        // Print remaining contents
        System.out.println("\nRemaining events:");
        eventList.printOrderedContents();
    }
}