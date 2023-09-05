package com.saucedemo.tests;


import com.saucedemo.data.TestDataProvider;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest {
    @Test(dataProvider = "log-valid-data", dataProviderClass = TestDataProvider.class)
    public void fillOutLogInWithValidData(String username, String password){
        String HOME_PAGE_TITLE = "Products";
        String SHOPPING_CART_PAGE = "Your Cart";

        LogInPage.inputUsername(username);
        LogInPage.inputPassword(password);
        LogInPage.submitLogIn();
        HomePage homePage = LogInPage.goToHomePage();
        logInfo("Verifying that log in was successful");
        Assert.assertEquals(homePage.getTitle(), HOME_PAGE_TITLE);
        homePage.getThreeRandomProducts();
        Assert.assertEquals(homePage.getShoppingCartBadgeNumber(), "3");
        ShoppingCartPage shoppingCartPage = homePage.goToShoppingCart();
        logInfo("Verifying the products were added successful");
        Assert.assertEquals(shoppingCartPage.getTitle(), SHOPPING_CART_PAGE);
        shoppingCartPage.removeTheThreeItemsAdded();

    }





}
