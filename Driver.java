package autocomplete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver implements AutoComplete{
	
// Declare some Global Variables to be used in all methods.
	
	public static String[] wordTokens;
	public static String[][] FileArray = new String[10000][3];
	public static int lineNum=0;
	public static String s;
    
// WeightOf method gets the weight of all matching words from the unoutted prefix
// and displays them in highest to lowest weight order.
// This Method takes in a string and returns a double 0=fail (no match found)
// and 1=success (at lest 1 match found).
	public double weightOf(String term) {
		int noofLines=0;
		double failedorsuccess=0;
		
// lineNum holds the number of lines in the data file. So we need to traverse
// the array which holds this data - FileArray.
		while (noofLines < lineNum) {
			
// We used the startsWith method to identify all words which start with the prefix
// entered by the user.
			 if ( (FileArray[noofLines][2].startsWith(s)) == true){
				System.out.print("Weight: ");
		        System.out.print(FileArray[noofLines][1]);
		        System.out.print("    Word: ");
		        System.out.println(FileArray[noofLines][2]);
		        failedorsuccess=1;
				}
			 noofLines++;
		}
		return failedorsuccess;
	  }

// bestMatch method will find the best matching word starting with the prefix 
// entered by the user. Eg. if he entered 'CA' the program will find 'CAN' as
// the best matching word as no word 'CA' exists in the file. It will always
// return the word with the highest weighting.
	@Override
	public String bestMatch(String prefix) {
		// TODO Auto-generated method stub
		int noofLines=0;

// lineNum holds the number of lines in the data file. So we need to traverse
// the array which holds this data - FileArray.
		while (noofLines < lineNum) {
			 if ( (FileArray[noofLines][2].startsWith(s)) == true){
				System.out.print("Weight: ");
		        System.out.print(FileArray[noofLines][1]);
		        System.out.print("    Word: ");
		        System.out.println(FileArray[noofLines][2]);
		        
// As we have found 1 match - this will be the best match because of weight sorting
// in the file - so we 'break' to jumpo out of while loop.
		        break;
				}
			 noofLines++;
		}
// If noofLines >= lineNum - we have gone through the entire array and found no 
// matches. So we return string 'NOMATCH'. Otherwise, we have found a match and 
// we simply return the word which has been found.
		if (noofLines >= lineNum)
				return "NOMATCH";
		else
			return FileArray[noofLines][2];
	}

	@Override
	public Iterable<String> matches(String prefix, int k) {
		// TODO Auto-generated method stub
		System.out.println("matches");
		return null;
	}
	
	
	public static void main(String[]args) throws FileNotFoundException {
// Declare the filename to be read in.
		File wordsFile = new File("./data/worddata.txt");
		
// Scanner reads the contents of the file.
		Scanner inWords = new Scanner(wordsFile);	  
		Scanner input = new Scanner(System.in);
		
        
// Read entire file into FileArray - splitting into weight / delimiter / word..
        while (inWords.hasNextLine()) {
        	String line = inWords.nextLine();
        	wordTokens = line.split("\\s+");
        	FileArray[lineNum][0] = wordTokens[0];
        	FileArray[lineNum][1] = wordTokens[1];
        	FileArray[lineNum][2] = wordTokens[2];
          	lineNum++;  
//		      }
	}


// Ask user to Enter prefix word.
        System.out.print(" enter word: ");
        s = input.next();
        
//	@Override
	Driver d = new Driver();
	double returnvalue=0;
// Call Method weightOf passing the inputted prefix and receiving back a value where
// 1=match found and 0=no match found.
	returnvalue=d.weightOf(s);
	if (returnvalue==1)
		System.out.println("Succesful match found.\n");
	else
		System.out.println("No Match Found");

// Call Method bestMatch passing the inputted prefix and receiving a string back
// with the best match or a constant = 'NOMATCH' which means no match found.
	String BestMatch;		
	BestMatch=d.bestMatch(s);
	if (BestMatch == "NOMATCH")
	{
		System.out.print("Sorry - No match for this word found: ");
		System.out.println(s);
	}
		else
		{		
			System.out.print("Best Match Found: ");
			System.out.println(BestMatch);
		}
}
}


	