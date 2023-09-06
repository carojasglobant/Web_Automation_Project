package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    @FindBy(className = "login_logo")
    private WebElement logoText;

    public LogInPage(WebDriver driver) { super(driver); }

    public void inputUsername(String username) { typeText(usernameInput, username); }

    public void inputPassword(String password) { typeText(passwordInput, password);}

    public void submitLogIn () {
        clickElement(logInButton);
    }

    public HomePage goToHomePage(){
        return new HomePage(getDriver());
    }

    public String getLogoText(){
        return logoText.getText();
    }

}
