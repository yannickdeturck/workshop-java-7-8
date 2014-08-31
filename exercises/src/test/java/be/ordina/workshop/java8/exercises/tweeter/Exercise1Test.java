package be.ordina.workshop.java8.exercises.tweeter;

import be.ordina.workshop.java8.exercises.Exercise1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class Exercise1Test {
    @Test
    public void testFilterUnevenCharacterSize() throws Exception {
        List<String> unevenFruits = Exercise1.filterEvenCharacterSize();
        Assert.assertEquals(3, unevenFruits);
        Assert.assertTrue(unevenFruits.contains("pear"));
        Assert.assertTrue(unevenFruits.contains("banana"));
        Assert.assertTrue(unevenFruits.contains("orange"));
    }

    @Test
    public void testSortAlphabetically() throws Exception {
        List<String> sortedFruits = Exercise1.sortAlphabetically();
        Assert.assertEquals("apple", sortedFruits.get(0));
        Assert.assertEquals("banana", sortedFruits.get(1));
        Assert.assertEquals("lemon", sortedFruits.get(2));
        Assert.assertEquals("orange", sortedFruits.get(3));
        Assert.assertEquals("pear", sortedFruits.get(4));
        Assert.assertEquals("pineapple", sortedFruits.get(5));
    }

    @Test
    public void testMapThreeFirstCharacters() throws Exception {
        List<String> fruits = Exercise1.mapThreeFirstCharacters();
        Assert.assertEquals("app", fruits.get(0));
        Assert.assertEquals("pea", fruits.get(1));
        Assert.assertEquals("ban", fruits.get(2));
        Assert.assertEquals("ora", fruits.get(3));
        Assert.assertEquals("pin", fruits.get(4));
        Assert.assertEquals("lem", fruits.get(5));
    }

    @Test
    public void testFruitWithSizeExists() throws Exception {
        Assert.assertTrue(Exercise1.fruitWithSizeExists(5));
        Assert.assertTrue(Exercise1.fruitWithSizeExists(9));
        Assert.assertFalse(Exercise1.fruitWithSizeExists(2));
        Assert.assertFalse(Exercise1.fruitWithSizeExists(7));
    }

    @Test
    public void testToSingleString() throws Exception {
        Assert.assertEquals("applepearbananaorangepineapplelemon", Exercise1.toSingleString());
    }
}
