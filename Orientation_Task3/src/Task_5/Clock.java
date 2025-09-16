package Task_5;

public class Clock {
    // Single instance of Clock (static)
    private static Clock instance = null;

    // Current simulation time
    private double currentTime;

    private Clock() {
        this.currentTime = 0.0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setTime(double time) {
        this.currentTime = time;
    }

    public double getTime() {
        return this.currentTime;
    }

    public void advanceTime(double timeIncrement) {
        this.currentTime += timeIncrement;
    }

    public void reset() {
        this.currentTime = 0.0;
    }

    @Override
    public String toString() {
        return String.format("Clock Time: %.2f", currentTime);
    }
}
