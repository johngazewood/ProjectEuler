package problem11thru20;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem17Test {

	@Test
	public void test_twoDigitNumberToWord() {
		assertEquals("thirteen", Problem17.twoDigitNumberToWord(13));
		assertEquals("twenty", Problem17.twoDigitNumberToWord(20));
		assertEquals("twentytwo", Problem17.twoDigitNumberToWord(22));
		assertEquals("eightythree", Problem17.twoDigitNumberToWord(83));
	}
	
	@Test
	public void test_threeDigitNumberToWord() {
		assertEquals("threehundred", Problem17.threeDigitNumberToWord(300));
		assertEquals("fourhundredandten", Problem17.threeDigitNumberToWord(410));
		assertEquals("fivehundredandnine", Problem17.threeDigitNumberToWord(509));
		assertEquals("sixhundredandninetynine", Problem17.threeDigitNumberToWord(699));
		
		assertEquals("three hundred and forty-two".replace(" ", "").replace("-", ""), Problem17.threeDigitNumberToWord(342));
		assertEquals(23, Problem17.threeDigitNumberToWord(342).length());
		assertEquals(20, Problem17.threeDigitNumberToWord(115).length());
	}

}
