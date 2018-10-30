package my.kata.diamond;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import my.kata.diamond.text.Alphabet.Letter;

public class DiamondTest {

	@Test
	public void shouldCreateDiamond_A() {
		// given
		final Letter letterA = Diamond.alphabet().letter('A');

		// when
		final Diamond diamond = Diamond.of(letterA);

		// then
		assertThat(diamond.toString()).isEqualTo("A");
	}

	@Test
	public void shouldCreateDiamond_B() {
		// given
		final Letter letterB = Diamond.alphabet().letter('B');

		// when
		final Diamond diamond = Diamond.of(letterB);

		// then
		assertThat(diamond.toString()).isEqualTo(new StringBuilder()
				.append(" A ").append("\n")
				.append("B B").append("\n")
				.append(" A ").toString());
	}

	@Test
	public void shouldCreateDiamond_C() {
		// given
		final Letter letterC = Diamond.alphabet().letter('C');

		// when
		final Diamond diamond = Diamond.of(letterC);

		// then
		assertThat(diamond.toString()).isEqualTo(new StringBuilder()
				.append("  A  ").append("\n")
				.append(" B B ").append("\n")
				.append("C   C").append("\n")
				.append(" B B ").append("\n")
				.append("  A  ").toString());
	}

	@Test
	public void shouldCreateDiamond_D() {
		// given
		final Letter letterD = Diamond.alphabet().letter('D');

		// when
		final Diamond diamond = Diamond.of(letterD);

		// then
		assertThat(diamond.toString()).isEqualTo(new StringBuilder()
				.append("   A   ").append("\n")
				.append("  B B  ").append("\n")
				.append(" C   C ").append("\n")
				.append("D     D").append("\n")
				.append(" C   C ").append("\n")
				.append("  B B  ").append("\n")
				.append("   A   ").toString());
	}

}
