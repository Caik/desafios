package strings.desafios;

import java.util.ArrayList;
import java.util.List;

public class TextFormatter {

	private int numLimit;

	private boolean justify;

	private String text = "";

	private List<String> result = new ArrayList<String>();

	public int getNumLimit() {
		return numLimit;
	}

	public void setNumLimit(int numLimit) {
		this.numLimit = numLimit;
	}

	public boolean isJustify() {
		return justify;
	}

	public void setJustify(boolean justify) {
		this.justify = justify;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	public List<String> format() {
		String[] words = this.text.split(" +");
		String buffer = "";

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > this.numLimit) {
				continue;
			}

			if (words[i].length() + buffer.length() + 1 > this.numLimit) {
				this.result.add(buffer);
				buffer = "";
			}

			buffer += " " + words[i];
			buffer = buffer.trim();
		}

		if (buffer.length() > 0) {
			this.result.add(buffer);
		}

		if (this.isJustify()) {
			justifiyText();
		}

		return this.result;
	}

	private void justifiyText() {
		List<String> result = new ArrayList<String>();

		for (String line : this.result) {
			int remainLength = this.numLimit - line.length();
			String[] bufferWords = line.split(" +");
			int numWords = bufferWords.length;
			int numSpaces = remainLength / numWords;
			int remainSpaces = remainLength % numWords;

			String newBuffer = "";

			for (int j = 0; j < numWords; j++) {
				int paddingLength = numSpaces + 1;
				if (remainSpaces > 0) {
					paddingLength += 1;
					remainSpaces--;
				}
				newBuffer += bufferWords[j] + String.format("%" + paddingLength + "s", "");
			}

			newBuffer = newBuffer.trim();

			remainSpaces = this.numLimit - newBuffer.length();
			String leftPadding = "";

			if (remainSpaces > 0) {
				leftPadding = String.format("%" + remainSpaces + "s", "");
			}

			result.add(leftPadding + newBuffer);
		}

		this.result = result;
	}

}
