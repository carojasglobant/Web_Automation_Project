package com.saucedemo;

import org.testng.ITestResult;
import org.testng.ITestListener;


import static java.lang.String.format;

public class Listener extends Reporter implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        logInfo(format("Test: %s - [FAIL]", result.getName()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logWarning(format("Test: %s - [SKIPPED]", result.getName()));
    }

    @Override
    public void onTestStart(ITestResult result) {
        logInfo(format("Test: %s - [Starting...]", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logInfo(format("Test: %s - [PASSED]", result.getName()));

    }

}
