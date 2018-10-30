package my.kata.diamond;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static my.kata.diamond.Alphabet.space;
import static org.apache.commons.lang3.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class Diamond {

	private final Alphabet alphabet = Alphabet.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

	private final Lines upperHalf;

	private Diamond(char letter) {
		Lines firstLine = firstLineFor(letter);
		Lines innerLines = innerLinesFor(letter);
		Lines lastLine = lastLineFor(letter);

		upperHalf = Lines.of(firstLine.add(innerLines.add(lastLine)).values());

	}

	public static Diamond of(char letter) {
		return new Diamond(letter);
	}

	@Override
	public String toString() {
		final List<String> reverse = Lists.reverse(lines());
		final List<String> allLines = new ArrayList<>();
		allLines.addAll(lines());
		allLines.addAll(reverse.subList(1, reverse.size()));
		return join(allLines, '\n');
	}

	private List<String> lines() {
		return upperHalf.values();
	}

	private Lines firstLineFor(char character) {
		final String letter = valueOf(alphabet.characterAt(0));
		final String outerSpaces = space(alphabet.indexOf(character));
		return Lines.of(asList(join(outerSpaces, letter, outerSpaces)));
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

	private Lines lastLineFor(char character) {
		if (alphabet.indexOf(character) < 1) {
			return Lines.empty();
		}
		final String letter = valueOf(character);
		final String innerSpaces = space(alphabet.indexOf(character) + alphabet.indexOf(character) - 1);
		return Lines.of(asList(join(letter, innerSpaces, letter)));
	}

}