package tests;

import driver.BrowserType;
import driver.DriverInitializer;
import driver.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;
    private String expectedTitle;
    private String actualTitle;


    @Before
    public void initializeDriver() {
        driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @After
    public void closeDriver(){
        driver.quit();
    }

    @Test
    public void TitleIsValid(){
        driver.get(Settings.TESCO_URL);
        expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
        actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Given("I open Tesco website")
    public void openTescoWebsite(){
        driver.get(Settings.TESCO_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("signin-register--signin")));
    }

    @When("I click on Sign in button")
    public void iClickOnSignInButton() throws InterruptedException {
        driver.findElement(By.className(("signin-register--signin-button"))).click();
        Thread.sleep(2000);
    }

    @Then("I see login page with an error")
    public void iSeeLoginPage() throws InterruptedException {
        driver.findElement(By.tagName("h1")); // error message
        Thread.sleep(2000);

    }
}
