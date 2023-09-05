package com.saucedemo.tests;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {
    @Test
    public void addAndRemoveThreeItemsInTheShoppingCart(){
        String HOME_PAGE_TITLE = "Products";
        String SHOPPING_CART_PAGE = "Your Cart";

        HomePage homePage = LogInPage.goToHomePage();
        logInfo("Verifying that log in was successful");
        Assert.assertEquals(homePage.getTitle(), HOME_PAGE_TITLE);
        homePage.getAmountOfRandomProducts(3);
        Assert.assertEquals(homePage.getShoppingCartBadgeNumber(), "3");

        ShoppingCartPage shoppingCartPage = homePage.goToShoppingCart();

        logInfo("Verifying the products were added successful");
        Assert.assertEquals(shoppingCartPage.getTitle(), SHOPPING_CART_PAGE);
        shoppingCartPage.removeTheThreeItemsAdded();
        Assert.assertEquals(shoppingCartPage.getItems().size(),0);
    }

}
