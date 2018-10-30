package my.kata.diamond.text;

import static org.assertj.core.api.Assertions.assertThat;

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

}
