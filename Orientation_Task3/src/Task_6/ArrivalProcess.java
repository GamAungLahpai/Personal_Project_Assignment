package Task_6;

public class ArrivalProcess {
    private EventType eventType;
    private ExponentialGenerator generator;

    public ArrivalProcess(EventType eventType, double meanInterval) {
        this.eventType = eventType;
        this.generator = new ExponentialGenerator(meanInterval);
    }

    public ArrivalProcess(EventType eventType, double meanInterval, long seed) {
        this.eventType = eventType;
        this.generator = new ExponentialGenerator(meanInterval, seed);
    }


    public void generateNextEvent(EventList eventList) {
        Clock clock = Clock.getInstance();
        double currentTime = clock.getTime();
        double interval = generator.next();
        double eventTime = currentTime + interval;

        Event newEvent = new Event(eventTime, eventType);
        eventList.addEvent(newEvent);

        // Update clock to the new event time
        clock.setTime(eventTime);
    }


    public void generateEvents(EventList eventList, int count) {
        for (int i = 0; i < count; i++) {
            generateNextEvent(eventList);
        }
    }

    public EventType getEventType() {
        return eventType;
    }
}