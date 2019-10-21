package com.selenium.template.page_objects.SeleniumEasy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingleInputPage extends PageBase {

    public SingleInputPage(WebDriver driver){
        super(driver);
    }

    // Locators, they are used to identify the elements of a page

    @FindBy (id = "user-message")
    WebElement enterMessageField;

    @FindBy (css = "#get-input > button")
    WebElement showMessageButton;

    @FindBy (id = "display")
    WebElement yourMessageResult;

    @FindBy (xpath = "//*[@id=\"sum1\"]")
    WebElement enterValueA;

    // Methods, actions that can be performed on this page/page object
//In this example, the first 2 are actions that we perform

    public void enterMessage(){
        enterMessageField.sendKeys("Stuffy Sutff");
    }

    public void clickShowMessage(){
//This is the option that can be used due to the framework
        SeleniumWrapper.clickElement(driver, showMessageButton, "The Show Message Button");
//This is the traditional way
        //        showMessageButton.click();
    }
//While the third one is the assert, the way that we make the test tell us if the result is the desired one
    public Boolean assertThatTheRightTextIsDisplayed(){
        return SeleniumWrapper.getText(yourMessageResult, "Message Result").contains("Stuffy Stuff");
    }

}
