package my.kata.diamond;

import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringUtils.join;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.collect.Lists;

public class DiamondTest {

	public static class Diamond {

		private final char supplied;
		private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		private Diamond(char supplied) {
			this.supplied = supplied;
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

		private static String space(int times) {
			return StringUtils.repeat(StringUtils.SPACE, times);
		}

		private static int indexOf(char letter) {
			return ALPHABET.indexOf(letter);
		}

	}

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

	private String diamondFor(char letter) {

		final List<String> lines = new ArrayList<>();

		lines.add(firstLineOf(letter));
		lines.addAll(innerLinesOf(letter));
		lines.addAll(lastLineOf(letter));
		String result = Diamond.asString(lines);
		
		Diamond diamond = Diamond.of(letter);
		return result;
	}

	private static List<String> innerLinesOf(char letter) {
		final List<String> innerLines = new ArrayList<>();
		if(Diamond.indexOf(letter)<2) {
			return innerLines;
		}
		for (int i = 1; i < Diamond.indexOf(letter); i++) {
			final String actualLetter = valueOf(Diamond.ALPHABET.charAt(i));
			final String outerSpaces = Diamond.space(Diamond.indexOf(letter) - i);
			final String innerSpaces = Diamond.space((i - 1) * 2 + 1);
			innerLines.add(join(outerSpaces, actualLetter, innerSpaces, actualLetter, outerSpaces));
		}
		return innerLines;
	}

	private static String firstLineOf(char letter) {
		return Diamond.space(Diamond.indexOf(letter)) + stringOf('A') + Diamond.space(Diamond.indexOf(letter));
	}

	private static List<String> lastLineOf(char letter) {
		final List<String> lines = new ArrayList<>();
		if(Diamond.indexOf(letter)<1) {
			return lines;
		}
		lines.add(stringOf(letter) + Diamond.space(Diamond.indexOf(letter) + Diamond.indexOf(letter) - 1) + stringOf(letter));
		return lines;
	}

	private static String stringOf(char letter) {
		return valueOf(Diamond.ALPHABET.charAt(Diamond.indexOf(letter)));
	}

}
