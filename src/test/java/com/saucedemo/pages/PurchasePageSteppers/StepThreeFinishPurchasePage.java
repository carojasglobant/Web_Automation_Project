package com.saucedemo.pages.PurchasePageSteppers;

import com.saucedemo.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StepThreeFinishPurchasePage extends BasePage{
    @FindBy(className = "complete-header")
    WebElement completeHeader;

    @FindBy(id = "back-to-products")
    WebElement backToHomeButton;

    public StepThreeFinishPurchasePage(WebDriver driver) { super(driver); }

    public String getCompleteHeader(){
        return completeHeader.getText();
    }

    public void clickBackHomeButton(){
        clickElement(backToHomeButton);
    }
}
