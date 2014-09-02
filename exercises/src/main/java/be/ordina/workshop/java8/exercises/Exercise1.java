package be.ordina.workshop.java8.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Basic exercises on the new features in Java 8.
 *
 * * @author Yannick De Turck
 *
 */
public class Exercise1 {
    private static List<String> fruits = Arrays.asList("apple", "pear", "banana", "orange", "pineapple", "lemon");

	// TODO implement this method using streams to filter out all fruits with an uneven character size
	public static List<String> filterEvenCharacterSize() {
		return new ArrayList<>();
	}

    // TODO implement this method using streams to sort the list alphabetically
    public static List<String> sortAlphabetically() {
        return new ArrayList<>();
    }

    // TODO implement this method using streams to return a list of the fruits where each fruit is limited to its 3 first characters
    public static List<String> mapThreeFirstCharacters() {
        return new ArrayList<>();
    }

    // TODO implement this method using streams and return a boolean reflecting whether a fruit's size matches with the given size
    public static boolean fruitWithSizeExists(int size) {
        return false;
    }

    // TODO implement this method using the new forEach-method available to all Collections to join all fruits in a single String
    public static String toSingleString() {
        return "";
    }
}
