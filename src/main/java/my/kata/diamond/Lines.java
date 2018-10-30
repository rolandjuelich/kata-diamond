package my.kata.diamond;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;

public class Lines {

	private final List<String> values = new ArrayList<String>();

	private Lines(final List<String> values) {
		this.values.addAll(values);
	}

	public static Lines of(final List<String> lines) {
		return new Lines(lines);
	}

	public static Lines empty() {
		return new Lines(emptyList());
	}

	public Lines add(final Lines lines) {
		final List<String> newLines = new ArrayList<String>();
		newLines.addAll(values);
		newLines.addAll(lines.values());
		return Lines.of(newLines);
	}

	public List<String> values() {
		return new ArrayList<>(this.values);
	}


}
