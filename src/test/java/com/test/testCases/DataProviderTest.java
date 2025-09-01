package com.test.testCases;

import org.testng.annotations.DataProvider;

public class DataProviderTest extends Retry{

	
	@DataProvider(name="readDataFromExcel")
	public Object[] getData() {
		
		return new Object[][] {
			{"user1","1"},
			{"user2","2"},
			{"user3","3"},	
		};
		
	}

}
