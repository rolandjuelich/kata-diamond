package my.kata.diamond;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.join;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.collect.Lists;

public class DiamondTest {

	@Test
	public void shouldCreateDiamond_A() {
		assertThat(diamondFor('A')).isEqualTo("A");
	}

	@Test
	public void shouldCreateDiamond_B() {
		assertThat(diamondFor('B')).isEqualTo(new StringBuilder()
				.append(" A ").append("\n")
				.append("B B").append("\n")
				.append(" A ").toString());
	}

	@Test
	public void shouldCreateDiamond_C() {
		assertThat(diamondFor('C')).isEqualTo(new StringBuilder()
				.append("  A  ").append("\n")
				.append(" B B ").append("\n")
				.append("C   C").append("\n")
				.append(" B B ").append("\n")
				.append("  A  ").toString());
	}

	@Test
	public void shouldCreateDiamond_D() {
		assertThat(diamondFor('D')).isEqualTo(new StringBuilder()
				.append("   A   ").append("\n")
				.append("  B B  ").append("\n")
				.append(" C   C ").append("\n")
				.append("D     D").append("\n")
				.append(" C   C ").append("\n")
				.append("  B B  ").append("\n")
				.append("   A   ").toString());
	}

	private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private String diamondFor(char letter) {
		if (letter == 'A') {
			return asString(asList(firstLineOf(letter)));
		}

		if (letter == 'B') {
			return asString(asList(firstLineOf(letter), lastLineOf(letter)));
		}

		if (letter == 'C') {
			List<String> elements = new ArrayList<>();
			elements.add(firstLineOf(letter));
			elements.addAll(innerLinesOf(letter));
			elements.add(lastLineOf(letter));
			return asString(elements);
		}

		if (letter == 'D') {
			List<String> elements = new ArrayList<>();
			elements.add(firstLineOf(letter));
			elements.addAll(innerLinesOf(letter));
			elements.add(lastLineOf(letter));
			return asString(elements);
		}
		return null;
	}

	private List<String> innerLinesOf(char letter) {
		final List<String> innerLines = new ArrayList<>();
		for (int i = 1; i < indexOf(letter); i++) {
			final String actualLetter = valueOf(ALPHABET.charAt(i));
			final String outerSpaces = space(indexOf(letter) - i);
			final String innerSpaces = space((i - 1) * 2 + 1);
			innerLines.add(join(outerSpaces, actualLetter, innerSpaces, actualLetter, outerSpaces));
		}
		return innerLines;
	}

	private String firstLineOf(char letter) {
		return space(indexOf(letter)) + stringOf('A') + space(indexOf(letter));
	}

	private String lastLineOf(char letter) {
		return stringOf(letter) + space(indexOf(letter) + indexOf(letter) - 1) + stringOf(letter);
	}

	private String stringOf(char letter) {
		return valueOf(ALPHABET.charAt(indexOf(letter)));
	}

	private int indexOf(char letter) {
		return ALPHABET.indexOf(letter);
	}

	private String space(int times) {
		return StringUtils.repeat(StringUtils.SPACE, times);
	}

	private String asString(List<String> baseLines) {
		List<String> b2a = Lists.reverse(baseLines);
		List<String> lines = new ArrayList<>();
		lines.addAll(baseLines);
		lines.addAll(b2a.subList(1, b2a.size()));
		String result = join(lines, '\n');
		return result;
	}

}
