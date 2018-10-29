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

		lines.add(Diamond.firstLineOf(letter));
		lines.addAll(Diamond.innerLinesOf(letter));
		lines.addAll(Diamond.lastLineOf(letter));
	}

	public static Diamond of(char letter) {
		return new Diamond(letter);
	}

	private static String asString(List<String> baseLines) {
		List<String> b2a = Lists.reverse(baseLines);
		List<String> lines = new ArrayList<>();
		lines.addAll(baseLines);
		lines.addAll(b2a.subList(1, b2a.size()));
		String result = join(lines, '\n');
		return result;
	}

	static String space(int times) {
		return StringUtils.repeat(StringUtils.SPACE, times);
	}

	static int indexOf(char letter) {
		return ALPHABET.indexOf(letter);
	}

	static String stringOf(char letter) {
		return valueOf(ALPHABET.charAt(Diamond.indexOf(letter)));
	}

	private static List<String> lastLineOf(char letter) {
		final List<String> lines = new ArrayList<>();
		if(Diamond.indexOf(letter)<1) {
			return lines;
		}
		lines.add(Diamond.stringOf(letter) + Diamond.space(Diamond.indexOf(letter) + Diamond.indexOf(letter) - 1) + Diamond.stringOf(letter));
		return lines;
	}

	private static String firstLineOf(char letter) {
		return Diamond.space(Diamond.indexOf(letter)) + Diamond.stringOf('A') + Diamond.space(Diamond.indexOf(letter));
	}

	private static List<String> innerLinesOf(char letter) {
		final List<String> innerLines = new ArrayList<>();
		if(Diamond.indexOf(letter)<2) {
			return innerLines;
		}
		for (int i = 1; i < Diamond.indexOf(letter); i++) {
			final String actualLetter = valueOf(ALPHABET.charAt(i));
			final String outerSpaces = Diamond.space(Diamond.indexOf(letter) - i);
			final String innerSpaces = Diamond.space((i - 1) * 2 + 1);
			innerLines.add(join(outerSpaces, actualLetter, innerSpaces, actualLetter, outerSpaces));
		}
		return innerLines;
	}

	@Override
	public String toString() {
		return asString(lines);
	}
	
}