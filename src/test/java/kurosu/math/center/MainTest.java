package kurosu.math.center;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {
	
	@Test
	public void testCount() {
		Main counter = new Main();
		
		assertEquals(0, counter.count(1));
		assertEquals(1, counter.count(7));
		assertEquals(2, counter.count(17));
		assertEquals(3, counter.count(27));
		assertEquals(20, counter.count(99));
		assertEquals(38890, counter.count(77777));
	}

}
