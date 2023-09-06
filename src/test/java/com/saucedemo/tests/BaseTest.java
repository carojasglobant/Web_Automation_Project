package com.saucedemo.tests;


import com.saucedemo.pages.LogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.saucedemo.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static java.lang.String.format;

public class BaseTest extends Reporter {

    protected static WebDriver driver;
    protected LogInPage LogInPage;

    @BeforeSuite(alwaysRun = true)
    public void webDriverSetup(){
        logInfo("### Web driver manager setup ###");
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters({"url", "valid_username", "valid_password"})
    public void testSetup(String url, String valid_username, String valid_password ){
        logInfo("Starting new Chrome driver session...");
        driver = new ChromeDriver();
        logInfo(format("Navigating to %s", url));
        driver.get(url);
        driver.manage().window().maximize();


        logInfo("Perform LogIn before every method");
        LogInPage = new LogInPage(driver);
        LogInPage.inputUsername(valid_username);
        LogInPage.inputPassword(valid_password);
        LogInPage.submitLogIn();
    }
    @AfterMethod(alwaysRun = true)
    public void teardown(){
        logInfo("Closing Chrome driver session...");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
