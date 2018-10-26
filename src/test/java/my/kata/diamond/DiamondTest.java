package my.kata.diamond;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiamondTest {

	@Test
	public void suppliedLetterIsA() {
		assertThat(diamondFor('A')).isInstanceOf(String.class);
	}

}
