package Task_7;

public class Customer {
    private static int nextId = 1;
    private int id;
    private double arrivalTime;
    private double departureTime;

    public Customer() {
        this.id = nextId++;
        this.arrivalTime = 0.0;
        this.departureTime = 0.0;
    }

    public int getId() {
        return id;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(double departureTime) {
        this.departureTime = departureTime;
    }

    public double getTimeInSystem() {
        return departureTime - arrivalTime;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, arrival=%.2f, departure=%.2f, timeInSystem=%.2f]",
                id, arrivalTime, departureTime, getTimeInSystem());
    }
}