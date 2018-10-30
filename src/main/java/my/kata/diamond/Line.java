package my.kata.diamond;

import static java.util.Arrays.asList;

import org.apache.commons.lang3.StringUtils;

public class Line {

	private final String value;

	private Line(final String value) {
		this.value = value;
	}

	public static Line of(final String... values) {
		return new Line(StringUtils.join(values));
	}

	public Lines add(final Lines lines) {
		return Lines.of(asList(value)).add(lines);
	}

}
