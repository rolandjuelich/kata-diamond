package my.kata.diamond;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.join;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
		String space = " ";
		String a = "A";
		String b = "B";
		String c = "C";
		String d = "D";

		if (letter == 'A') {
			return a;
		}
		if (letter == 'B') {
			String lineA = space + a + space;
			String lineB = b + space + b;
			return asString(asList(lineA, lineB));
		}
		if (letter == 'C') {
			String lineA = space(2) + a + space(2);
			String lineB = space(1) + b + space(1) + b + space(1);
			String lineC = c + space(3) + c;
			return asString(asList(lineA, lineB, lineC));
		}
		if (letter == 'D') {
			String lineA = space(2) + space + a + space(2) + space;
			String lineB = space(2) + b + space + b + space(2);
			String lineC = space + c + space(2) + space + c + space;
			String lineD = d + space(2) + space(2) + space + d;
			return asString(asList(lineA, lineB, lineC, lineD));
		}
		return null;
	}

	private String space(int times) {
		return StringUtils.repeat(StringUtils.SPACE, times);
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
