package strings.desafio;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TextFormatterTest {

	private int numLimit;

	private String text = "";

	public TextFormatterTest() {
		this.numLimit = 40;
		text += "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
		text += "Risus sed vulputate odio ut enim blandit volutpat maecenas. At lectus urna duis convallis convallis tellus. Turpis egestas ";
		text += "pretium aenean pharetra magna ac placerat vestibulum. Magna fermentum iaculis eu non diam phasellus vestibulum. Etiam tempor orci eu lobortis.";
	}

	@Test
	public void formatText() {
		TextFormatter textFormater = new TextFormatter();

		textFormater.setNumLimit(this.numLimit);
		textFormater.setJustify(false);
		textFormater.setText(this.text);

		List<String> result = textFormater.format();

		for (String line : result) {
			assertTrue(line.length() <= this.numLimit);
		}
	}

	@Test
	public void formatJustifyText() {
		TextFormatter textFormater = new TextFormatter();

		textFormater.setNumLimit(this.numLimit);
		textFormater.setJustify(true);
		textFormater.setText(this.text);

		List<String> result = textFormater.format();

		for (String line : result) {
			assertTrue(line.length() == this.numLimit);
		}
	}

}
