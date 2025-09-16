package Task_2;

public class AgeDistribution {
    public static void main(String[] args) {
        final int ITERATIONS = 1000;
        final int MAX_AGE = 30;

        // Age distribution table: [cumulative_percentage, age]
        // Based on typical university student age distribution
        int ageDistribution[][] = {
                {15, 19},
                {35, 20},
                {55, 21},
                {70, 22},
                {85, 23},
                {92, 24},
                {97, 25},
                {99, 26},
                {100, MAX_AGE}
        };

        // Array to count generated ages
        int generatedAges[] = new int[MAX_AGE + 1];

        System.out.println("Generating " + ITERATIONS + " age values...\n");

        // Generate ages according to the distribution
        for (int i = 1; i <= ITERATIONS; i++) {
            // Generate random number between 1 and 100
            int randomNum = (int)(Math.random() * 100) + 1;

            // Find the corresponding age using the cumulative distribution
            int j = 0;
            while (randomNum > ageDistribution[j][0]) {
                j++;
            }

            // Increment the count for this age
            int selectedAge = ageDistribution[j][1];
            generatedAges[selectedAge]++;
        }

        // Display results
        System.out.println("=== Age Distribution Results ===");
        System.out.println("Age  Count    Percentage");
        System.out.println("---  -----    ----------");

        int totalCount = 0;
        for (int age = 0; age <= MAX_AGE; age++) {
            if (generatedAges[age] != 0) {
                double percentage = ((double)generatedAges[age] / ITERATIONS) * 100;
                System.out.printf("%-4d %-8d %-8.2f%%\n", age, generatedAges[age], percentage);
                totalCount += generatedAges[age];
            }
        }

        System.out.println("---  -----    ----------");
        System.out.printf("Total: %d (%.1f%%)\n", totalCount, (double)totalCount/ITERATIONS*100);

        // Test with different seeds to show variability
        System.out.println("\n=== Testing Variability with Different Seeds ===");
        testWithDifferentSeeds(ageDistribution, MAX_AGE);
    }

    // Method to demonstrate variability with different random seeds
    public static void testWithDifferentSeeds(int[][] ageDistribution, int maxAge) {
        final int TEST_ITERATIONS = 100;

        for (int seed = 1; seed <= 3; seed++) {
            java.util.Random random = new java.util.Random(seed);
            int[] testAges = new int[maxAge + 1];

            System.out.println("Run " + seed + " (seed=" + seed + "):");

            // Generate smaller sample to show variability
            for (int i = 0; i < TEST_ITERATIONS; i++) {
                int randomNum = random.nextInt(100) + 1;
                int j = 0;
                while (randomNum > ageDistribution[j][0]) {
                    j++;
                }
                testAges[ageDistribution[j][1]]++;
            }

            // Show first few results
            System.out.print("Ages generated: ");
            int count = 0;
            for (int age = 0; age <= maxAge && count < 5; age++) {
                if (testAges[age] > 0) {
                    System.out.print("Age " + age + ": " + testAges[age] + " ");
                    count++;
                }
            }
            System.out.println();
        }
    }
}