import static org.junit.Assert.*;

import org.junit.Test;

public class RightIsoscelesTest {

	@Test
	public void testDraw() {
		String result = new RightIsosceles().draw(3);
		assertEquals("*\n**\n***\n", result);
	}

	@Test
	public void testDraw1() {
		String result = new RightIsosceles().draw(4);
		assertEquals("*\n**\n***\n****\n", result);
	}

	@Test
	public void testDraw2() {
		String result = new RightIsosceles().draw(5);
		assertEquals("*\n**\n***\n****\n*****\n", result);
	}

	@Test
	public void testDraw3() {
		String result = new RightIsosceles().draw(6);
		assertNotEquals("*\n**\n***\n", result);
	}

}
