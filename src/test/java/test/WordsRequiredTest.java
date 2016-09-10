package test;

import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.WordsRequired;

public class WordsRequiredTest {
	private final String[] circularShiftTestCase={"Batman the Darknight",
			"Robin the sidekick",
			"Deadshot the mastermind",
			"Harley Quinn",
			"Joker the Ultimate"
	};
	
	@Test
	public void testAddWordRequired() {
		//Part 0: Initial Setup
		WordsRequired wordsRequired = new WordsRequired();
		wordsRequired.clear();
		assertEquals(0, wordsRequired.getSize());
		
		//Part 1: Test whether words can be added
		wordsRequired.addWordRequired("Batman");
		wordsRequired.addWordRequired("Robin");
		wordsRequired.addWordRequired("Deadshot");
		wordsRequired.addWordRequired("Harley");
		wordsRequired.addWordRequired("Joker");
		wordsRequired.addWordRequired(" "); //should not be added
		wordsRequired.addWordRequired(""); //should not be added
		//assertEquals(5, wordsRequired.getSize());
		assertTrue(wordsRequired.isWordRequired("Batman"));
		assertTrue(wordsRequired.isWordRequired("Robin"));
		assertTrue(wordsRequired.isWordRequired("Deadshot"));
		assertTrue(wordsRequired.isWordRequired("Harley"));
		assertTrue(wordsRequired.isWordRequired("Joker"));
		assertFalse(wordsRequired.isWordRequired(" "));
		assertFalse(wordsRequired.isWordRequired(""));
		
		//Part 2: Test whether module can ignore duplicate words
		wordsRequired.addWordRequired("Batman");
		wordsRequired.addWordRequired("Robin");
		wordsRequired.addWordRequired("Deadshot");
		wordsRequired.addWordRequired("Harley");
		wordsRequired.addWordRequired("Joker");
		assertEquals(5, wordsRequired.getSize());
		assertFalse(wordsRequired.isWordRequired(""));
	}

	@Test
	public void testGetFilteredShifts() {
		
		//Part 0: Initial Setup and test with no required word
		WordsRequired wordsRequired = new WordsRequired();
		wordsRequired.clear();
		assertEquals(0, wordsRequired.getSize());
		String[] output=wordsRequired.getFilteredShifts(circularShiftTestCase);
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
		
		//Part 1: Test of functionality with required words added
		wordsRequired.addWordRequired("Batman");
		wordsRequired.addWordRequired("Harley");
		assertEquals(2, wordsRequired.getSize());
		output=wordsRequired.getFilteredShifts(circularShiftTestCase);
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
