package my.kata.diamond.text;

import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class AlphabetTest {

	@Test
	public void shouldCreateLetter() {
		assertThat(Alphabet.of("A").letter('A')).isInstanceOf(Letter.class);
	}
	
}
