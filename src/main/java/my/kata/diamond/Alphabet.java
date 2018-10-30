package my.kata.diamond;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.repeat;

public class Alphabet {

	private final String characters;

	private Alphabet(final String characters) {
		this.characters = characters;
	}

	public static Alphabet of(final String characters) {
		return new Alphabet(characters);
	}

	public static String space(int times) {
		return repeat(SPACE, times);
	}

	public char characterAt(int index) {
		return characters.charAt(index);
	}

	public int indexOf(char character) {
		return characters.indexOf(character);
	}

}
