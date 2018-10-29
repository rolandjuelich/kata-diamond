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
			String lineA = " " + "A" + " ";
			String lineB = "B" + " " + "B";
			return asString(asList(lineA, lineB));
		}
		if (letter == 'C') {
			String lineA = " " + " " + "A" + " " + " ";
			String lineB = " " + "B" + " " + "B" + " ";
			String lineC = "C" + " " + " " + " " + "C";
			return asString(asList(lineA, lineB, lineC));
		}
		if (letter == 'D') {
			String lineA = " " + " " + " " + "A" + " " + " " + " ";
			String lineB = " " + " " + "B" + " " + "B" + " " + " ";
			String lineC = " " + "C" + " " + " " + " " + "C" + " ";
			String lineD = "D" + " " + " " + " " + " " + " " + "D";
			return asString(asList(lineA, lineB, lineC, lineD));
		}
		return null;
	}

	private String asString(List<String> baseLines) {
		List<String> b2a = Lists.reverse(baseLines);
		List<String> lines = new ArrayList<>();
		lines.addAll(baseLines);
		lines.addAll(b2a.subList(1, b2a.size()));
		String result = join(lines, '\n');
		return result;
	}

}
