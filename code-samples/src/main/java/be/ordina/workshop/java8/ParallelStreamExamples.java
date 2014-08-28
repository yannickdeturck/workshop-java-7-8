package be.ordina.workshop.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamExamples {
    public static void main(String[] args) {
        // Create a big list
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i=0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // Compare sequential sort vs parallel sort
        // Sequential
        long timeBefore = System.nanoTime();
        values.stream().sorted();
        long timeAfter = System.nanoTime();
        long totalTime = TimeUnit.NANOSECONDS.toMillis(timeAfter - timeBefore);
        System.out.println(String.format("Sequential sort took: %d ms.", totalTime));

        // Parallel
        timeBefore = System.nanoTime();
        values.parallelStream().sorted();
        timeAfter = System.nanoTime();
        totalTime = TimeUnit.NANOSECONDS.toMillis(timeAfter - timeBefore);
        System.out.println(String.format("parallel sort took: %d ms.", totalTime));
    }
}
