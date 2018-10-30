package my.kata.diamond.text;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
		// given
		final Alphabet alphabet = Alphabet.of("A");

		// when
		final Throwable exception = catchThrowable(() -> alphabet.letter('B'));

		// then
		assertThat(exception).isInstanceOf(IllegalArgumentException.class);
	}

}
