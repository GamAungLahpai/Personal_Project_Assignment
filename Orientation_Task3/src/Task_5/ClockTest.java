package Task_5;

class ClockTest {
    public static void main(String[] args) {


        // Test 1: Get first instance
        Clock clock1 = Clock.getInstance();
        System.out.println("Test 1 - Initial clock: " + clock1);

        // Test 2: Set time and verify
        clock1.setTime(10.5);
        System.out.println("Test 2 - After setting time to 10.5: " + clock1);

        // Test 3: Get second "instance" (should be same object)
        Clock clock2 = Clock.getInstance();
        System.out.println("Test 3 - Second clock reference: " + clock2);

        // Test 4: Verify both references point to same object
        System.out.println("Test 4 - Are clock1 and clock2 the same object? " +
                (clock1 == clock2));

        // Test 5: Change time using second reference
        clock2.setTime(25.0);
        System.out.println("Test 5 - After setting time via clock2:");
        System.out.println("         clock1: " + clock1);
        System.out.println("         clock2: " + clock2);

        // Test 6: Advance time
        clock1.advanceTime(5.5);
        System.out.println("Test 6 - After advancing by 5.5: " + clock1);

        // Test 7: Reset clock
        clock2.reset();
        System.out.println("Test 7 - After reset: " + clock1);

        // Test 8: Simulate event processing
        System.out.println("\n=== Simulation Example ===");
        Clock simClock = Clock.getInstance();

        double[] eventTimes = {0.0, 2.3, 5.7, 8.1, 12.4};

        for (double eventTime : eventTimes) {
            simClock.setTime(eventTime);
            System.out.printf("Processing event at time: %.1f%n", simClock.getTime());
        }


    }
}