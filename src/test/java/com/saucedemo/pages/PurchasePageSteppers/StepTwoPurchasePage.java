package com.saucedemo.pages.PurchasePageSteppers;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StepTwoPurchasePage extends BasePage {
    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(className = "title")
    WebElement title;
    public StepTwoPurchasePage(WebDriver driver) { super(driver); }

    public void clickFinishButton(){
        clickElement(finishButton);
    }

    public String getTitle(){
        return title.getText();
    }

    public StepThreeFinishPurchasePage goToStepThreeFinishPurchasePage(){
        return new StepThreeFinishPurchasePage(getDriver());
    }
}
