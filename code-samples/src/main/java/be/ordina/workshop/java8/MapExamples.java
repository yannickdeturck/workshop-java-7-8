package be.ordina.workshop.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yannick De Turck
 */
public class MapExamples {
    public static void main(String[] args) {
        // putIfAbsent
        Map<Integer, String> map = new HashMap<>();
        for (int i=0; i<10; i++) {
            map.putIfAbsent(i, "value #" + i);
        }
        for (int i=0; i<10; i++) {
            map.putIfAbsent(i, "otherValue #" + i);
        }

        // forEach
        map.forEach((id, val) -> System.out.println(id + " -> " + val));

        System.out.println("---");

        // computeIfPresent
        map.computeIfPresent(3, (key, val) -> val + "(computed)");
        System.out.println("Key 3 = " + map.get(3));

        map.computeIfPresent(9, (key, val) -> null);
        System.out.println("Key 9 contains value? " + map.containsKey(9));

        System.out.println("---");

        // computeIfAbsent
        map.computeIfAbsent(23, key -> key + "(computed)");
        System.out.println("Key 23 contains value? " + map.containsKey(23));
        System.out.println("Key 23 = " + map.get(23));

        map.computeIfAbsent(3, key -> "bam");
        System.out.println("Key 3 = " + map.get(3));

        System.out.println("---");

        // Remove if mapped to a certain value
        map.remove(3, "value #3");
        System.out.println("Key 3 = " + map.get(3));

        map.remove(3, "value #3(computed)");
        System.out.println("Key 3 = " + map.get(3));

        System.out.println("---");

        // getOrDefault
        System.out.println("Key 3 = " + map.getOrDefault(3, "Not found"));

        // Merge
        map.merge(5, "(got merged)", (oldValue, newValue) -> oldValue + newValue);
        System.out.println("Key 5 = " + map.get(5));
    }
}
