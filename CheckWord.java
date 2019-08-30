/*****************************************************************************************
 * Program: 	CheckWord
 * Designed by: Siergiey Koisnichenko
 * Date:		3/10/2019
 * Description:	This program is responsible for checking spelling of the entered words,
 * 				if performs the analysis based on the provided dictionary (words.gz), and 
 * 				calculation of the Levenshtein Distance between the words. 
 * 
 * Parameters:	Current distance is set to 1.
 *****************************************************************************************/

import java.util.*;
import java.io.*;
import java.util.Map.Entry;



public class CheckWord {  

	public static void checkWord(String searchedWord){

		int distance = 0;
		HashMap <String, Integer>newlist = new HashMap<String, Integer>();
		
		try {
			Dictionary.loadWords(Dictionary.dictionary);
			} catch (IOException e) {
			e.printStackTrace();
			}
		
		for(String dict : Dictionary.wordlist){
			distance = LevenshteinDistance.computeDistance(dict, searchedWord);
			if(distance<2){
				newlist.put(dict, distance);
				}
			}


		List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(newlist.entrySet());
		
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> entryOne, Entry<String, Integer> entryTwo) {
				return entryOne.getValue().compareTo(entryTwo.getValue());
				}
			});
        
		Map<String, Integer> wordMap = new LinkedHashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : entries) {
			wordMap.put(entry.getKey(), entry.getValue());
			}
        


		for (Entry<String, Integer> e : wordMap.entrySet()){
			if(e.getValue()<1) {
				System.out.println(e.getKey());
				break;
            }
			
			if((e.getValue()>0 && e.getValue()<2)) {
				System.out.println("Word Suggestions for: "+searchedWord);
            	break;
            	}
			}
		
		 for (Entry<String, Integer> e : wordMap.entrySet()){
			if(e.getValue()==0) {
				break;
				
			}if (e.getValue()>=0 && e.getValue()<2) {
				System.out.println(e.getKey());
					
				}
			}

		if(distance>9) {

				System.out.println("No Correction Found");
				
			}
		}
	}





