package my.kata.diamond.text;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AlphabetTest {

	@Test
	public void shouldCreateLetter() {
		assertThat(Alphabet.of("A").letter('A').value()).isEqualTo('A');
	}
	
}
