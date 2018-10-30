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

	private final List<String> lines = new ArrayList<>();
	
	private final Lines upperHalf = new Lines();

	private Diamond(char letter) {
		List<String> firstLine = firstLineFor(letter);
		List<String> innerLines = innerLinesFor(letter);
		List<String> lastLine = lastLineFor(letter);

		upperHalf.add(Lines.of(firstLine));
		upperHalf.add(Lines.of(innerLines));
		upperHalf.add(Lines.of(lastLine));
		
		lines.addAll(firstLine);
		lines.addAll(innerLines);
		lines.addAll(lastLine);
		
		
	}

	public static Diamond of(char letter) {
		return new Diamond(letter);
	}

	@Override
	public String toString() {
		final List<String> reverse = Lists.reverse(lines);
		final List<String> allLines = new ArrayList<>();
		allLines.addAll(lines);
		allLines.addAll(reverse.subList(1, reverse.size()));
		return join(allLines, '\n');
	}

	private List<String> firstLineFor(char character) {
		final String letter = valueOf(alphabet.characterAt(0));
		final String outerSpaces = space(alphabet.indexOf(character));
		return asList(join(outerSpaces, letter, outerSpaces));
	}

	private List<String> innerLinesFor(char character) {
		if (alphabet.indexOf(character) < 2) {
			return emptyList();
		}
		final List<String> lines = new ArrayList<>();
		for (int i = 1; i < alphabet.indexOf(character); i++) {
			final String letter = valueOf(alphabet.characterAt(i));
			final String outerSpaces = space(alphabet.indexOf(character) - i);
			final String innerSpaces = space(2 * i - 1);
			lines.add(join(outerSpaces, letter, innerSpaces, letter, outerSpaces));
		}
		return lines;
	}

	private List<String> lastLineFor(char character) {
		if (alphabet.indexOf(character) < 1) {
			return emptyList();
		}
		final String letter = valueOf(character);
		final String innerSpaces = space(alphabet.indexOf(character) + alphabet.indexOf(character) - 1);
		return asList(join(letter, innerSpaces, letter));
	}

}