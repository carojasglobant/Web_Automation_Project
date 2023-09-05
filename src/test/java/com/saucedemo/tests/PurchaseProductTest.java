package com.saucedemo.tests;


import com.beust.ah.A;
import com.saucedemo.data.TestDataProvider;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.PurchaseSteppers.StepOnePurchasePage;
import com.saucedemo.pages.PurchaseSteppers.StepThreeFinishPurchasePage;
import com.saucedemo.pages.PurchaseSteppers.StepTwoPurchasePage;
import com.saucedemo.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest {

    @Test(dataProvider = "user-information-data", dataProviderClass = TestDataProvider.class)
    public void purchase(String username, String password,String firstName, String lastName, String post_code){
        String HOME_PAGE_TITLE = "Products";
        String SHOPPING_CART_PAGE = "Your Cart";
        String CHECKOUT_TITLE = "Checkout: Your Information";
        String OVERVIEW_TITLE = "Checkout: Overview";
        String SUCCESSFUL_ORDER_MESSAGE = "Thank you for your order!";

        HomePage homePage = LogInPage.goToHomePage();
        LogInPage.inputUsername(username);
        LogInPage.inputPassword(password);
        LogInPage.submitLogIn();
        Assert.assertEquals(homePage.getTitle(), HOME_PAGE_TITLE);
        homePage.getAmountOfRandomProducts(1);
        Assert.assertEquals(homePage.getShoppingCartBadgeNumber(), "1");
        ShoppingCartPage shoppingCartPage = homePage.goToShoppingCart();
        logInfo("Verifying the product(s) were added successful");
        Assert.assertEquals(shoppingCartPage.getTitle(), SHOPPING_CART_PAGE);
        shoppingCartPage.clickCheckOutButton();
        StepOnePurchasePage stepOnePurchasePage = shoppingCartPage.goToStepOnePurchasePage();
        Assert.assertEquals(stepOnePurchasePage.getTitle(), CHECKOUT_TITLE);
        stepOnePurchasePage.inputFirstName(firstName);
        stepOnePurchasePage.inputLastName(lastName);
        stepOnePurchasePage.inputZipCode(post_code);
        stepOnePurchasePage.clickContinueButton();
        StepTwoPurchasePage stepTwoPurchasePage = stepOnePurchasePage.goToSecondStepPurchasePage();
        Assert.assertEquals(stepTwoPurchasePage.getTitle(), OVERVIEW_TITLE);
        stepTwoPurchasePage.clickFinishButton();
        StepThreeFinishPurchasePage stepThreeFinishPurchasePage = stepTwoPurchasePage.goToStepThreeFinishPurchasePage();
        Assert.assertEquals(stepThreeFinishPurchasePage.getCompleteHeader(), SUCCESSFUL_ORDER_MESSAGE);

    }






}
