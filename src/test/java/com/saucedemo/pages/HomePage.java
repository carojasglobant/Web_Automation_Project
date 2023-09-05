package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    @FindBy(className = "title")
    private WebElement title;

    @FindBy(className = "btn_inventory")
    private List<WebElement> products;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadgeNumber;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burguerButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutButton;

    public HomePage(WebDriver driver) { super(driver); }

    public String getTitle() {
        return title.getText();
    }

    public void getAmountOfRandomProducts(int amountOfProducts){
        Random rand = new Random();
        if(!products.isEmpty()) {
            for (int i = 0; i < amountOfProducts; i++) {
//                int randomIndex = rand.nextInt(products.size());
                clickElement(products.get(i));
//                products.remove(randomIndex);
            }
        }
    }

    public String getShoppingCartBadgeNumber(){
        return shoppingCartBadgeNumber.getText();
    }

    public ShoppingCartPage goToShoppingCart(){
        clickElement(shoppingCartLink);
        return new ShoppingCartPage(getDriver());
    }

    public void clickBurguerButton(){
        clickElement(burguerButton);
    }

    public void clickLogOutButton(){
        clickElement(logOutButton);
    }


}
