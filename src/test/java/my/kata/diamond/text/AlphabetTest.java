package my.kata.diamond.text;

import static my.kata.diamond.text.AlphabetTest.InvalidCharacters.charactersNotIn;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import my.kata.diamond.text.Alphabet.Letter;

public class AlphabetTest {

	@Test
	public void shouldCreateLetter() {
		// given
		final Alphabet alphabet = Alphabet.of("A");

		// when
		final Letter letter = alphabet.letter('A');

		// then
		assertThat(letter).isInstanceOf(Letter.class);
		assertThat(letter.value()).isEqualTo('A');
	}

	@Test
	public void shouldNotCreateLetterIfNotInAlphabet() {
		// assume
		final Alphabet alphabet = Alphabet.of("A");
		final List<Character> invalid = charactersNotIn(alphabet).examples(100);

		for (Character invalidCharacter : invalid) {
			// given
			final char character = invalidCharacter;

			// when
			final Throwable exception = catchThrowable(() -> {
				alphabet.letter(character);
			});

			// then
			assertThat(exception).isInstanceOf(IllegalArgumentException.class).hasMessage(
					"'%s' is not in alphabet of '%s'",
					character, alphabet.characters());
		}

	}

	static class InvalidCharacters {

		private Alphabet alphabet;

		private InvalidCharacters(final Alphabet alphabet) {
			this.alphabet = alphabet;
		}

		static InvalidCharacters charactersNotIn(final Alphabet alphabet) {
			return new InvalidCharacters(alphabet);
		}

		public List<Character> examples(int count) {
			final List<Character> examples = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				examples.add(someCharacterNotIn(alphabet));
			}
			return examples;
		}

		private char someCharacterNotIn(final Alphabet alphabet) {
			String someChar;
			do {
				someChar = RandomStringUtils.randomAlphanumeric(1);
			} while (alphabet.characters().contains(someChar));
			return someChar.charAt(0);
		}
	}

}
