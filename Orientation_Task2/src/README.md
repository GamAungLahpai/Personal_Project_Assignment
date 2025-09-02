# Programming Tasks Notes - Event & EventList

## Task 2 - Event & EventList Classes

### What we need to build:
- `Event` class that can be sorted by time
- `EventList` class using PriorityQueue
- Test program showing it works

### Key concepts:
- **Comparable interface**: Makes events sortable by time
- **PriorityQueue**: Automatically keeps events in time order
- **offer()**: Adds event to queue (same as add() but more queue-like)
- **poll()**: Removes earliest event from queue

### File structure:
```
Event.java          - Single event with time
EventList.java      - Holds multiple events in order  
EventListTest.java  - Tests the functionality
```

### Key code snippets:
```java
// Event class - must implement Comparable
class Event implements Comparable<Event> {
    private double eventTime;
    
    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }
}

// EventList class - uses PriorityQueue
class EventList {
    private PriorityQueue<Event> eventQueue = new PriorityQueue<>();
    
    public void addEvent(Event event) {
        eventQueue.offer(event);  // Add to queue
    }
    
    public Event getNextEvent() {
        return eventQueue.poll();  // Get earliest event
    }
}
```

---

## Task 3 - Adding EventType Enum

### What's new:
- Add `EventType` enum with ARRIVAL and EXIT
- Modify Event class to include event type
- Update constructor and toString method

### File structure:
```
EventType.java      - Enum definition
Event.java          - Now includes EventType
EventList.java      - Same as before
EventListTest.java  - Creates events with types
```

### Key changes:
```java
// EventType enum
public enum EventType {
    ARRIVAL,
    EXIT
}

// Updated Event class
class Event implements Comparable<Event> {
    private double eventTime;
    private EventType eventType;  // NEW
    
    // Constructor now takes both
    public Event(double eventTime, EventType eventType) {
        this.eventTime = eventTime;
        this.eventType = eventType;
    }
    
    // toString shows both time and type
    public String toString() {
        return "Event(time=" + eventTime + ", type=" + eventType + ")";
    }
}
```

---

## Important Java Concepts

### PriorityQueue
- Automatically sorts elements
- Always gives you the "smallest" element first
- Uses Comparable interface to determine order

### Comparable Interface
```java
public int compareTo(Event other) {
    return Double.compare(this.eventTime, other.eventTime);
}
```
- Negative = this event is earlier
- Zero = same time
- Positive = this event is later

### Enums
```java
public enum EventType {
    ARRIVAL,
    EXIT
}
```
- Type-safe constants
- Better than using strings or numbers


---

## Testing  Code

### Test program template:
```java
public class EventListTest {
    public static void main(String[] args) {
        EventList eventList = new EventList();
        
        // a) Generate events
        eventList.addEvent(new Event(5.0, EventType.ARRIVAL));
        eventList.addEvent(new Event(2.0, EventType.EXIT));
        
        // c) Print ordered contents
        eventList.printOrderedContents();
        
        // b) Remove first event
        Event next = eventList.getNextEvent();
        System.out.println("Removed: " + next);
    }
}
```

### Expected output:
```
EventList contents (ordered by time):
  Event(time=2.0, type=EXIT)
  Event(time=5.0, type=ARRIVAL)

Removed: Event(time=2.0, type=EXIT)
```

---

## Quick Reference

### Main methods:
- `eventList.addEvent(event)` - Add event to list
- `eventList.getNextEvent()` - Get earliest event
- `eventList.printOrderedContents()` - Show all events in order

### Creating events:
- Task 2: `new Event(5.0)`
- Task 3: `new Event(5.0, EventType.ARRIVAL)`

### Why use offer() vs add()?
Both work the same for PriorityQueue, but `offer()` is more "queue-like" in naming.

---

## Key Insight

This builds the foundation of discrete-event simulation:
1. **Events** represent things that happen at specific times
2. **EventList** keeps them in chronological order automatically
3. **PriorityQueue** does the heavy lifting for sorting

The magic: Add events in any order → Get them back in time order!