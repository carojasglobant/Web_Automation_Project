package com.saucedemo.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.saucedemo.Reporter;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BasePage extends Reporter {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }

    public WebDriver getDriver() { return driver; }
    public WebDriverWait getWait() { return wait; }

    public Actions getActions() { return  actions; }

    public void clickElement(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void typeText(WebElement element, String text){
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void chooseSelectOptionByValue(WebElement selectElement, String value){
        Select select = new Select(selectElement);
        select.selectByValue(value);
    }

    public void dismissAlert(){
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
    }
}
