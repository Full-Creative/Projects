import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.jupiter.api.Test;

class LeftIsoscelesTest {

	@Test
	void testDraw() {
		assertEquals("   *\n  **\n ***\n", new LeftIsosceles().draw(3));
	}

	@Test
	void testDraw1() {
		assertEquals("    *\n   **\n  ***\n ****\n", new LeftIsosceles().draw(4));
	}

	@Test
	void testDraw2() {
		assertEquals("     *\n    **\n   ***\n  ****\n *****\n", new LeftIsosceles().draw(5));
	}

	@Test
	void testDraw3() {
		assertNotEquals("    *\n   **\n  ***\n ****\n", new LeftIsosceles().draw(6));
	}

}
