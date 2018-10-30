package my.kata.diamond.text;

import static my.kata.diamond.text.AlphabetTest.InvalidCharacters.charactersNotIn;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
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
		final Alphabet alphabet = Alphabet.of(randomAlphanumeric(10));

		charactersNotIn(alphabet).examples(50).forEach(example -> {
			// given
			final char invalid = example;

			// when
			final Throwable exception = catchThrowable(() -> alphabet.letter(invalid));

			// then
			assertThat(exception).isInstanceOf(IllegalArgumentException.class).hasMessage(
					"'%s' is not in alphabet of '%s'",
					invalid, alphabet.characters());

		});

	}

	static class InvalidCharacters {

		private final Alphabet alphabet;

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
