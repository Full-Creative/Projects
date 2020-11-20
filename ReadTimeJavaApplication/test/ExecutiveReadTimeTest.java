import static org.junit.Assert.*;

import org.junit.Test;

public class ExecutiveReadTimeTest {

	@Test
	public void testCalculateTime() {
		assertEquals(1.0, new ExecutiveReadTime().calculateTime(300),0.001);
	}
	@Test
	public void testCalculateTime1() {
		assertEquals(2.0, new ExecutiveReadTime().calculateTime(600),0.001);
	}
	@Test
	public void testCalculateTime2() {
		assertNotEquals(5.0, new ExecutiveReadTime().calculateTime(300),0.001);
	}
	

}
