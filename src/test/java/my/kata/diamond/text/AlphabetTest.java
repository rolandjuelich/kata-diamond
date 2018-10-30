package my.kata.diamond.text;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import my.kata.diamond.text.Alphabet.Letter;

public class AlphabetTest {

	@Test
	public void shouldCreateLetter() {
		assertThat(Alphabet.of("A").letter('A')).isInstanceOf(Letter.class);
	}
	
}
