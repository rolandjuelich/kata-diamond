package my.kata.diamond;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.repeat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DiamondConstructionTest {

	public class Diamond {

		private final String value;

		public Diamond(char suppliedLetter) {
			this.value = new StringBuilder()
					.append("    A    ").append("\n")
					.append("   B B   ").append("\n")
					.append("  C   C  ").append("\n")
					.append(" D     D ").append("\n")
					.append("E       E").append("\n")
					.append(" D     D ").append("\n")
					.append("  C   C  ").append("\n")
					.append("   B B   ").append("\n")
					.append("    A    ").toString();
		}

		@Override
		public String toString() {
			return value;
		}

	}

	@Test
	public void defineAllowedLetters() {
		assertThat(allowedLetters().charAt(0)).isEqualTo('A');
		assertThat(allowedLetters().charAt(1)).isEqualTo('B');
		assertThat(allowedLetters().charAt(2)).isEqualTo('C');
		assertThat(allowedLetters().charAt(3)).isEqualTo('D');
		assertThat(allowedLetters().charAt(4)).isEqualTo('E');
		assertThat(allowedLetters().charAt(5)).isEqualTo('F');
		assertThat(allowedLetters().charAt(6)).isEqualTo('G');
		assertThat(allowedLetters().charAt(7)).isEqualTo('H');
		assertThat(allowedLetters().charAt(8)).isEqualTo('I');
		assertThat(allowedLetters().charAt(9)).isEqualTo('J');
		assertThat(allowedLetters().charAt(10)).isEqualTo('K');
		assertThat(allowedLetters().charAt(11)).isEqualTo('L');
		assertThat(allowedLetters().charAt(12)).isEqualTo('M');
		assertThat(allowedLetters().charAt(13)).isEqualTo('N');
		assertThat(allowedLetters().charAt(14)).isEqualTo('O');
		assertThat(allowedLetters().charAt(15)).isEqualTo('P');
		assertThat(allowedLetters().charAt(16)).isEqualTo('Q');
		assertThat(allowedLetters().charAt(17)).isEqualTo('R');
		assertThat(allowedLetters().charAt(18)).isEqualTo('S');
		assertThat(allowedLetters().charAt(19)).isEqualTo('T');
		assertThat(allowedLetters().charAt(20)).isEqualTo('U');
		assertThat(allowedLetters().charAt(21)).isEqualTo('V');
		assertThat(allowedLetters().charAt(22)).isEqualTo('W');
		assertThat(allowedLetters().charAt(23)).isEqualTo('X');
		assertThat(allowedLetters().charAt(24)).isEqualTo('Y');
		assertThat(allowedLetters().charAt(25)).isEqualTo('Z');
	}

	@Test
	public void calculateLeadingWhitespaces() {
		assertThat(leadingWhitespacesFor('A', 'A')).isEqualTo(0);
		assertThat(leadingWhitespacesFor('B', 'B')).isEqualTo(0);
		assertThat(leadingWhitespacesFor('C', 'C')).isEqualTo(0);
		assertThat(leadingWhitespacesFor('D', 'D')).isEqualTo(0);
		assertThat(leadingWhitespacesFor('E', 'E')).isEqualTo(0);

		assertThat(leadingWhitespacesFor('A', 'B')).isEqualTo(1);
		assertThat(leadingWhitespacesFor('B', 'C')).isEqualTo(1);
		assertThat(leadingWhitespacesFor('C', 'D')).isEqualTo(1);
		assertThat(leadingWhitespacesFor('D', 'E')).isEqualTo(1);

		assertThat(leadingWhitespacesFor('B', 'D')).isEqualTo(2);
		assertThat(leadingWhitespacesFor('A', 'C')).isEqualTo(2);
		assertThat(leadingWhitespacesFor('C', 'E')).isEqualTo(2);

		assertThat(leadingWhitespacesFor('A', 'D')).isEqualTo(3);
		assertThat(leadingWhitespacesFor('B', 'E')).isEqualTo(3);

		assertThat(leadingWhitespacesFor('A', 'E')).isEqualTo(4);
	}

	@Test
	public void calculateInnerWhitespaces() {
		assertThat(innerWhitespacesFor('A')).isEqualTo(0);

		assertThat(innerWhitespacesFor('B')).isEqualTo(1);
		assertThat(innerWhitespacesFor('B')).isEqualTo(1);
		assertThat(innerWhitespacesFor('B')).isEqualTo(1);

		assertThat(innerWhitespacesFor('C')).isEqualTo(3);
		assertThat(innerWhitespacesFor('C')).isEqualTo(3);
		assertThat(innerWhitespacesFor('C')).isEqualTo(3);

		assertThat(innerWhitespacesFor('D')).isEqualTo(5);
		assertThat(innerWhitespacesFor('D')).isEqualTo(5);

		assertThat(innerWhitespacesFor('E')).isEqualTo(7);
	}

	@Test
	public void createLines() {
		assertThat(createLine(1, 'A')).isEqualTo("A");
		assertThat(createLine(1, 'B')).isEqualTo(" A ");
		assertThat(createLine(1, 'C')).isEqualTo("  A  ");

		assertThat(createLine(2, 'B')).isEqualTo("B B");
		assertThat(createLine(2, 'C')).isEqualTo(" B B ");
		assertThat(createLine(2, 'D')).isEqualTo("  B B  ");
		assertThat(createLine(2, 'E')).isEqualTo("   B B   ");

		assertThat(createLine(3, 'C')).isEqualTo("C   C");
		assertThat(createLine(3, 'D')).isEqualTo(" C   C ");
		assertThat(createLine(3, 'E')).isEqualTo("  C   C  ");

		assertThat(createLine(4, 'D')).isEqualTo("D     D");
		assertThat(createLine(4, 'E')).isEqualTo(" D     D ");

		assertThat(createLine(5, 'E')).isEqualTo("E       E");

	}

	@Test
	public void createDiamondForE() {
		// given
		final char suppliedLetter = 'E';

		// when
		final String diamond = new Diamond(suppliedLetter).toString();

		// then
		assertThat(diamond).isEqualTo(new StringBuilder()
				.append("    A    ").append("\n")
				.append("   B B   ").append("\n")
				.append("  C   C  ").append("\n")
				.append(" D     D ").append("\n")
				.append("E       E").append("\n")
				.append(" D     D ").append("\n")
				.append("  C   C  ").append("\n")
				.append("   B B   ").append("\n")
				.append("    A    ").toString());

	}

	private String createLine(int line, char diamondLetter) {
		final char lineChar = allowedLetters().charAt(line - 1);
		final String outer = repeat(SPACE, leadingWhitespacesFor(lineChar, diamondLetter));
		final String inner = repeat(SPACE, innerWhitespacesFor(lineChar));

		if (line == 1) {
			return String.format("%s%s%s", outer, lineChar, outer);
		} else {
			return String.format("%s%s%s%s%s", outer, lineChar, inner, lineChar, outer);
		}

	}

	private int innerWhitespacesFor(char current) {
		return allowedLetters().indexOf(current) == 0 ? 0
				: allowedLetters().indexOf(current) + allowedLetters().indexOf(current) - 1;
	}

	private int leadingWhitespacesFor(char current, char supplied) {
		return allowedLetters().indexOf(supplied) - allowedLetters().indexOf(current);
	}

	private String allowedLetters() {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
}
