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

    protected WebDriver driver;
    protected LogInPage LogInPage;

    @BeforeSuite(alwaysRun = true)
    public void webDriverSetup(){
        logInfo("### Web driver manager setup ###");
        WebDriverManager.chromedriver().setup();
    }

    @Parameters("url")
    @BeforeMethod(alwaysRun = true)
    public void testSetup(String url){
        logInfo("Starting new Chrome driver session...");
        driver = new ChromeDriver();
        logInfo(format("Navigating to %s", url));
        driver.get(url);
        driver.manage().window().maximize();
        LogInPage = new LogInPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void teardown(){
        logInfo("Closing Chrome driver session...");
//        driver.quit();
    }
}
