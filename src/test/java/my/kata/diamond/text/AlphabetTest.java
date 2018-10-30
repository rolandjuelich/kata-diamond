package my.kata.diamond.text;

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
		final List<Character> invalid = invalidCharacterExamplesFor(alphabet);

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

	private List<Character> invalidCharacterExamplesFor(final Alphabet alphabet) {
		final List<Character> exapmles = new ArrayList<>();
		for(int i=0; i<100; i++) {
			exapmles.add(someCharacterNotIn(alphabet));
		}
		return exapmles;
	}

	private static char someCharacterNotIn(final Alphabet alphabet) {
		String someChar;
		do {
			someChar = RandomStringUtils.randomAlphanumeric(1);
		} while (alphabet.characters().contains(someChar));
		return someChar.charAt(0);
	}

}
