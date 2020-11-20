import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SquareTest {

	@Test
	public void testDraw() {
		String t = "*\n";
		String result = new Square().draw(1);
		assertEquals(t, result);
	}

	@Test
	public void testDraw1() {
		String t = "***\n***\n***\n";
		String result = new Square().draw(3);
		assertEquals(t, result);
	}

	@Test
	public void testDraw2() {
		String t = "*****\n*****\n*****\n*****\n*****\n";
		String result = new Square().draw(5);
		assertEquals(t, result);
	}

	@Test
	public void testDraw3() {
		String t = "*****\n*****\n*****\n*****\n*****\n*****\n";
		String result = new Square().draw(5);
		assertNotEquals(t, result);
	}

}
