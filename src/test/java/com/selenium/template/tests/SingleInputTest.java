package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.SingleInputPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingleInputTest extends ExtentTestListener {

    @Test(groups = "SeleniumEasy", description = "Single Input Test")
    public void Test_The_Single_Input() throws Exception{

        WebDriver driver = getDriver();
        SingleInputPage singleInputPage = new SingleInputPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SIMPLE_FORM_URL);
        driver.manage().window().maximize();

        singleInputPage.enterMessage();
        singleInputPage.clickShowMessage();
        singleInputPage.assertThatTheRightTextIsDisplayed();
    }
}
