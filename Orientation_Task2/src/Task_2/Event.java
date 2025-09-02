package Task_2;

import java.util.*;

// Event class implementing Comparable for chronological ordering
class Event implements Comparable<Event> {
    private double eventTime;

    public Event(double eventTime) {
        this.eventTime = eventTime;
    }

    public double getEventTime() {
        return eventTime;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }

    @Override
    public String toString() {
        return "Event(time=" + eventTime + ")";
    }
}
