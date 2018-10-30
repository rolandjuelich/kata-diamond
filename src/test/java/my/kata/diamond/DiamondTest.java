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
		return Diamond.of(Diamond.alphabet().letter(letter)).toString();
	}

}
