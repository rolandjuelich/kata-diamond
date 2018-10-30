package my.kata.diamond;

public class Alphabet {

	private String value;

	public Alphabet(final String value) {
		this.value = value;
	}

	public char characterAt(int index) {
		return value.charAt(index);
	}

}
