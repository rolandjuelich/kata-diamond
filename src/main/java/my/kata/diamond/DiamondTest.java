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

			String lineB = space(1) + valueOf(ALPHABET.charAt(1)) + space(1) + valueOf(ALPHABET.charAt(1)) + space(1);

			return asString(asList(firstLineOf(letter), lineB, lastLineOf(letter)));
		}

		if (letter == 'D') {

			String lineB = space(2) + valueOf(ALPHABET.charAt(1)) + space(1) + valueOf(ALPHABET.charAt(1)) + space(2);
			String lineC = space(1) + valueOf(ALPHABET.charAt(2)) + space(3) + valueOf(ALPHABET.charAt(2)) + space(1);

			return asString(asList(firstLineOf(letter), lineB, lineC, lastLineOf(letter)));
		}
		return null;
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
