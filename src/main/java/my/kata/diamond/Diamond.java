package my.kata.diamond;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.repeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class Diamond {

	private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private final List<String> lines = new ArrayList<>();

	private Diamond(char letter) {
		lines.add(firstLineOf(letter));
		lines.addAll(innerLinesOf(letter));
		lines.addAll(lastLineOf(letter));
	}

	public static Diamond of(char letter) {
		return new Diamond(letter);
	}

	private String firstLineOf(char letter) {
		final String outerSpaces = space(indexOf(letter));
		final String actualLetter = stringOf('A');
		return join(outerSpaces, actualLetter, outerSpaces);
	}

	private List<String> innerLinesOf(char letter) {
		if (indexOf(letter) < 2) {
			return Collections.emptyList();
		}
		final List<String> innerLines = new ArrayList<>();
		for (int i = 1; i < indexOf(letter); i++) {
			final String actualLetter = valueOf(ALPHABET.charAt(i));
			final String outerSpaces = space(indexOf(letter) - i);
			final String innerSpaces = space((i - 1) * 2 + 1);
			innerLines.add(join(outerSpaces, actualLetter, innerSpaces, actualLetter, outerSpaces));
		}
		return innerLines;
	}

	private List<String> lastLineOf(char letter) {
		if (indexOf(letter) < 1) {
			return Collections.emptyList();
		}
		final String actualLetter = stringOf(letter);
		final String innerSpaces = space(indexOf(letter) + indexOf(letter) - 1);
		return asList(join(actualLetter,innerSpaces,actualLetter));
	}

	private String space(int times) {
		return repeat(SPACE, times);
	}

	private int indexOf(char letter) {
		return ALPHABET.indexOf(letter);
	}

	private String stringOf(char letter) {
		return valueOf(ALPHABET.charAt(indexOf(letter)));
	}

	@Override
	public String toString() {
		final List<String> reverse = Lists.reverse(lines);
		final List<String> completeLines = new ArrayList<>();
		completeLines.addAll(lines);
		completeLines.addAll(reverse.subList(1, reverse.size()));
		return join(completeLines, '\n');
	}

}