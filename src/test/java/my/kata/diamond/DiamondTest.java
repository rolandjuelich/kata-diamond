package my.kata.diamond;

import static my.kata.diamond.Diamond.createLine;
import static my.kata.diamond.Diamond.innerSpacesFor;
import static my.kata.diamond.Diamond.outerSpacesFor;
import static my.kata.diamond.Diamond.possibleLetters;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DiamondTest {

	@Test
	public void defineAllowedLetters() {
		assertThat(possibleLetters().charAt(0)).isEqualTo('A');
		assertThat(possibleLetters().charAt(1)).isEqualTo('B');
		assertThat(possibleLetters().charAt(2)).isEqualTo('C');
		assertThat(possibleLetters().charAt(3)).isEqualTo('D');
		assertThat(possibleLetters().charAt(4)).isEqualTo('E');
		assertThat(possibleLetters().charAt(5)).isEqualTo('F');
		assertThat(possibleLetters().charAt(6)).isEqualTo('G');
		assertThat(possibleLetters().charAt(7)).isEqualTo('H');
		assertThat(possibleLetters().charAt(8)).isEqualTo('I');
		assertThat(possibleLetters().charAt(9)).isEqualTo('J');
		assertThat(possibleLetters().charAt(10)).isEqualTo('K');
		assertThat(possibleLetters().charAt(11)).isEqualTo('L');
		assertThat(possibleLetters().charAt(12)).isEqualTo('M');
		assertThat(possibleLetters().charAt(13)).isEqualTo('N');
		assertThat(possibleLetters().charAt(14)).isEqualTo('O');
		assertThat(possibleLetters().charAt(15)).isEqualTo('P');
		assertThat(possibleLetters().charAt(16)).isEqualTo('Q');
		assertThat(possibleLetters().charAt(17)).isEqualTo('R');
		assertThat(possibleLetters().charAt(18)).isEqualTo('S');
		assertThat(possibleLetters().charAt(19)).isEqualTo('T');
		assertThat(possibleLetters().charAt(20)).isEqualTo('U');
		assertThat(possibleLetters().charAt(21)).isEqualTo('V');
		assertThat(possibleLetters().charAt(22)).isEqualTo('W');
		assertThat(possibleLetters().charAt(23)).isEqualTo('X');
		assertThat(possibleLetters().charAt(24)).isEqualTo('Y');
		assertThat(possibleLetters().charAt(25)).isEqualTo('Z');
	}

	@Test
	public void calculateLeadingWhitespaces() {
		assertThat(outerSpacesFor('A', 'A')).isEqualTo(0);
		assertThat(outerSpacesFor('B', 'B')).isEqualTo(0);
		assertThat(outerSpacesFor('C', 'C')).isEqualTo(0);
		assertThat(outerSpacesFor('D', 'D')).isEqualTo(0);
		assertThat(outerSpacesFor('E', 'E')).isEqualTo(0);

		assertThat(outerSpacesFor('A', 'B')).isEqualTo(1);
		assertThat(outerSpacesFor('B', 'C')).isEqualTo(1);
		assertThat(outerSpacesFor('C', 'D')).isEqualTo(1);
		assertThat(outerSpacesFor('D', 'E')).isEqualTo(1);

		assertThat(outerSpacesFor('B', 'D')).isEqualTo(2);
		assertThat(outerSpacesFor('A', 'C')).isEqualTo(2);
		assertThat(outerSpacesFor('C', 'E')).isEqualTo(2);

		assertThat(outerSpacesFor('A', 'D')).isEqualTo(3);
		assertThat(outerSpacesFor('B', 'E')).isEqualTo(3);

		assertThat(outerSpacesFor('A', 'E')).isEqualTo(4);
	}

	@Test
	public void calculateInnerWhitespaces() {
		assertThat(innerSpacesFor('A')).isEqualTo(0);

		assertThat(innerSpacesFor('B')).isEqualTo(1);
		assertThat(innerSpacesFor('B')).isEqualTo(1);
		assertThat(innerSpacesFor('B')).isEqualTo(1);

		assertThat(innerSpacesFor('C')).isEqualTo(3);
		assertThat(innerSpacesFor('C')).isEqualTo(3);
		assertThat(innerSpacesFor('C')).isEqualTo(3);

		assertThat(innerSpacesFor('D')).isEqualTo(5);
		assertThat(innerSpacesFor('D')).isEqualTo(5);

		assertThat(innerSpacesFor('E')).isEqualTo(7);
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
}
