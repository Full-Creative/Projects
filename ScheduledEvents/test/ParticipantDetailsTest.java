import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import generator.DataGenerator;
import model.ParticipantDetails;

import java.util.*;

public class ParticipantDetailsTest {

	@Test
	public void testGenerateParticipants1() {
		Set<ParticipantDetails> result = new HashSet<ParticipantDetails>();
		Set<ParticipantDetails> test = new HashSet<ParticipantDetails>();
		ParticipantDetails participant1 = new ParticipantDetails();
		participant1.setName("name");
		participant1.setEmail("email1@gmail.com");
		test.add(participant1);
		ParticipantDetails participant2 = new ParticipantDetails();
		participant2.setName("name");
		participant2.setEmail("email1@gmail.com");
		test.add(participant2);
		result = new DataGenerator().generateParticipants(2);

		// assertTrue(result.equals(test));
		assertNotEquals(test, result);
		// assertEquals(test.get(1).getEmail(),result.get(1).getEmail());
	}

	@Test
	public void testGenerateParticipants2() {
		Set<ParticipantDetails> result = new HashSet<ParticipantDetails>();
		Set<ParticipantDetails> test = new HashSet<ParticipantDetails>();
		ParticipantDetails participant1 = new ParticipantDetails();
		participant1.setName("name");
		participant1.setEmail("email1@gmail.com");
		test.add(participant1);
		ParticipantDetails participant2 = new ParticipantDetails();
		participant2.setName("name");
		participant2.setEmail("1");
		test.add(participant2);
		result = new DataGenerator().generateParticipants(2);

		// assertTrue(result.equals(test));
		assertNotEquals(result, test);
		// assertEquals(test.get(1).getEmail(),result.get(1).getEmail());
	}

	@Test
	public void testGenerateParticipants() {
		Set<ParticipantDetails> result = new HashSet<ParticipantDetails>();
		Set<ParticipantDetails> test = new HashSet<ParticipantDetails>();

		ParticipantDetails participant1 = new ParticipantDetails();
		participant1.setName("name");
		participant1.setEmail("email0@gmail.com");
		test.add(participant1);

		ParticipantDetails participant2 = new ParticipantDetails();
		participant2.setName("name");
		participant2.setEmail("email1@gmail.com");
		test.add(participant2);

		result = new DataGenerator().generateParticipants(2);
		for (ParticipantDetails p : result)
			System.out.println(p.getName() + " " + p.getEmail());
		for (ParticipantDetails p : test)
			System.out.println(p.getName() + " " + p.getEmail());

		System.out.println(test.hashCode());
		System.out.print(result.hashCode());
		// assertTrue(result.equals(test));
		assertEquals(test, result);
		// assertEquals(test.get(1).getEmail(),result.get(1).getEmail());
	}

}
