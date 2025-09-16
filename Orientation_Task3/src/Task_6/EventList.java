package Task_6;

import java.util.*;

public class EventList {
    private List<Event> events;

    public EventList() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event removeNext() {
        if (events.isEmpty()) return null;

        // Find event with earliest time
        Event nextEvent = events.get(0);
        int nextIndex = 0;

        for (int i = 1; i < events.size(); i++) {
            if (events.get(i).getTime() < nextEvent.getTime()) {
                nextEvent = events.get(i);
                nextIndex = i;
            }
        }

        events.remove(nextIndex);
        return nextEvent;
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public int size() {
        return events.size();
    }

    public void printEvents() {
        System.out.println("Event List Contents:");
        if (events.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            // Sort events by time for display
            List<Event> sortedEvents = new ArrayList<>(events);
            sortedEvents.sort((e1, e2) -> Double.compare(e1.getTime(), e2.getTime()));

            for (int i = 0; i < sortedEvents.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + sortedEvents.get(i));
            }
        }
    }
}