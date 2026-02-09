/**
 * Name: Muzakhim Mamedov
 * Project: Random Generator Analysis
 * Class: Generator.java
 * Date: 2026-02-09
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;

// EXAMPLE OF A CLASS DEFINITION
public class Generator {

    // EXAMPLE OF A CLASS ATTRIBUTE
    private final int[] sampleSizes = {10, 1000, 100000};

    /**
     * Generates a list of n random doubles.
     * @param n Number of elements
     * @param randNumGen Choice of generator (0: java.util.Random, 1: Math.random, 2: ThreadLocalRandom)
     * @return ArrayList of random doubles
     */
    // EXAMPLE OF A METHOD DEFINITION AND ACCESSIBILITY (public)
    private ArrayList<Double> populate(int n, int randNumGen) {
        ArrayList<Double> list = new ArrayList<>(n);
        Random random = new Random(); // Object instantiation for Random class

        for (int i = 0; i < n; i++) {
            switch (randNumGen) {
                case 0:
                    list.add(random.nextDouble());
                    break;
                case 1:
                    list.add(Math.random());
                    break;
                case 2:
                    list.add(ThreadLocalRandom.current().nextDouble());
                    break;
            }
        }
        return list;
    }

    /**
     * Calculates descriptive statistics for the dataset.
     */
    private ArrayList<Double> statistics(ArrayList<Double> randomValues) {
        int n = randomValues.size();
        double sum = 0;
        double min = Collections.min(randomValues);
        double max = Collections.max(randomValues);

        for (double val : randomValues) {
            sum += val;
        }
        double mean = sum / n;

        double sumSquaredDiff = 0;
        for (double val : randomValues) {
            sumSquaredDiff += Math.pow(val - mean, 2);
        }
        // Sample standard deviation uses (n-1)
        double stdDev = (n > 1) ? Math.sqrt(sumSquaredDiff / (n - 1)) : 0.0;

        ArrayList<Double> res = new ArrayList<>();
        res.add((double) n);
        res.add(mean);
        res.add(stdDev);
        res.add(min);
        res.add(max);
        return res;
    }

    /**
     * Formats and displays results in a table.
     */
    private void display(ArrayList<Double> results, boolean headerOn) {
        if (headerOn) {
            System.out.printf("%-10s %-12s %-12s %-12s %-12s%n",
                    "n", "Mean", "StdDev", "Min", "Max");
            System.out.println("------------------------------------------------------------");
        }
        System.out.printf("%-10.0f %-12.4f %-12.4f %-12.4f %-12.4f%n",
                results.get(0), results.get(1), results.get(2), results.get(3), results.get(4));
    }

    /**
     * Orchestrates the population, calculation, and display for 9 scenarios.
     */
    private void execute() {
        String[] methodNames = {"java.util.Random", "Math.random()", "java.util.concurrent.ThreadLocalRandom"};

        for (int genType = 0; genType < 3; genType++) {
            System.out.println("\nTesting Method: " + methodNames[genType]);
            boolean first = true;
            for (int size : sampleSizes) {
                ArrayList<Double> data = populate(size, genType);
                ArrayList<Double> stats = statistics(data);
                display(stats, first);
                first = false;
            }
        }
    }

    public static void main(String[] args) {
        // EXAMPLE OF OBJECT INSTANTIATION
        Generator g = new Generator();
        g.execute();
    }
}