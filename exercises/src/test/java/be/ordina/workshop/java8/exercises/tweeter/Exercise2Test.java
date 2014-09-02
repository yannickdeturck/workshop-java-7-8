package be.ordina.workshop.java8.exercises.tweeter;

import be.ordina.workshop.java8.exercises.Exercise2;
import org.junit.Assert;
import org.junit.Test;

public class Exercise2Test {
	@Test
	public void testGetTweetCount() throws Exception {
		Assert.assertEquals(2, Exercise2.getTweetCount("@JeremyClarkson").intValue());
		Assert.assertEquals(3, Exercise2.getTweetCount("@verge").intValue());
		Assert.assertEquals(1, Exercise2.getTweetCount("@Kotaku").intValue());
	}
}
