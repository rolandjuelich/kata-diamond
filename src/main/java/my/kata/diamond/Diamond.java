package my.kata.diamond;

import static java.lang.String.valueOf;
import static my.kata.diamond.Alphabet.space;

public class Diamond {

	private final Alphabet alphabet = Alphabet.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

	private final Lines model;

	private Diamond(char letter) {
		final Lines topTriangle = shortestLineOf(letter).add(growingLinesOf(letter).add(widestLineOf(letter)));
		final Lines bottomTriangle = topTriangle.reverse().startingFromIndex(1);
		this.model = topTriangle.add(bottomTriangle);
	}

	public static Diamond of(char letter) {
		return new Diamond(letter);
	}

	@Override
	public String toString() {
		return model.asText();
	}

	private Line shortestLineOf(char character) {
		final String letter = valueOf(alphabet.characterAt(0));
		final String outerSpaces = space(alphabet.indexOf(character));
		return Line.of(outerSpaces, letter, outerSpaces);
	}

	private Lines growingLinesOf(char character) {
		if (alphabet.indexOf(character) < 2) {
			return Lines.empty();
		}
		Lines lines = Lines.empty();
		for (int i = 1; i < alphabet.indexOf(character); i++) {
			final String letter = valueOf(alphabet.characterAt(i));
			final String outerSpaces = space(alphabet.indexOf(character) - i);
			final String innerSpaces = space(2 * i - 1);
			lines = lines.add(Line.of(outerSpaces, letter, innerSpaces, letter, outerSpaces));
		}
		return lines;
	}

	private Line widestLineOf(char character) {
		if (alphabet.indexOf(character) < 1) {
			return Line.none();
		}
		final String letter = valueOf(character);
		final String innerSpaces = space(2 * alphabet.indexOf(character) - 1);
		return Line.of(letter, innerSpaces, letter);
	}

}