package com.saucedemo.data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "log-in-wrong-data")
    public static Object[][] testDataForLogIn() {
        return new Object[][] {
                {
                    "username",
                    "password"
                }
        };
    }
}
