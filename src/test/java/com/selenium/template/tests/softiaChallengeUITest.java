package com.selenium.template.tests;

import com.selenium.template.config.ApiTest;
import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SoftiaChallenge.SoftiaChallengePage;
import com.selenium.template.page_objects.SoftiaChallenge.SoftiaLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.selenium.template.utils.TestData.SOFTIA_CHALLENGE_URL;

public class softiaChallengeUITest extends ExtentTestListener {

    @Test
    public void softia_challenge_ui_test() throws Exception{
        WebDriver driver = getDriver();
        SoftiaChallengePage softiaChallengePage = new SoftiaChallengePage(driver);
        SoftiaLoginPage softiaLoginPage = new SoftiaLoginPage(driver);
        ApiTest apiTest = new ApiTest();

        driver.get(SOFTIA_CHALLENGE_URL);
        driver.manage().window().maximize();

        softiaLoginPage.loginToSoftia();
        softiaChallengePage.enterTitle();
        softiaChallengePage.enterDescription();
        softiaChallengePage.uploadImage();
        softiaChallengePage.enterDate();
        softiaChallengePage.clickSubmitButton();
        Assert.assertEquals(softiaChallengePage.getTitleText(), "");
        apiTest.getATicketsTitle();

    }
}
