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
		assertThat(allowedLetters().charAt(2)).isEqualTo('C');
		assertThat(allowedLetters().charAt(3)).isEqualTo('D');
		assertThat(allowedLetters().charAt(4)).isEqualTo('E');
		assertThat(allowedLetters().charAt(5)).isEqualTo('F');
		assertThat(allowedLetters().charAt(6)).isEqualTo('G');
		assertThat(allowedLetters().charAt(7)).isEqualTo('H');
		assertThat(allowedLetters().charAt(8)).isEqualTo('I');
		assertThat(allowedLetters().charAt(9)).isEqualTo('J');
		assertThat(allowedLetters().charAt(10)).isEqualTo('K');
		assertThat(allowedLetters().charAt(11)).isEqualTo('L');
		assertThat(allowedLetters().charAt(12)).isEqualTo('M');
		assertThat(allowedLetters().charAt(13)).isEqualTo('N');
		assertThat(allowedLetters().charAt(14)).isEqualTo('O');
		assertThat(allowedLetters().charAt(15)).isEqualTo('P');
		assertThat(allowedLetters().charAt(16)).isEqualTo('Q');
		assertThat(allowedLetters().charAt(17)).isEqualTo('R');
		assertThat(allowedLetters().charAt(18)).isEqualTo('S');
		assertThat(allowedLetters().charAt(19)).isEqualTo('T');
		assertThat(allowedLetters().charAt(20)).isEqualTo('U');
		assertThat(allowedLetters().charAt(21)).isEqualTo('V');
		assertThat(allowedLetters().charAt(22)).isEqualTo('W');
		assertThat(allowedLetters().charAt(23)).isEqualTo('X');
		assertThat(allowedLetters().charAt(24)).isEqualTo('Y');
		assertThat(allowedLetters().charAt(25)).isEqualTo('Z');
	}

	@Test
	public void calculateLeadingWhitespaces(){
		assertThat(leadingWhitespacesFor('A','A')).isEqualTo(0);
		assertThat(leadingWhitespacesFor('B','B')).isEqualTo(0);
		assertThat(leadingWhitespacesFor('C','C')).isEqualTo(0);
		assertThat(leadingWhitespacesFor('D','D')).isEqualTo(0);
		assertThat(leadingWhitespacesFor('E','E')).isEqualTo(0);
		
		assertThat(leadingWhitespacesFor('A','B')).isEqualTo(1);
		assertThat(leadingWhitespacesFor('B','C')).isEqualTo(1);
		assertThat(leadingWhitespacesFor('C','D')).isEqualTo(1);
		assertThat(leadingWhitespacesFor('D','E')).isEqualTo(1);

		assertThat(leadingWhitespacesFor('B','D')).isEqualTo(2);
		assertThat(leadingWhitespacesFor('A','C')).isEqualTo(2);
		assertThat(leadingWhitespacesFor('C','E')).isEqualTo(2);

		assertThat(leadingWhitespacesFor('A','D')).isEqualTo(3);
		assertThat(leadingWhitespacesFor('B','E')).isEqualTo(3);

		assertThat(leadingWhitespacesFor('A','E')).isEqualTo(4);
	}

	@Test
	public void calculateInnerWhitespaces(){
		assertThat(innerWhitespacesFor('A','A')).isEqualTo(0);

		assertThat(innerWhitespacesFor('B','C')).isEqualTo(1);
		assertThat(innerWhitespacesFor('B','D')).isEqualTo(1);
	}
	
	private int innerWhitespacesFor(char current, char supplied) {
		if(current =='B' && supplied == 'C') {
			return 1;
		}
		if(current =='B' && supplied == 'D') {
			return 1;
		}
		return 0;
	}

	private int leadingWhitespacesFor(char current, char supplied) {
		return allowedLetters().indexOf(supplied) - allowedLetters().indexOf(current);
	}

	private String allowedLetters() {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
}
