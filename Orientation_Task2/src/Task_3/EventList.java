package Task_3;

import java.util.PriorityQueue;
/*
 * Manages a list of events in chronological order
 * Uses PriorityQueue to automatically sort events by time */
public class EventList {
    // PriorityQueue automatically keeps events sorted by time
    private PriorityQueue<Event> eventQueue;

    // create a new event list
    public EventList() {
        eventQueue = new PriorityQueue<>();
    }

    // Add a new event to the list
    // The event is automatically placed in the correct time order
    public void addEvent(Event event) {
        eventQueue.offer(event);// Add the event to priority queue
    }

    // To remove the first one and return the next event
    public Event getNextEvent() {
        return eventQueue.poll();
    }

    /*
     * Prints all events in time order without removing them
     * Uses a temporary copy to avoid destroying the original list */
    public void printOrderedContents() {
        System.out.println("EventList contents (ordered by time):");

        // Create a copy of the queue to avoid destroying original
        PriorityQueue<Event> temp = new PriorityQueue<>(eventQueue);

        // Poll events from copy to display them in order
        while (!temp.isEmpty()) {
            System.out.println("  " + temp.poll());
        }
    }
}