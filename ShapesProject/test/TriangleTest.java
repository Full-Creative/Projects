import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

//@RunWith(JUnit4.class)
public class TriangleTest {

	@Test
	public void testDraw() {
		String result = new Triangle().draw(3);
		assertEquals("   *\n  ***\n *****\n", result);
	}

	@Test
	public void testDraw1() {
		String result = new Triangle().draw(4);
		System.out.print(result);
		assertEquals("    *\n   ***\n  *****\n *******\n", result);
	}

	@Test
	public void testDraw2() {
		String result = new Triangle().draw(5);
		assertEquals("     *\n    ***\n   *****\n  *******\n *********\n", result);
	}

	@Test
	public void testDraw3() {
		String result = new Triangle().draw(7);
		assertNotEquals("     *\n    ***\n   *****\n  *******\n *********\n", result);
	}

}
