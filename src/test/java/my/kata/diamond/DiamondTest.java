package my.kata.diamond;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DiamondTest {

	@Test
	public void suppliedLetterIsA() {
		assertThat(diamondFor('A')).isEqualTo("A");
	}

	private String diamondFor(char c) {
		return "A";
	}

}
