package com.saucedemo.data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "log-valid-data")
    public static Object[][] testDataForLogIn() {
        return new Object[][] {
                {
                    "standard_user",
                    "secret_sauce"
                }
        };
    }
}
