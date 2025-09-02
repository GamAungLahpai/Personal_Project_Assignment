package Task_2;

import java.util.PriorityQueue;
import java.util.Comparator;

class EventList {
    private PriorityQueue<Event> eventQueue;

    public EventList() {
        eventQueue = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        eventQueue.offer(event);
    }

    public Event getNextEvent() {
        return eventQueue.poll();
    }

    // Print contents ordered by time (avoiding for-iteration as suggested)
    public void printOrderedContents() {
        System.out.println("EventList contents (ordered by time):");
        PriorityQueue<Event> temp = new PriorityQueue<>(eventQueue);
        while (!temp.isEmpty()) {
            System.out.println("  " + temp.poll());
        }
    }
}