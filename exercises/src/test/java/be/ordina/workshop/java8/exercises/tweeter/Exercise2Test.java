package be.ordina.workshop.java8.exercises.tweeter;

import be.ordina.workshop.java8.exercises.Exercise3;
import org.junit.Assert;
import org.junit.Test;

public class Exercise2Test {
	@Test
	public void testGetTweetCount() throws Exception {
		Assert.assertEquals(2, Exercise3.getTweetCount("@JeremyClarkson").intValue());
		Assert.assertEquals(3, Exercise3.getTweetCount("@verge").intValue());
		Assert.assertEquals(1, Exercise3.getTweetCount("@Kotaku").intValue());
	}
}
