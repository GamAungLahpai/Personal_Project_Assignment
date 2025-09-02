package Task1_4;

import java.util.LinkedList;
import java.util.Scanner;

class Customer {
    private static int nextId = 1; //Static counter to assign unique IDs
    private int id; // Customer ID
    private long startTime; // Time when customer joined the queue
    private long endTime; // Time when customer left the queue

    // Constructor==> to record start time when customer joins
    public Customer(long startTime) {
        this.id = nextId++;
        this.startTime = startTime;
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


    //Setter for end time(when leaving queue
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    // Method to calculate time spend in queue
    public long getTimeSpent() {
        return endTime - startTime;
    }
}

