package my.kata.diamond.text;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.join;

public class Line {

	private static final Line NONE = new Line(null);
	
	private final String value;

	private Line(final String value) {
		this.value = value;
	}

	public static Line none() {
		return NONE;
	}

	public static Line of(final String... values) {
		return new Line(join(values));
	}

	public Lines add(final Lines lines) {
		return Lines.of(asList(value)).add(lines);
	}

	public String value() {
		return new String(value);
	}


}
