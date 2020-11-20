import static org.junit.Assert.*;
import org.junit.Test;

public class WordCounterTest {

	@Test
	public void testCountWords() {
		assertEquals(12, new WordCounter().countWords("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));
	}
	@Test
	public void testCountWords1() {
		assertEquals(5, new WordCounter().countWords("Lorem Ipsum is simply dummy"));
	}
	@Test
	public void testCountWords2() {
		assertEquals(10, new WordCounter().countWords("Lorem Ipsum is simply dummy Lorem Ipsum is simply dummy"));
	}
	@Test
	public void testCountWords3() {
		assertNotEquals(20, new WordCounter().countWords("Lorem Ipsum is simply dummy Lorem Ipsum is simply dummy"));
	}
	@Test
	public void testCountWords4() {
		assertNotEquals(0, new WordCounter().countWords(""));
	}

}
