package com.test.testCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {

    private int retryCount = 0;           // current retry attempt
    private static final int maxRetryCount = 3; // max retry attempts

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test " + result.getName() + " (Attempt " + retryCount + ")");
            return true; // retry the test
        }
        return false; // no more retries
    }
}
