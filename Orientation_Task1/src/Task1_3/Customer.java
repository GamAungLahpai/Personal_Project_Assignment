package Task1_3;

class Customer {
    private static int nextId = 1; // Static variable to keep track of the next ID
    private int id;
    private long startTime;
    private long endTime;

    // Constructor
    public Customer(long startTime, long endTime) {
        this.id = nextId++;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters
    public int getId() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    // Setters
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    // Method to calculate time spent
    public long getTimeSpent() {
        return endTime - startTime;
    }
}

