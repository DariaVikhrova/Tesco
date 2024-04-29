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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.HomePage;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.HomePage.*;

public class TescoTests extends BasePage {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;

    @Before
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        homePage = new HomePage();
    }
    @After
    public void closeDriver(){
        driver.quit();
    }
   @Given("I open Tesco website")
    public void openTescoWebsite(){
        driver.get(Settings.TESCO_URL);
    }
    @When("I click on Sign in button")
    public void iClickOnSignInButton() throws InterruptedException {
        driver.findElement(signInButton).click();
        Thread.sleep(2000);
    }

    @Then("I see login page with an error")
    public void iSeeLoginPage() throws InterruptedException {
        driver.findElement(By.tagName("h1")); // error message
        Thread.sleep(2000);
    }
    @When("I choose categories")
    public void iChooseCategories() throws InterruptedException {

        List<WebElement> actualElements = driver.findElements(superDepartmentCategories);
        Random superdepartmentRand = new Random();
        int superdepartmentList= superdepartmentRand.nextInt(actualElements.size());
        actualElements.get(superdepartmentList).click();
        Thread.sleep(2000);

        List<WebElement> nextElements = driver.findElements(departmentCategories);
        Random departmentRand = new Random();
        int departmentList= departmentRand.nextInt(nextElements.size());
        nextElements.get(departmentList).click();
        Thread.sleep(2000);

        List<WebElement> lastElements = driver.findElements(aisleCategories);
        Random aisleRand = new Random();
        int aisleList= aisleRand.nextInt(lastElements.size());
        lastElements.get(aisleList).click();
        Thread.sleep(2000);
    }

    @Then("I see product list")
    public void iSeeProductList () throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/main/section")); // error message
        Thread.sleep(2000);
    }
    @And("Language is set to english")
    public void languageIsSetToEnglish() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(changeLanguageButton))).isEnabled();
        String actualText = driver.findElement(changeLanguageButton).getText();
        assertEquals(actualText, "Magyar");
        Thread.sleep(2000);
    }
    @When("I change language to hungarian")
    public void iChangeLanguageToHungarian() throws InterruptedException {
        driver.findElement(changeLanguageButton).click();
        Thread.sleep(2000);
    }
    @Then("Language is changed to hungarian")
    public void languageIsChangedToHungarian() {
        String actualText = driver.findElement(changeLanguageButton).getText();
        assertEquals(actualText, "English");
    }


}
