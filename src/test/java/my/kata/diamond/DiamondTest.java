package my.kata.diamond;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DiamondTest {

	@Test
	public void suppliedLetterIsA() {
		// given
		final char suppliedLetter = 'A';

		// when
		final String actualDiamond = diamondFor(suppliedLetter);

		// then
		assertThat(actualDiamond).isEqualTo("A");
	}

	@Test
	public void suppliedLetterIsB() {
		// given
		final char suppliedLetter = 'B';

		// when
		final String actualDiamond = diamondFor(suppliedLetter);

		// then
		assertThat(actualDiamond).isEqualTo(new StringBuilder()
				.append(" A ").append("\n")
				.append("B B").append("\n")
				.append(" A ").toString());
	}

	private String diamondFor(char c) {
		return "A";
	}

}
