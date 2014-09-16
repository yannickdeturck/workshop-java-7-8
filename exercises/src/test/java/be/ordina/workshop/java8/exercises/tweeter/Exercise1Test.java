package be.ordina.workshop.java8.exercises.tweeter;

import be.ordina.workshop.java8.exercises.Exercise1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * @author Yannick De Turck
 * @author Ken Coenen
 */
@RunWith(JUnit4.class)
public class Exercise1Test {
	@Test
	public void testFilterEvenCharacterSize() {
		List<Exercise1.Food> evenFood = Exercise1.filterEvenCharacterSize();
		Assert.assertEquals(6, evenFood.size());
	}

	@Test
	public void testSortAlphabetically() {
		List<Exercise1.Food> sortedFruits = Exercise1.sortAlphabetically();
		int i = 0;
		Assert.assertEquals("apple", sortedFruits.get(i++).getName());
		Assert.assertEquals("carrot", sortedFruits.get(i++).getName());
		Assert.assertEquals("icecream", sortedFruits.get(i++).getName());
		Assert.assertEquals("lasagna", sortedFruits.get(i++).getName());
		Assert.assertEquals("lettuce", sortedFruits.get(i++).getName());
		Assert.assertEquals("orange", sortedFruits.get(i++).getName());
		Assert.assertEquals("pear", sortedFruits.get(i++).getName());
		Assert.assertEquals("pineapple", sortedFruits.get(i++).getName());
		Assert.assertEquals("pizza", sortedFruits.get(i++).getName());
		Assert.assertEquals("salmon", sortedFruits.get(i++).getName());
		Assert.assertEquals("soup", sortedFruits.get(i++).getName());
		Assert.assertEquals("steak", sortedFruits.get(i++).getName());
	}

	@Test
	public void testMapThreeFirstCharacters() {
		List<String> food = Exercise1.mapThreeFirstCharacters();
		int i = 0;
		Assert.assertEquals("app", food.get(i++));
		Assert.assertEquals("pea", food.get(i++));
		Assert.assertEquals("ora", food.get(i++));
		Assert.assertEquals("pin", food.get(i++));
		Assert.assertEquals("piz", food.get(i++));
		Assert.assertEquals("let", food.get(i++));
		Assert.assertEquals("car", food.get(i++));
		Assert.assertEquals("ste", food.get(i++));
		Assert.assertEquals("sal", food.get(i++));
		Assert.assertEquals("las", food.get(i++));
		Assert.assertEquals("sou", food.get(i++));
		Assert.assertEquals("ice", food.get(i++));
	}

	@Test
	public void testFruitWithSizeExists() {
		Assert.assertTrue(Exercise1.foodWithSizeExists(5));
		Assert.assertTrue(Exercise1.foodWithSizeExists(9));
		Assert.assertFalse(Exercise1.foodWithSizeExists(2));
		Assert.assertFalse(Exercise1.foodWithSizeExists(10));
	}

	@Test
	public void testToSingleString() {
		Assert.assertEquals("applepearorangepineapplepizzalettucecarrotsteaksalmonlasagnasoupicecream", Exercise1.toSingleString());
	}

	@Test
	public void testGetExpiredFood() {
		List<Exercise1.Food> expiredFood = Exercise1.getExpiredFood(3);
		Assert.assertEquals(1, expiredFood.size());

		expiredFood = Exercise1.getExpiredFood(6);
		Assert.assertEquals(4, expiredFood.size());

		expiredFood = Exercise1.getExpiredFood(10);
		Assert.assertEquals(9, expiredFood.size());
	}
}
