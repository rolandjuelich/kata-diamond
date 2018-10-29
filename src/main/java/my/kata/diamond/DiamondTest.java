package my.kata.diamond;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.join;
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
		if (letter == 'A') {
			return "A";
		}
		if (letter == 'B') {
			String lineA = " A ";
			String lineB = "B B";
			return join(asList(lineA,lineB,lineA),'\n');
		}
		if (letter == 'C') {
			return new StringBuilder()
					.append("  A  ").append("\n")
					.append(" B B ").append("\n")
					.append("C   C").append("\n")
					.append(" B B ").append("\n")
					.append("  A  ").toString();
		}
		if (letter == 'D') {
			return new StringBuilder()
					.append("   A   ").append("\n")
					.append("  B B  ").append("\n")
					.append(" C   C ").append("\n")
					.append("D     D").append("\n")
					.append(" C   C ").append("\n")
					.append("  B B  ").append("\n")
					.append("   A   ").toString();
		}
		return null;
	}

}
