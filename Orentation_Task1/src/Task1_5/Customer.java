package Task1_5;

import java.util.LinkedList;

class Customer {
    private static int nextId = 1;
    private int id;
    private long arrivalTime;       // when entered the queue
    private long serviceStartTime;  // when service begins
    private long serviceEndTime;    // when service ends

    public Customer(long arrivalTime) {
        this.id = nextId++;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setServiceStartTime(long serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public void setServiceEndTime(long serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public long getWaitingTime() {
        return serviceStartTime - arrivalTime;
    }

    public long getServiceTime() {
        return serviceEndTime - serviceStartTime;
    }

    public long getResponseTime() {
        return getWaitingTime() + getServiceTime();
    }
}

