package CS3213;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by junchao on 8/23/2014.
 */
public class Main {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        WordsRequired wordsRequired = new WordsRequired();
 
        List<String> requireWords=getRequiredWords(sc,wordsRequired);
        List<String> ignoreWords=getIgnoreWords(sc);
 
        while(!(inputValidation(requireWords,ignoreWords))){
        	requireWords=getRequiredWords(sc,wordsRequired);
        	ignoreWords=getIgnoreWords(sc);
        }
        System.out.println("Enter movie titles (terminate input by entering empty line) ");

        List<String> inputs = new ArrayList<String>();
        String userInput = sc.nextLine();
        while (!userInput.isEmpty()) {
            inputs.add(userInput);
            userInput = sc.nextLine();
        }        
        Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : inputs) {
            CircularShift shifter = new CircularShift(str);
            String[] filteredShifts = wordsRequired.getFilteredShifts(shifter.getCircularShifts());
            alphabetizer.addLines(filteredShifts);
        }

        String[] result = alphabetizer.getSortedLines();
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        for (String str : result) {
            builder.append(str).append(separator);
        }
        System.out.print(builder.toString());

        long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) );
        System.exit(0);
    }
    
    private static List<String> getRequiredWords(Scanner sc, WordsRequired wordsRequired){
        wordsRequired.clear();
    	System.out.println("Enter the requred words (terminate input by entering empty line) ");
        List<String> requireWords = new ArrayList<String>();
        String inputRequireWords = sc.nextLine();
        while( !inputRequireWords.isEmpty()){
        	wordsRequired.addWordRequired(inputRequireWords);
        	requireWords.add(inputRequireWords);
        	inputRequireWords=sc.nextLine();
        }
        return requireWords;
    }
    private static List<String> getIgnoreWords(Scanner sc){
    	System.out.println("Enter words to ignore (terminate input by entering empty line) ");
        List<String> ignoreWords = new ArrayList<String>(); 
        String inputWordToIgnore = sc.nextLine();
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        while (!inputWordToIgnore.isEmpty()) {
            wordsToIgnore.addWordToIgnore(inputWordToIgnore);
            ignoreWords.add(inputWordToIgnore);
            inputWordToIgnore = sc.nextLine();
        }
    	return ignoreWords;
    }
    private static boolean inputValidation(List<String> requireWords,List<String> ignoreWords){
    	boolean flag=true;
         String temp=new String();
         for(int i=0;i<requireWords.size();i++){
         	temp=requireWords.get(i);
         	if(ignoreWords.contains(temp)){
         		flag=false;
         		System.out.println("Please try again, match found between required words and ignore words: "+temp);
         		break;
         	}
         }
         return flag;
    }
}
