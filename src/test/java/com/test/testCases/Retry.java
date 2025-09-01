package com.test.testCases;


import org.testng.annotations.Test;


public class Retry {
	
//	@Test(retryAnalyzer = RetryLogic.class)
	public void RetryingTestLogic() {
		
		assert false;
		
	}

	@Test(dataProvider = "readDataFromExcel",dataProviderClass = DataProviderTest.class)
	public void Test(String uname, String pwd) {
		
		System.out.println("Username-"+uname+" , "+"password-"+pwd);
		
	}
	
}

