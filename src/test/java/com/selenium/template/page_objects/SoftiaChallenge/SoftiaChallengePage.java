package com.selenium.template.page_objects.SoftiaChallenge;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.selenium.template.utils.InputTextData.*;

public class SoftiaChallengePage extends PageBase {
    public SoftiaChallengePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "title")
    WebElement titleField;

    @FindBy(id = "description")
    WebElement descriptionField;

    @FindBy(id = "screenshot")
    WebElement screenshotField;

    @FindBy(id = "created_at")
    WebElement datePickerField;

    @FindBy(css = ".btn:nth-child(6)")
    WebElement submitButton;

    File file = new File(TEST_IMAGE_PATH);
    SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("dd");
    String currentDay = simpleDateFormatDay.format(new Date());
    SimpleDateFormat simpleDateFormatMonth = new SimpleDateFormat("MMM");
    String currentMonth = simpleDateFormatDay.format(new Date());
    SimpleDateFormat simpleDateFormatYear = new SimpleDateFormat("yyyy");
    String currentYear = simpleDateFormatYear.format(new Date());

    public void enterTitle() {
        SeleniumWrapper.sendKeys(titleField, TICKET_TITLE, "Ticket's title");
    }

    public void enterDescription() {
        SeleniumWrapper.sendKeys(descriptionField, TICKET_DESCRIPTION, "Ticket's description");
    }

    public void uploadImage() {
        screenshotField.sendKeys(file.getAbsolutePath());
    }

    public void clickSubmitButton(){
        SeleniumWrapper.clickElement(driver, submitButton, "Submit button");
    }

    public void enterDate() throws Exception {
//Honestly, I am not proud of how this method is built, but it was anything I could come up with at the moment to make it work, considering how buggy the field is
        datePickerField.sendKeys(currentDay);
        datePickerField.sendKeys(currentMonth);
        datePickerField.sendKeys(Keys.TAB);
        datePickerField.sendKeys(currentYear);

//This is what I would have done if I could, but I am not sure it will work as i can't test it
       /*datePickerField.click();
        ListWebElement> columns = datePickerField.findElements(By.tagName("td"));

        for (WebElement cell: columns){
            if(cell.getText().equals(currentdate)){
                cell.findElement(By.linkText(currentdate)).click();
                break;
            }
        }*/
    }
    public String getTitleText(){
        return titleField.getText();
//    return SeleniumWrapper.getText(titleField, "title field").contains("Ceva").isTrue();

    }
}
