package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helpers.*;
import org.testng.Assert;


public class pageOffer {

    private WebDriver driver;
    private By loanAmountField;
    private By monthlyPaymentField;
    private By termField;
    private By interestRateField;
    private By aprField;
    private By menuButton;
    private By signOutButton;

    public pageOffer(WebDriver driver) {

        this.driver = driver;
        loanAmountField = By.className("sc-kgoBCf");
        monthlyPaymentField = By.className("sc-bsbRJL");
        termField = By.xpath("//*[@id='root']/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[1]");
        interestRateField = By.xpath("//*[@id='root']/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[2]");
        aprField = By.xpath("//*[@id='root']/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[3]/div/div");
        menuButton = By.className("header-nav");
        signOutButton = By.xpath("//*[@id='root']/div/main/div/header/div/nav/ul/li[2]/a");
    }

    public String storeLoanAmount1() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, loanAmountField);
        return driver.findElement(loanAmountField).getText();

    }

    public String storeLoanAmount2() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, loanAmountField);
        return driver.findElement(loanAmountField).getText();

    }

    public String storeMonthlyPayment1() {
        helpers helper = new helpers();
        helper.waitForElementPresent(driver, monthlyPaymentField);
        return driver.findElement(monthlyPaymentField).getText();

    }

    public String storeMonthlyPayment2() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, monthlyPaymentField);
        return driver.findElement(monthlyPaymentField).getText();

    }

    public String storeTerm1() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, termField);
        return driver.findElement(termField).getText();

    }

    public String storeTerm2() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, termField);
        return driver.findElement(termField).getText();

    }

    public String storeInterestRate1() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, interestRateField);
        return driver.findElement(interestRateField).getText();

    }

    public String storeInterestRate2() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, interestRateField);
        return driver.findElement(interestRateField).getText();

    }

    public String storeApr1() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, aprField);
        return driver.findElement(aprField).getText();

    }

    public String storeApr2() {

        helpers helper = new helpers();
        helper.waitForElementPresent(driver, aprField);
        return driver.findElement(aprField).getText();

    }

    public void logOut() {

        helpers helper = new helpers();
        helper.waitForElement(driver, menuButton);
        driver.findElement(menuButton).click();
        helper.waitForElement(driver, signOutButton);
        driver.findElement(signOutButton).click();

    }

    // This is the function that verifies that the obtained results match between each other.
    public void compareResults() {

        Assert.assertEquals(storeLoanAmount1(), storeLoanAmount2());
        Assert.assertEquals(storeMonthlyPayment1(), storeMonthlyPayment2());
        Assert.assertEquals(storeTerm1(), storeTerm2());
        Assert.assertEquals(storeInterestRate1(), storeInterestRate2());
        Assert.assertEquals(storeApr1(), storeApr2());

    }

}
