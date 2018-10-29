package my.kata.diamond;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiamondTest {

	@Test
	public void shouldCreateDiamond_A() {
		assertThat(diamondFor('A')).isEqualTo("A");
	}

}
