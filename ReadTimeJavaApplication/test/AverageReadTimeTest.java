import static org.junit.Assert.*;

import org.junit.Test;

public class AverageReadTimeTest {

	@Test
	public void testCalculateTime() {
		assertEquals(1.0, new AverageReadTime().calculateTime(200),0.001);
	}
	@Test
	public void testCalculateTime1() {
		assertEquals(2.0, new AverageReadTime().calculateTime(400),0.001);
	}

}
