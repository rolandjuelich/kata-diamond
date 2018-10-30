package my.kata.text;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.apache.commons.lang3.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

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
		return new Lines(newLines);
	}

	public List<String> values() {
		return new ArrayList<>(this.values);
	}

	public String asText() {
		return join(values, '\n');
	}

	public Lines startingFromIndex(int index) {
		return new Lines(this.values().subList(index, this.values().size()));
	}

	public Lines reverse() {
		return new Lines(Lists.reverse(values()));
	}

	public Lines add(final Line line) {
		if(Line.none().equals(line)) {
			return new Lines(values);
		}
		return new Lines(values).add(new Lines(asList(line.value())));
	}

}
