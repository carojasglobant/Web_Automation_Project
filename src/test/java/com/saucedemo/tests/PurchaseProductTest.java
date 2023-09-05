package com.saucedemo.tests;


import com.saucedemo.data.TestDataProvider;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest {
    @Test(dataProvider = "log-in-wrong-data", dataProviderClass = TestDataProvider.class)
    public void fillLogInWithInvalidData(String username, String password){
        homeLogInPage.inputUsername(username);
        homeLogInPage.inputPassword(password);
        homeLogInPage.submitLogIn();
    }





}
