package autocomplete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[]args) throws FileNotFoundException {
		  File wordsFile = new File("./data/worddata.txt");
		  Scanner inWords = new Scanner(wordsFile);	  
		  int lineNum=0;
		  Scanner input = new Scanner(System.in);
          String s;
          String delims = " ";
          System.out.print(" enter word: ");
          s = input.next();
		      while (inWords.hasNextLine()) {
		          String line = inWords.nextLine();
		          lineNum++;
		          String[] wordTokens = line.split("\\s+");
		                if ( (wordTokens[2].startsWith(s)) == true){
		                System.out.println(wordTokens[2]);
		    }
		  }
		
	}
}