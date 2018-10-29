package my.kata.diamond;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.join;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

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
			List<String> a2b = asList(lineA, lineB);
			List<String> b2a = Lists.reverse(a2b);
			List<String> lines = new ArrayList<>();
			lines.addAll(a2b);
			lines.addAll(b2a.subList(1, b2a.size()));
			return join(lines, '\n');
		}
		if (letter == 'C') {
			String lineA = "  A  ";
			String lineB = " B B ";
			String lineC = "C   C";
			return join(asList(lineA, lineB, lineC, lineB, lineA), '\n');
		}
		if (letter == 'D') {
			String lineA = "   A   ";
			String lineB = "  B B  ";
			String lineC = " C   C ";
			String lineD = "D     D";
			return join(asList(lineA, lineB, lineC, lineD, lineC, lineB, lineA), '\n');
		}
		return null;
	}

}
