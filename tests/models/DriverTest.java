package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class DriverTest {


		private Driver dr1, dr2, dr3, dr4;
		
	    @Before
	    public void setUp(){
			dr1 = new Driver("Can");  //word which has many matches 
			dr2 = new Driver("Hello");   //word does NOT exist in file.
		}
	    
	    @After


	    @Test
		public void testweightOf(){
			assertEquals("Can)", dr1.weightOf());
			assertEquals("Hello", dr2.weightOf());
		}

	    @Test
		public void testbestMatch(){
	    	assertEquals("Can)", dr1.bestMatch());
			assertEquals("Hello", dr2.bestMatch());
		}

	   
	    public void testReadFile() {
	    	pass("./data/worddata.txt");
	}

}
