package com.saucedemo.pages.PurchaseSteppers;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StepOnePurchasePage extends BasePage {
    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(className = "submit-button")
    WebElement continueButton;

    public StepOnePurchasePage(WebDriver driver) { super(driver); }

    public void inputFirstName(String name){
        typeText(firstNameInput, name);
    }

    public void inputLastName(String name){
        typeText(lastNameInput, name);
    }

    public void inputZipCode(String zipCode){
        typeText(postalCodeInput, zipCode);
    }

    public void clickContinueButton(){
        clickElement(continueButton);
    }

    public String getTitle(){
        return title.getText();
    }

    public StepTwoPurchasePage goToSecondStepPurchasePage(){
        return new StepTwoPurchasePage(getDriver());
    }
}
