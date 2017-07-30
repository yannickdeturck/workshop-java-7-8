package be.ordina.workshop.java8.exercises;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic exercises on the new features in Java 8.
 *
 * @author Yannick De Turck
 * @author Ken Coenen
 */
public class Exercise1 {
    private static List<Food> fridgeContent = Arrays.asList(
        new Food("apple", Category.FRUITS, LocalDate.now().plus(Period.ofWeeks(1))),
        new Food("pear", Category.FRUITS, LocalDate.now().plus(Period.ofDays(5))),
        new Food("orange", Category.FRUITS, LocalDate.now().plus(Period.ofWeeks(1))),
        new Food("pineapple", Category.FRUITS, LocalDate.now().plus(Period.ofWeeks(1))),
        new Food("pizza", Category.FREEZER, LocalDate.now().plus(Period.ofWeeks(8))),
        new Food("lettuce", Category.VEGETABLES, LocalDate.now().plus(Period.ofDays(5))),
        new Food("carrot", Category.VEGETABLES, LocalDate.now().plus(Period.ofDays(10))),
        new Food("steak", Category.MEAT, LocalDate.now().plus(Period.ofDays(2))),
        new Food("salmon", Category.FISH, LocalDate.now().plus(Period.ofDays(4))),
        new Food("lasagna", Category.PREPARED_MEALS, LocalDate.now().plus(Period.ofWeeks(1))),
        new Food("soup", Category.PREPARED_MEALS, LocalDate.now().plus(Period.ofWeeks(1))),
        new Food("icecream", Category.FREEZER, LocalDate.now().plus(Period.ofWeeks(10)))
    );

	// TODO implement this method using streams to filter out all food in our fridge with an even character size
	public static List<Food> filterEvenCharacterSize() {
		return fridgeContent.stream()
		  .filter(f -> f.getName().length() % 2 == 0)
		  .collect(Collectors.toList());
	}

	// TODO implement this method using streams to sort the list alphabetically
	public static List<Food> sortAlphabetically() {
		return fridgeContent.stream()
		  .sorted((f1, f2) -> f1.getName().compareTo(f2.getName()))
		  .collect(Collectors.toList());
	}

	// TODO implement this method using streams to return a list of food names from our fridge where each name is limited to its first three characters
	public static List<String> mapThreeFirstCharacters() {
		return fridgeContent.stream()
		  .map(f -> f.getName().substring(0, 3))
		  .collect(Collectors.toList());
	}

	// TODO implement this method using streams and return a boolean reflecting whether a food name's length matches with the given size
	public static boolean foodWithSizeExists(int size) {
		return fridgeContent.stream()
		  .anyMatch(f -> f.getName().length() == size);
	}

	// TODO implement this method using the new forEach method available to all Collections to join all food in our fridge in a single String utilising a StringBuilder
	public static String toSingleString() {
		StringBuilder bob = new StringBuilder();
		fridgeContent.forEach(bob::append);
		return bob.toString();
	}

	// TODO implement this method using streams and the new DateTime API to return all expired food after the given day
	public static List<Food> getExpiredFood(int day) {
		return fridgeContent.stream()
		  .filter(f -> LocalDate.now().plus(Period.ofDays(day)).isAfter(f.getExpirationDate()))
		  .collect(Collectors.toList());
	}

	public static class Food {
		private String name;
		private Category category;
		private LocalDate expirationDate;

		private Food(String name, Category category, LocalDate expirationDate) {
			this.name = name;
			this.category = category;
			this.expirationDate = expirationDate;
		}

		public String getName() {
			return name;
		}

		public Category getCategory() {
			return category;
		}

		public LocalDate getExpirationDate() {
			return expirationDate;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	enum Category {
		FRUITS, VEGETABLES, MEAT, FISH, PREPARED_MEALS, FREEZER;
	}
}
