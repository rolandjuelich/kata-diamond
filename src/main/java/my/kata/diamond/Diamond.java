package my.kata.diamond;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.repeat;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class Diamond {

	private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private final List<String> lines = new ArrayList<>();

	private Diamond(char letter) {
		lines.addAll(firstLineFor(letter));
		lines.addAll(innerLinesFor(letter));
		lines.addAll(lastLineFor(letter));
	}

	public static Diamond of(char letter) {
		return new Diamond(letter);
	}

	@Override
	public String toString() {
		final List<String> reverse = Lists.reverse(lines);
		final List<String> completeLines = new ArrayList<>();
		completeLines.addAll(lines);
		completeLines.addAll(reverse.subList(1, reverse.size()));
		return join(completeLines, '\n');
	}

	private List<String> firstLineFor(char character) {
		final String letter = letter(0);
		final String outerSpaces = space(indexOf(character));
		return asList(join(outerSpaces, letter, outerSpaces));
	}

	private List<String> innerLinesFor(char character) {
		if (indexOf(character) < 2) {
			return emptyList();
		}
		final List<String> innerLines = new ArrayList<>();
		for (int i = 1; i < indexOf(character); i++) {
			final String letter = letter(i);
			final String outerSpaces = space(indexOf(character) - i);
			final String innerSpaces = space(2 * i - 1);
			innerLines.add(join(outerSpaces, letter, innerSpaces, letter, outerSpaces));
		}
		return innerLines;
	}

	private String letter(int alphabetIndex) {
		return valueOf(ALPHABET.charAt(alphabetIndex));
	}

	private List<String> lastLineFor(char character) {
		if (indexOf(character) < 1) {
			return emptyList();
		}
		final String letter = valueOf(character);
		final String innerSpaces = space(indexOf(character) + indexOf(character) - 1);
		return asList(join(letter, innerSpaces, letter));
	}

	private String space(int times) {
		return repeat(SPACE, times);
	}

	private int indexOf(char character) {
		return ALPHABET.indexOf(character);
	}

}