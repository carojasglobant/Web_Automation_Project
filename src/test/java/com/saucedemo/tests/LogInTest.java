package com.saucedemo.tests;

import com.saucedemo.data.TestDataProvider;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest{
    @Test(dataProvider = "log-valid-data", dataProviderClass = TestDataProvider.class)
    public void performLogIn(String username, String password){
        LogInPage.inputUsername(username);
        LogInPage.inputPassword(password);
        LogInPage.submitLogIn();
    }
}
