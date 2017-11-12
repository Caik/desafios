package strings.desafio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RunnerTest {

	@Test
	public void validateArgsTest() {
		assertFalse(Runner.validateArgs(null));
		assertFalse(Runner.validateArgs(new String[0]));
		assertFalse(Runner.validateArgs(new String[] {"40"}));
		assertFalse(Runner.validateArgs(new String[] {"40", "true"}));
		assertFalse(Runner.validateArgs(new String[] {"notInt", "true", "Texto a ser justificado"}));
		assertFalse(Runner.validateArgs(new String[] {"0", "true", "Texto a ser justificado"}));
		assertFalse(Runner.validateArgs(new String[] {"-1", "true", "Texto a ser justificado"}));
		assertFalse(Runner.validateArgs(new String[] {"40", "notBoolean", "Texto a ser justificado"}));

		assertTrue(Runner.validateArgs(new String[] {"40", "true", "Texto a ser justificado"}));
		assertTrue(Runner.validateArgs(new String[] {"1", "false", "Texto para teste mais longo do que o texto utilizado anteriormente"}));
		assertTrue(Runner.validateArgs(new String[] {"1", "false", ""}));
	}

}
