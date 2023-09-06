package com.saucedemo.tests;

import com.saucedemo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutErrorTest extends BaseTest {
    @Test
    public void performLogInAndLogOut(){
        logError("Change the expected logo text to produce error");
        String LOGO_TEXT = "Swag Lab";

        // perform log out
        HomePage homePage = LogInPage.goToHomePage();
        homePage.clickBurguerButton();
        homePage.clickLogOutButton();
        Assert.assertEquals(LogInPage.getLogoText(), LOGO_TEXT);

    }
}
