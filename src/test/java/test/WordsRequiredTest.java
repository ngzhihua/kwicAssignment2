package test;

import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.WordsRequired;

public class WordsRequiredTest {

	@Test
	public void testGetWordsRequired() {
		WordsRequired wordsRequired = WordsRequired.getWordsRequired();
		assertNotNull(wordsRequired);
	}

	@Test
	public void testAddWordRequired() {
		WordsRequired wordsRequired = WordsRequired.getWordsRequired();
		
		assertFalse(wordsRequired.isWordRequired("The"));
		
		wordsRequired.addWordRequired("Batman");
		wordsRequired.addWordRequired("Robin");
		wordsRequired.addWordRequired("Deadshot");
		wordsRequired.addWordRequired("Harley");
		wordsRequired.addWordRequired("Joker");
		assertEquals(5, wordsRequired.getSize());
	}

	@Test
	public void testGetFilteredShifts() {
		WordsRequired wordsRequired = WordsRequired.getWordsRequired();
		String[] testInput ={"Batman the Darknight",
							"Robin the sidekick",
							"Deadshot the mastermind",
							"Harley Quinn",
							"Joker the Ultimate"};
		String[] output=wordsRequired.getFilteredShifts(testInput);
		assertEquals(5, output.length);
	}

}
