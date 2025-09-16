package Task_7;

import java.util.Random;
public class ExponentialGenerator {
    private Random random;
    private double mean;

    public ExponentialGenerator(double mean) {
        this.mean = mean;
        this.random = new Random();
    }

    public ExponentialGenerator(double mean, long seed) {
        this.mean = mean;
        this.random = new Random(seed);
    }

    public double next() {
        // Exponential distribution using inverse transform method
        // X = -ln(1-U) / λ, where λ = 1/mean
        double u = random.nextDouble();
        return -Math.log(1 - u) * mean;
    }
}
