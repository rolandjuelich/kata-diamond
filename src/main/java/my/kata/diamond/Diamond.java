package my.kata.diamond;

import static java.lang.String.valueOf;
import static my.kata.diamond.text.Alphabet.space;

import my.kata.diamond.text.Alphabet;
import my.kata.diamond.text.Alphabet.Letter;
import my.kata.diamond.text.Line;
import my.kata.diamond.text.Lines;

public class Diamond {

	private static final Alphabet ALPHABET = Alphabet.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

	private final Lines model;

	private Diamond(char letter) {
		if (containsOnly(letter)) {
			this.model = Lines.of(shortestLineOf(letter));
		} else {
			this.model = shortestLineOf(letter)
					.add(growingLinesOf(letter))
					.add(widestLineOf(letter))
					.add(shrinkingLinesOf(letter))
					.add(shortestLineOf(letter));
		}
	}

	public static Diamond of(final Letter letter) {
		return new Diamond(letter.value());
	}

	public static Alphabet alphabet() {
		return ALPHABET;
	}

	@Override
	public String toString() {
		return model.asText();
	}

	private boolean containsOnly(char letter) {
		return alphabet().indexOf(letter) == 0;
	}

	private Lines shrinkingLinesOf(char letter) {
		return growingLinesOf(letter).reverse();
	}

	private Line shortestLineOf(char character) {
		final String letter = valueOf(alphabet().characterAt(0));
		final String outerSpaces = space(alphabet().indexOf(character));
		return Line.of(outerSpaces, letter, outerSpaces);
	}

	private Lines growingLinesOf(char character) {
		Lines lines = Lines.empty();
		for (int i = 1; i < alphabet().indexOf(character); i++) {
			final String letter = valueOf(alphabet().characterAt(i));
			final String outerSpaces = space(alphabet().indexOf(character) - i);
			final String innerSpaces = space(2 * i - 1);
			lines = lines.add(Line.of(outerSpaces, letter, innerSpaces, letter, outerSpaces));
		}
		return lines;
	}

	private Line widestLineOf(char character) {
		final String letter = valueOf(character);
		final String innerSpaces = space(2 * alphabet().indexOf(character) - 1);
		return Line.of(letter, innerSpaces, letter);
	}

}