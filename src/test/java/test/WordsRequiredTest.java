package test;

import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.WordsRequired;

public class WordsRequiredTest {
	private final String[] testInput={"Batman the Darknight",
			"Robin the sidekick",
			"Deadshot the mastermind",
			"Harley Quinn",
			"Joker the Ultimate"
	};
	
	@Test
	public void testAddWordRequired() {
		fail("make test fail");
		WordsRequired wordsRequired = new WordsRequired();
		wordsRequired.clear();
		assertEquals(0, wordsRequired.getSize());
		assertFalse(wordsRequired.isWordRequired("nothing in word list yet"));

		wordsRequired.addWordRequired("Batman the Darknight");
		wordsRequired.addWordRequired("Robin the sidekick");
		wordsRequired.addWordRequired("Deadshot the mastermind");
		wordsRequired.addWordRequired("Harley Quinn");
		wordsRequired.addWordRequired("Joker the Ultimate");
		wordsRequired.addWordRequired(""); //should not be added
		assertEquals(5, wordsRequired.getSize());
		assertFalse(wordsRequired.isWordRequired("nothing in word list yet"));
		assertFalse(wordsRequired.isWordRequired(""));

		wordsRequired.addWordRequired("Batman the Darknight");
		wordsRequired.addWordRequired("Robin the sidekick");
		wordsRequired.addWordRequired("Deadshot the mastermind");
		wordsRequired.addWordRequired("Harley Quinn");
		wordsRequired.addWordRequired("Joker the Ultimate");//should not add duplicates
		assertEquals(5, wordsRequired.getSize());
		assertFalse(wordsRequired.isWordRequired("nothing in word list yet"));
		assertFalse(wordsRequired.isWordRequired(""));
	}

	@Test
	public void testGetFilteredShifts() {
		WordsRequired wordsRequired = new WordsRequired();
		String[] output=wordsRequired.getFilteredShifts(testInput);
		assertEquals(5, output.length);

		String expectedString="Batman the Darknight\n"
				+ "Robin the sidekick\n"
				+ "Deadshot the mastermind\n"
				+ "Harley Quinn\n"
				+ "Joker the Ultimate\n";

		String actualString=new String();
		for(int i=0;i<output.length;i++){
			actualString+=output[i];
			actualString+="\n";
		}
		assertEquals(expectedString, actualString);

		wordsRequired.addWordRequired("Batman");
		wordsRequired.addWordRequired("Harley");
		assertEquals(2, wordsRequired.getSize());
		output=wordsRequired.getFilteredShifts(testInput);
		expectedString="Batman the Darknight\n"
				+"Harley Quinn\n";	
		actualString=new String();
		for(int i=0;i<output.length;i++){
			actualString+=output[i];
			actualString+="\n";
		}
		assertEquals(expectedString, actualString);
	}

}
