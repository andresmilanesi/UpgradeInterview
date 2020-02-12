package pages;

import dataProviders.configFileReader;
import helpers.helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageLogin {

    private WebDriver driver;
    private By userField;
    private By passField;
    private By signInButton;
    private dataProviders.configFileReader configFileReader= new configFileReader();

    public pageLogin(WebDriver driver) {

        this.driver = driver;
        userField = By.name("username");
        passField = By.name("password");
        signInButton = By.className("sc-jTzLTM");
    }

    // This is the login function
    public void login(String userEmail, String pass) {

        driver.navigate().to(configFileReader.loginURL());
        helpers helper = new helpers();
        helper.waitForElement(driver, userField);
        driver.findElement(userField).sendKeys(userEmail);
        driver.findElement(passField).sendKeys(pass);
        driver.findElement(signInButton).click();

    }
}
