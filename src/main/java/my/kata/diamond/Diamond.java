package my.kata.diamond;

import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
		return space(indexOf(letter)) + stringOf('A') + space(indexOf(letter));
	}

	private List<String> innerLinesOf(char letter) {
		final List<String> innerLines = new ArrayList<>();
		if (indexOf(letter) < 2) {
			return innerLines;
		}
		for (int i = 1; i < indexOf(letter); i++) {
			final String actualLetter = valueOf(ALPHABET.charAt(i));
			final String outerSpaces = space(indexOf(letter) - i);
			final String innerSpaces = space((i - 1) * 2 + 1);
			innerLines.add(join(outerSpaces, actualLetter, innerSpaces, actualLetter, outerSpaces));
		}
		return innerLines;
	}

	private List<String> lastLineOf(char letter) {
		final List<String> lines = new ArrayList<>();
		if (indexOf(letter) < 1) {
			return lines;
		}
		lines.add(stringOf(letter) + space(indexOf(letter) + indexOf(letter) - 1) + stringOf(letter));
		return lines;
	}

	private String space(int times) {
		return StringUtils.repeat(StringUtils.SPACE, times);
	}

	private int indexOf(char letter) {
		return ALPHABET.indexOf(letter);
	}

	private String stringOf(char letter) {
		return valueOf(ALPHABET.charAt(indexOf(letter)));
	}

	@Override
	public String toString() {
		List<String> reverse = Lists.reverse(lines);
		List<String> completeLines = new ArrayList<>();
		completeLines.addAll(lines);
		completeLines.addAll(reverse.subList(1, reverse.size()));
		return join(completeLines, '\n');
	}

}