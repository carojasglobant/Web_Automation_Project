package com.saucedemo.tests;

import com.saucedemo.data.TestDataProvider;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.PurchasePageSteppers.StepOnePurchasePage;
import com.saucedemo.pages.PurchasePageSteppers.StepThreeFinishPurchasePage;
import com.saucedemo.pages.PurchasePageSteppers.StepTwoPurchasePage;
import com.saucedemo.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest {

    @Test(dataProvider = "user-information-data", dataProviderClass = TestDataProvider.class)
    public void purchase(String firstName, String lastName, String post_code){
        String HOME_PAGE_TITLE = "Products";
        String SHOPPING_CART_PAGE = "Your Cart";
        String CHECKOUT_TITLE = "Checkout: Your Information";
        String OVERVIEW_TITLE = "Checkout: Overview";
        String SUCCESSFUL_ORDER_MESSAGE = "Thank you for your order!";

        HomePage homePage = LogInPage.goToHomePage();

        // assert we are inside the shopping page
        Assert.assertEquals(homePage.getTitle(), HOME_PAGE_TITLE);
        homePage.getAmountOfRandomProducts(1);
        Assert.assertEquals(homePage.getShoppingCartBadgeNumber(), "1");

        // change to shopping cart
        ShoppingCartPage shoppingCartPage = homePage.goToShoppingCart();
        logInfo("Verifying we are in the correct shopping cart page");
        Assert.assertEquals(shoppingCartPage.getTitle(), SHOPPING_CART_PAGE);
        shoppingCartPage.clickCheckOutButton();

        // start the purchase stepper one
        StepOnePurchasePage stepOnePurchasePage = shoppingCartPage.goToStepOnePurchasePage();
        Assert.assertEquals(stepOnePurchasePage.getTitle(), CHECKOUT_TITLE);
        logInfo("Filling the form");
        stepOnePurchasePage.inputFirstName(firstName);
        stepOnePurchasePage.inputLastName(lastName);
        stepOnePurchasePage.inputZipCode(post_code);
        stepOnePurchasePage.clickContinueButton();

        // change to purchase stepper two
        StepTwoPurchasePage stepTwoPurchasePage = stepOnePurchasePage.goToSecondStepPurchasePage();
        Assert.assertEquals(stepTwoPurchasePage.getTitle(), OVERVIEW_TITLE);
        stepTwoPurchasePage.clickFinishButton();

        // finish purchase
        logInfo("Verifying we ended in the successful order page");
        StepThreeFinishPurchasePage stepThreeFinishPurchasePage = stepTwoPurchasePage.goToStepThreeFinishPurchasePage();
        Assert.assertEquals(stepThreeFinishPurchasePage.getCompleteHeader(), SUCCESSFUL_ORDER_MESSAGE);

    }
}
