package CS3213;

import java.util.LinkedList;
import java.util.List;
	
	public class WordsRequired {
	    private LinkedList<String> _wordsRequired;
	    
	    public WordsRequired() {
	        this._wordsRequired = new LinkedList<String>();
	    }
	    public void addWordRequired(String word) {
	        assert(word != null);
	        if(!(isWordRequired(word)) && !(word.equals(""))){
	        	this._wordsRequired.add(word);
	        }
	    }
	    
	    public String[] getFilteredShifts(String[] circularShifts){
	    	if (getSize()== 0){
	    		return circularShifts;
	    	}
	    	else{
	    		List<String> filteredList = new LinkedList<String>();
	    		//System.out.println(_wordsRequired);
	    		
	    		for (int i = 0; i < circularShifts.length; i++){
	    			for (String wordRequired: _wordsRequired){
	    				if ((circularShifts[i]).toLowerCase().startsWith(wordRequired.toLowerCase())){
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
	    
	    public void clear(){
	    	this._wordsRequired.clear();
	    }
	}
	

