package com.saucedemo.tests;

import com.saucedemo.data.TestDataProvider;
import com.saucedemo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {
    @Test(dataProvider = "log-valid-data", dataProviderClass = TestDataProvider.class)
    public void performLogInAndLogOut(String username, String password){
        String LOGO_TEXT = "Swag Labs";

        LogInPage.inputUsername(username);
        LogInPage.inputPassword(password);
        LogInPage.submitLogIn();
        HomePage homePage = LogInPage.goToHomePage();
        homePage.clickBurguerButton();
        homePage.clickLogOutButton();
        Assert.assertEquals(LogInPage.getLogoText(), LOGO_TEXT);

    }
}
