package my.kata.diamond;

import static java.lang.String.valueOf;
import static my.kata.diamond.Alphabet.space;
import static org.apache.commons.lang3.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

public class Diamond {

	private final Alphabet alphabet = Alphabet.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

	private final Lines upperHalf;

	private Diamond(char letter) {
		upperHalf = firstLineFor(letter).add(innerLinesFor(letter).add(lastLineFor(letter)));
	}

	public static Diamond of(char letter) {
		return new Diamond(letter);
	}

	@Override
	public String toString() {
		return upperHalf.add(upperHalf.reverse().startingFromIndex(1)).asText();
	}

	private Line firstLineFor(char character) {
		final String letter = valueOf(alphabet.characterAt(0));
		final String outerSpaces = space(alphabet.indexOf(character));
		return Line.of(outerSpaces, letter, outerSpaces);
	}

	private Lines innerLinesFor(char character) {
		if (alphabet.indexOf(character) < 2) {
			return Lines.empty();
		}
		final List<String> lines = new ArrayList<>();
		for (int i = 1; i < alphabet.indexOf(character); i++) {
			final String letter = valueOf(alphabet.characterAt(i));
			final String outerSpaces = space(alphabet.indexOf(character) - i);
			final String innerSpaces = space(2 * i - 1);
			lines.add(join(outerSpaces, letter, innerSpaces, letter, outerSpaces));
		}
		return Lines.of(lines);
	}

	private Line lastLineFor(char character) {
		if (alphabet.indexOf(character) < 1) {
			return Line.none();
		}
		final String letter = valueOf(character);
		final String innerSpaces = space(alphabet.indexOf(character) + alphabet.indexOf(character) - 1);
		return Line.of(letter, innerSpaces, letter);
	}

}