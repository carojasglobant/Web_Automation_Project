package com.saucedemo.tests;

import com.saucedemo.data.TestDataProvider;
import com.saucedemo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {
    @Test
    public void performLogInAndLogOut(){
        String LOGO_TEXT = "Swag Labs";

        HomePage homePage = LogInPage.goToHomePage();
        homePage.clickBurguerButton();
        homePage.clickLogOutButton();
        Assert.assertEquals(LogInPage.getLogoText(), LOGO_TEXT);

    }
}
