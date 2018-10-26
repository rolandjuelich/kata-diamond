package my.kata.diamond;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.repeat;

public class Diamond {

	private final String value;

	public Diamond(char suppliedLetter) {
		final StringBuilder diamond = new StringBuilder();
		for (int i = 1; i < possibleLetters().indexOf(suppliedLetter) + 1; i++) {
			diamond.append(createLine(i, suppliedLetter)).append("\n");
		}
		for (int i = possibleLetters().indexOf(suppliedLetter) + 1; i > 0; i--) {
			diamond.append(createLine(i, suppliedLetter));
			if (i > 1) {
				diamond.append("\n");
			}
		}
		this.value = diamond.toString();
	}

	@Override
	public String toString() {
		return value;
	}

	static String possibleLetters() {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}

	static int innerSpacesFor(char current) {
		int index = possibleLetters().indexOf(current);
		return index == 0 ? 0 : index * 2 - 1;
	}

	static int outerSpacesFor(char current, char supplied) {
		return possibleLetters().indexOf(supplied) - possibleLetters().indexOf(current);
	}

	static String createLine(int line, char diamondLetter) {
		final char lineChar = possibleLetters().charAt(line - 1);
		final String outer = repeat(SPACE, outerSpacesFor(lineChar, diamondLetter));
		final String inner = repeat(SPACE, innerSpacesFor(lineChar));

		if (line == 1) {
			return String.format("%s%s%s", outer, lineChar, outer);
		} else {
			return String.format("%s%s%s%s%s", outer, lineChar, inner, lineChar, outer);
		}

	}

}