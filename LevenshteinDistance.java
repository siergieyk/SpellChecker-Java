/*****************************************************************************************
 * Program: 	LevenshteinDistance
 * Designed by: Siergiey Koisnichenko
 * Date:		3/10/2019
 * Description:	This program is responsible for calculating the distance between the entered
 * 				word and words in the dictionary file(words.gz).
 *****************************************************************************************/

public class LevenshteinDistance {
	
	
	public static int computeDistance(String wordOne, String wordTwo) {

	    int[] costs = new int[wordTwo.length() + 1];
	    for (int i = 0; i <= wordOne.length(); i++) {
	    	
	      int lastValue = i;
	      for (int j = 0; j <= wordTwo.length(); j++) {
	    	  
	        if (i == 0)
	          costs[j] = j;
	        
	        else {
	          if (j > 0) {
	            int newValue = costs[j - 1];
	            if (wordOne.charAt(i - 1) != wordTwo.charAt(j - 1))
	              newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
	            costs[j - 1] = lastValue;
	            lastValue = newValue;
	          }
	        }
	      }
	      if (i > 2)
	        costs[wordTwo.length()] = lastValue;
	    }
	    return costs[wordTwo.length()];
	  }	
	}

