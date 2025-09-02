package Task_3;

public class Event implements Comparable<Event> {
    private double eventTime;
    private EventType eventType;  // Added event type

    // Constructor to takes both time and type
    public Event(double eventTime, EventType eventType) {
        this.eventTime = eventTime;
        this.eventType = eventType;
    }

    // Getter method to access private fields
    public double getEventTime() {
        return eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }


     //Compares events by time for automatic sorting
     // Earlier events come first in the priority queue
     // This method is required by Comparable interface

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }

     //Creates a readable string representation of the event
     //Useful for debugging and displaying event information

    @Override
    public String toString() {
        return "Event(time=" + eventTime + ", type=" + eventType + ")";
    }
}