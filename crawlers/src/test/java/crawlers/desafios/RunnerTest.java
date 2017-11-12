package crawlers.desafios;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RunnerTest {

	@Test
	public void validateArgsTest() {
		assertFalse(Runner.validateArgs(null));
		assertFalse(Runner.validateArgs(new String[0]));
		assertFalse(Runner.validateArgs(new String[] {"cats,"}));
		assertFalse(Runner.validateArgs(new String[] {"cats", "nãoInt"}));
		assertFalse(Runner.validateArgs(new String[] {"cats;sports,", "true"}));

		assertTrue(Runner.validateArgs(new String[] {"cats;sports"}));
		assertTrue(Runner.validateArgs(new String[] {"worldnews", "10000"}));
	}
}
