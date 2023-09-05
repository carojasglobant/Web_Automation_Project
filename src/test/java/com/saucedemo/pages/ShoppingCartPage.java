package com.saucedemo.pages;

import com.saucedemo.pages.PurchaseSteppers.StepOnePurchasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    @FindBy(className = "cart_button")
    List<WebElement> removeButtons;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(className = "checkout_button")
    WebElement checkOutButton;

    public ShoppingCartPage(WebDriver driver) { super(driver); }

    public String getTitle(){
        return title.getText();
    }

    public void removeTheThreeItemsAdded(){
        for (WebElement removeButton: removeButtons) {
            clickElement(removeButton);
        }
    }

    public void clickCheckOutButton(){
        clickElement(checkOutButton);
    }

    public StepOnePurchasePage goToStepOnePurchasePage(){
        return new StepOnePurchasePage(getDriver());
    }
}
