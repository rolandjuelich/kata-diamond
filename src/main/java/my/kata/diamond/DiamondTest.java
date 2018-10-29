package my.kata.diamond;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

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

	private Object diamondFor(char c) {
		if (c == 'B') {
			return new StringBuilder()
					.append(" A ").append("\n")
					.append("B B").append("\n")
					.append(" A ").toString();
		}
		return "A";
	}

}
