package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import dataProviders.configFileReader;
import helpers.helpers;


public class pageCheckRate {

    private WebDriver driver;
    private By desiredAmountField;
    private By purposeDropdown;
    private By checkRateButton;
    private dataProviders.configFileReader configFileReader= new configFileReader();

    public pageCheckRate(WebDriver driver) {

        this.driver = driver;
        desiredAmountField = By.className("sc-kkGfuU");
        purposeDropdown = By.className("sc-eqIVtm");
        checkRateButton = By.className("sc-fBuWsC");
    }

    // This function is to browse to Check Rate page, input desired amount, purpose and click "Check your rate" button.
    public void checkRate(Integer desiredAmountValue, Integer purposeValue) {

        driver.navigate().to(configFileReader.baseURL());
        helpers helper = new helpers();
        helper.waitForElement(driver, desiredAmountField);
        driver.findElement(desiredAmountField).sendKeys(Integer.toString(desiredAmountValue));
        helper.selectFromDropdown(driver, purposeDropdown, purposeValue);
        driver.findElement(checkRateButton).click();
        System.out.print(" Calculating your rate...");

    }


}
