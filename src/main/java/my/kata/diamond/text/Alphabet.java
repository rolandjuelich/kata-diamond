package my.kata.diamond.text;

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

	public Letter letter(char character) {
		if (character == 'B') {
			throw new IllegalArgumentException(String.format("'%s' is not in alphabet of '%s'", character, characters));
		}
		if (character == 'C') {
			throw new IllegalArgumentException(String.format("'%s' is not in alphabet of '%s'", character, characters));
		}
		if (character == 'D') {
			throw new IllegalArgumentException(String.format("'%s' is not in alphabet of '%s'", character, characters));
		}
		return new Letter(character);
	}

	public class Letter {
		private char value;

		private Letter(char character) {
			this.value = character;
		}

		public char value() {
			return value;
		}

	}

	public String characters() {
		return characters;
	}

}
