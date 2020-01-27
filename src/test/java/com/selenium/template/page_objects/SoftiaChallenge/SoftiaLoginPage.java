package com.selenium.template.page_objects.SoftiaChallenge;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.selenium.template.utils.InputTextData.SOFTIA_EMAIL;
import static com.selenium.template.utils.InputTextData.SOFTIA_PASSWORD;

public class SoftiaLoginPage extends PageBase {
    public SoftiaLoginPage(WebDriver driver){super(driver);}

    @FindBy(id = "inputEmail")
    WebElement emailField;

    @FindBy(id = "inputPassword")
    WebElement passwordField;

    @FindBy(css = ".btn")
    WebElement signInButton;

    public void loginToSoftia(){
        SeleniumWrapper.sendKeys(emailField, SOFTIA_EMAIL, "Softia email field");
        SeleniumWrapper.sendKeys(passwordField, SOFTIA_PASSWORD, "Softia password field");
        SeleniumWrapper.clickElement(driver, signInButton, "Sign in button");
    }
}
