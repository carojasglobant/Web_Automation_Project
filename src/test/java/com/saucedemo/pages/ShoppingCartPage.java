package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    @FindBy(className = "cart_button")
    List<WebElement> removeButtons;

    @FindBy(className = "title")
    WebElement title;

    public ShoppingCartPage(WebDriver driver) { super(driver); }

    public String getTitle(){
        return title.getText();
    }

    public void removeTheThreeItemsAdded(){
        for (WebElement removeButton: removeButtons) {
            clickElement(removeButton);
        }
    }
}
