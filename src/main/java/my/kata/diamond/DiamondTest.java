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
			return valueOf(ALPHABET.charAt(DiamondTest.Diamond.indexOf(letter)));
		}

		private static List<String> lastLineOf(char letter) {
			final List<String> lines = new ArrayList<>();
			if(DiamondTest.Diamond.indexOf(letter)<1) {
				return lines;
			}
			lines.add(DiamondTest.Diamond.stringOf(letter) + DiamondTest.Diamond.space(DiamondTest.Diamond.indexOf(letter) + DiamondTest.Diamond.indexOf(letter) - 1) + DiamondTest.Diamond.stringOf(letter));
			return lines;
		}

		private static String firstLineOf(char letter) {
			return DiamondTest.Diamond.space(DiamondTest.Diamond.indexOf(letter)) + DiamondTest.Diamond.stringOf('A') + DiamondTest.Diamond.space(DiamondTest.Diamond.indexOf(letter));
		}

		private static List<String> innerLinesOf(char letter) {
			final List<String> innerLines = new ArrayList<>();
			if(DiamondTest.Diamond.indexOf(letter)<2) {
				return innerLines;
			}
			for (int i = 1; i < DiamondTest.Diamond.indexOf(letter); i++) {
				final String actualLetter = valueOf(ALPHABET.charAt(i));
				final String outerSpaces = DiamondTest.Diamond.space(DiamondTest.Diamond.indexOf(letter) - i);
				final String innerSpaces = DiamondTest.Diamond.space((i - 1) * 2 + 1);
				innerLines.add(join(outerSpaces, actualLetter, innerSpaces, actualLetter, outerSpaces));
			}
			return innerLines;
		}

		public List<String> lines() {
			return lines;
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

		Diamond diamond = Diamond.of(letter);
		final List<String> lines = new ArrayList<>();

		lines.add(Diamond.firstLineOf(letter));
		lines.addAll(Diamond.innerLinesOf(letter));
		lines.addAll(Diamond.lastLineOf(letter));
		String result = Diamond.asString(diamond.lines());
		
		return result;
	}

}
