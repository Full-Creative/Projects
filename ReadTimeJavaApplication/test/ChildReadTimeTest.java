import static org.junit.Assert.*;

import org.junit.Test;

public class ChildReadTimeTest {

	@Test
	public void testCalculateTime() {
		assertEquals(2.0, new ChildReadTime().calculateTime(200),0.001);
	}
	@Test
	public void testCalculateTime1() {
		assertEquals(1.0, new ChildReadTime().calculateTime(100),0.001);
	}
	@Test
	public void testCalculateTime2() {
		assertEquals(4.0, new ChildReadTime().calculateTime(400),0.001);
	}
	@Test
	public void testCalculateTime3() {
		assertNotEquals(2.0, new ChildReadTime().calculateTime(300),0.001);
	}

}
