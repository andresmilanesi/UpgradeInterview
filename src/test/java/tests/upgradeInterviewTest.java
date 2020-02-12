package tests;

import helpers.helpers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import dataProviders.configFileReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pages.*;

import static io.restassured.RestAssured.*;


public class upgradeInterviewTest {

    private WebDriver driver;
    private configFileReader configFileReader= new configFileReader();

    // What we are going to run before tests execution.
    @BeforeMethod

    public void setUp() {

        // Local setup
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    // What we are going to run after the tests execution.
    @AfterMethod

    public void tearDown() {

        driver.close();
        driver.quit();

    }

    // This is the UI test case.
    @Test(priority=1)
    public void testUserFlow() {

        helpers helper = new helpers();
        // Complete loan amount, purpose and continues.
        pageCheckRate cRate = new pageCheckRate(driver);
        cRate.checkRate(2000, 1);
        // Complete name, last name, address, DOB and continues.
        pageBasicInfo basicInfo = new pageBasicInfo(driver);
        basicInfo.submitBasicInfo("5400 N. Lakewood Avenue",
                "01011984", 135000, 7500,
                "candidate+"+helper.randomNumber+"@upgrade-challenge.com", "Thisis89");
        // Store required values.
        pageOffer sOffer = new pageOffer(driver);
        sOffer.storeLoanAmount1();
        sOffer.storeMonthlyPayment1();
        sOffer.storeTerm1();
        sOffer.storeInterestRate1();
        sOffer.storeApr1();
        // Log out.
        sOffer.logOut();
        // Browse to login page and login with same credentials used before.
        pageLogin login = new pageLogin(driver);
        login.login("candidate+"+helper.randomNumber+"@upgrade-challenge.com", "Thisis89");
        // Store offer values.
        sOffer.storeLoanAmount2();
        sOffer.storeMonthlyPayment2();
        sOffer.storeTerm2();
        sOffer.storeInterestRate2();
        sOffer.storeApr2();
        // Compare values and assert they are equal.
        sOffer.compareResults();

    }


    private Response getRequest() {

        RestAssured.defaultParser = Parser.JSON;

        HashMap<String, String> headerContent = new HashMap<>();
        headerContent.put("x-cf-source-id", "coding-challenge");
        headerContent.put("x-cf-corr-id", "230ea84a-7199-41c9-bf38-fff27e12007s");
        headerContent.put("Content-Type", "application/json");
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("username", "coding.challenge.login@upgrade.com");
        postContent.put("password", "On$3XcgsW#9q");

        return
        with().headers(headerContent).body(postContent).when().post(configFileReader.APIURL()).then().
                contentType(ContentType.JSON).extract().response();


        // Perform the POST request and validate that status code is 200, and that the product type is personal loan.
//        with().headers(headerContent).body(postContent).when().post(configFileReader.APIURL()).
//                then().log().ifValidationFails(LogDetail.BODY).statusCode(200).
//                body("loansInReview.productType", equalTo("PERSONAL_LOAN"));

    }

    @Test(priority=2)
    public void testAPIOne() {

        HashMap<String, String> headerContent = new HashMap<>();
        headerContent.put("x-cf-source-id", "coding-challenge");
        headerContent.put("x-cf-corr-id", "230ea84a-7199-41c9-bf38-fff27e12007s");
        headerContent.put("Content-Type", "application/json");
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("username", "coding.challenge.login@upgrade.com");
        postContent.put("password", "On$3XcgsW#9q");


        // Perform the POST request and validate that status code is 200.
        with().headers(headerContent).body(postContent).when().post(configFileReader.APIURL()).
                then().statusCode(200);


    }


    @Test(priority=2)
    public void testAPITwo() {

        // Here we parse the json.
        Response response = getRequest();
        String jsonResponse = response.jsonPath().getString("loansInReview.productType");
        // Here we assert the expected value for the field.
        Assert.assertEquals(jsonResponse, "[PERSONAL_LOAN]");

    }

    @Test(priority=3)
    public void testAPIThree() {

        HashMap<String, String> headerContent = new HashMap<>();
        headerContent.put("x-cf-source-id", "coding-challenge");
        headerContent.put("x-cf-corr-id", "230ea84a-7199-41c9-bf38-fff27e12007s");
        headerContent.put("Content-Type", "application/json");
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("username", "nonexistingvalue@testing.com");
        postContent.put("password", "nopasswordatall");

        // Perform the POST request with non existing user credentials and validates a 401 response.
        with().headers(headerContent).body(postContent).when().post(configFileReader.APIURL()).
                then().assertThat().statusCode(401);

    }


}
