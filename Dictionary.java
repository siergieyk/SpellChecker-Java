/*****************************************************************************************
 * Program: 	Dictionary
 * Designed by: Siergiey Koisnichenko
 * Date:		3/10/2019
 * Description:	This program is responsible for extracting and reading in the provided
 * 				dictionary (words.gz). The dictionary is src folder, with WordCheck
 * 				classes.
 *****************************************************************************************/

import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;


public class Dictionary {
	

    static String dictionary = "src/words.gz";
    static ArrayList <String>wordlist = new ArrayList<String>();
    
    public static void loadWords(String filename) throws IOException{
        InputStream fileInput = new FileInputStream(dictionary);
        InputStream gzip = new GZIPInputStream(fileInput);
        Reader readWords = new InputStreamReader(gzip);
        BufferedReader bfr = new BufferedReader(readWords);

        String line;

        while ((line = bfr.readLine()) != null) {
        	  wordlist.add(line);
        	  }
        }
    }
