package telran.text.test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.text.Strings;

class StringsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSortStringsAsDates() {
		String[] dates1 = { "05/11/2014", "23/08/2014", "05/02/2013" };
		String[] expected1 = { "05/02/2013", "23/08/2014", "05/11/2014" };
		Strings.sortStringsAsDates(dates1);
		assertArrayEquals(expected1, dates1);

		String[] dates2 = { "5/11/2014", "23/08/2015", "5/02/2013" };
		String[] expected2 = { "5/02/2013", "5/11/2014", "23/08/2015" };
		Strings.sortStringsAsDates(dates2);
		assertArrayEquals(expected2, dates2);

		String[] dates3 = { "5/11/2014", "1/11/2014", "2/11/2014" };
		String[] expected3 = { "1/11/2014", "2/11/2014", "5/11/2014" };
		Strings.sortStringsAsDates(dates3);
		assertArrayEquals(expected3, dates3);
	}
}