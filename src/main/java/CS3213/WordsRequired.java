package CS3213;

import java.util.ArrayList;
import java.util.List;
	
	public class WordsRequired {
	    private ArrayList<String> _wordsRequired;
	    private static WordsRequired _instance;
	    
	    private WordsRequired() {
	        this._wordsRequired = new ArrayList<String>();
	    }

	    public static WordsRequired getWordsRequired() {
	        if (_instance == null) {
	            _instance = new WordsRequired();
	        }

	        return _instance;
	    }

	    public void addWordRequired(String word) {
	        assert(word != null);
	        this._wordsRequired.add(word);
	    }
	    
	    public String[] getFilteredShifts(String[] circularShifts){
	    	if (_wordsRequired.size() == 0){
	    		return circularShifts;
	    	}
	    	else{
	    		List<String> filteredList = new ArrayList<String>();
	    		
	    		for (int i = 0; i < circularShifts.length; i++){
	    			for (String wordRequired: _wordsRequired){
	    				if (circularShifts[i].startsWith(wordRequired)){
	    					filteredList.add(circularShifts[i]);
	    				}
	    			}
	    		}
	    		String[] filteredArray = new String[filteredList.size()];
	    		filteredArray = filteredList.toArray(filteredArray);
	    		return filteredArray;
	    	}
	    }

	    public boolean isWordRequired(String word) {
	        assert(word != null);
	        return this._wordsRequired.contains(word);
	    }
	    
	    public int getSize(){
	    	return this._wordsRequired.size();
	    }
	}
	

