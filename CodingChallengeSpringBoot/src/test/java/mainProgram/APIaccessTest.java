package mainProgram;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;


class APIaccessTest {
	
	//Annotaton RepeatedTest - is tested 20 times in a row
	@RepeatedTest (value = 20)
	void testGetCriminal() {
		//comparison variable for the test, variable = null
		String empty = null;
		//Variable for the return value of the getCriminal() method
		String actualCriminal = null;
		
		//Create Instance for the test
		APIaccess apiAccess = new APIaccess();
		
		//Assign the return value of the variable
		actualCriminal = apiAccess.getCriminal();
		
		//Compare the return value and the comparison variable.
		//The return value must not be zero
		assertNotEquals(empty, actualCriminal);		
	}
	
	//Annotaton RepeatedTest - is tested 20 times in a row
	@RepeatedTest (value = 20)
	void testGetMughsotUrl() {
		//comparison variable for the test, variable = null
		String empty = null;
		//Variable for the return value of the getMugshotUrl() method
		String actualMugshotUrl = null;
		
		//Create Instance for the test
		APIaccess apiAccess = new APIaccess();
		
		//Assign the return value of the variable
		actualMugshotUrl = apiAccess.getMugshotUrl();
		
		//Compare the return value and the comparison variable.
		//The return value must not be zero
		assertNotEquals(empty, actualMugshotUrl);
	}	
}
