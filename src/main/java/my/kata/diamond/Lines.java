package my.kata.diamond;

import java.util.ArrayList;
import java.util.List;

public class Lines {

	private final List<String> values = new ArrayList<String>();

	private Lines(final List<String> values) {
		this.values.addAll(values);
	}

	public static Lines empty() {
		return new Lines(new ArrayList<String>());
	}
	
	public static Lines of(final List<String> lines) {
		return new Lines(lines);
	}

	public Lines add(final Lines lines) {
		return Lines.of(lines.values());
	}

	public List<String> values() {
		return this.values;
	}

}
