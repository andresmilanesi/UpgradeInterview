package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import helpers.helpers;

public class pageBasicInfo {
    private WebDriver driver;
    private By firstNameField;
    private By lastNameField;
    private By addressField;
    private By dobField;
    private By continueButton;
    private By individualAnnualIncomeField;
    private By additionalAnnualIncomeField;
    private By geoSuggestOption;
    private By userNameField;
    private By passField;
    private By agreeCheckBox;

    public pageBasicInfo(WebDriver driver) {

        this.driver = driver;
        firstNameField = By.name("borrowerFirstName");
        lastNameField = By.name("borrowerLastName");
        addressField = By.name("borrowerStreet");
        dobField = By.name("borrowerDateOfBirth");
        continueButton = By.className("sc-cMljjf");
        individualAnnualIncomeField = By.name("borrowerIncome");
        additionalAnnualIncomeField = By.name("borrowerAdditionalIncome");
        geoSuggestOption = By.className("geosuggest__item");
        userNameField = By.name("username");
        passField = By.name("password");
        agreeCheckBox = By.className("sc-esjQYD");
    }

    // This function will wait for field loading time, will enter data for specified fields and will press
    // "Continue" button. On the following page it will input annual income, additional annual income and
    // click "Continue" button.
    public void submitBasicInfo(String address, String dob, Integer indIncome,
                                Integer addIncome, String emailValue, String passValue) {

        helpers helper = new helpers();
        // This function will wait for field loading time, will enter data for specified fields and will press "Continue" button.
        helper.waitForElement(driver, firstNameField);
        driver.findElement(firstNameField).sendKeys(helper.firstName);
        driver.findElement(lastNameField).sendKeys(helper.lastName);
        driver.findElement(addressField).sendKeys(address);
        helper.waitForElement(driver, geoSuggestOption);
        driver.findElement(geoSuggestOption).click();
        helper.waitForElement(driver, dobField);
        driver.findElement(dobField).sendKeys(dob);
        helper.waitForElement(driver, continueButton);
        driver.findElement(continueButton).click();
        System.out.print(" Moving to income...");
        // On the following page it will input annual income, additional annual income and click "Continue" button.
        helper.waitForElement(driver, individualAnnualIncomeField);
        driver.findElement(individualAnnualIncomeField).sendKeys(Integer.toString(indIncome));
        driver.findElement(additionalAnnualIncomeField).sendKeys(Integer.toString(addIncome));
        driver.findElement(continueButton).click();
        driver.findElement(continueButton).click();
        System.out.print(" Moving to Account Creation...");
        // On the following page it will input email, password, it will click the checkbox and the "Continue" button.
        helper.waitForElement(driver, userNameField);
        driver.findElement(userNameField).sendKeys(emailValue);
        driver.findElement(passField).sendKeys(passValue);
        driver.findElement(agreeCheckBox).click();
        driver.findElement(continueButton).click();
        helper.pause(10000);

    }


}
