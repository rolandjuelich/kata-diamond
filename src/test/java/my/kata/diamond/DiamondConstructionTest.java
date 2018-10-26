package my.kata.diamond;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DiamondConstructionTest {

	/*
	 * 	Rules:
	 * 	------
	 * 
	 * 		1. possible letters are a list of characters with defined order and a zero based index
	 *		2. number of leading or trailing whitespaces is equal to the difference of the indices between A and supplied letter
	 *		3. number of inner whitespaces is index of current letter +1 or 0 if current letter is 'A'
	 * 
	 */
	
	@Test
	public void defineAllowedLetters() {
		assertThat(allowedLetters().charAt(0)).isEqualTo('A');
		assertThat(allowedLetters().charAt(1)).isEqualTo('B');
	}

	private String allowedLetters() {
		return "AB";
	}
}
