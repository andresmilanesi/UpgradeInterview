package helpers;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;


public class helpers {

    //This will generate a random number between 0 and 4999.
    private Random rand = new Random();
    public int randomNumber = rand.nextInt(5000);

    //This generated random names.
    private Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();


    // This timestamp is used to generate unique data.
    public static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    public String urlTimestamp = format.format(new Date());

    // This helper pauses the script when needed.
    public void pause(Integer milliseconds) {

        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // This is a general wait for element helper, it checks if element is clickable, present and visible.
    public void waitForElement(WebDriver driver, By webelement) {

        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds.
        wait.until(ExpectedConditions.elementToBeClickable(webelement));
        wait.until(ExpectedConditions.presenceOfElementLocated(webelement));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webelement));
    }

    // This is a wait for element helper, it checks if element is present.
    public void waitForElementPresent(WebDriver driver, By webelement) {

        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds.
        wait.until(ExpectedConditions.presenceOfElementLocated(webelement));
    }

    // This is a helper to select values from a dropdown field.
    public void selectFromDropdown(WebDriver driver, By locator, Integer value) {

        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(value);
    }


}