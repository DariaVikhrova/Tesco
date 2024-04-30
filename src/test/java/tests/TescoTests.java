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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static pages.HomePage.*;
import static pages.LoginPage.*;

public class TescoTests {

    WebDriver driver;
    WebDriver driver1;
    WebDriverWait wait;
    WebDriverWait wait1;
    HomePage homePage;
    LoginPage loginPage;



    @Before
    public void initializeDriver() {

        driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        driver.get(Settings.TESCO_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.isLoaded();
        loginPage = new LoginPage(driver);

    }

   /* @After
    public void closeDriver(){
        driver.quit();
    }

    */
   @Given("I open Tesco website")
    public void openTescoWebsite(){
        driver.get(Settings.TESCO_URL);
    }
    @And("I accept cookies")
    public void acceptCookiesOnStartPage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(CookiesButton))).isEnabled();
        driver.findElement(CookiesButton).click();
    }
    @When("I click on Sign in button")
    public void iClickOnSignInButton() throws InterruptedException {
        driver.findElement(signInButtonOnTheHomePage).click();
        Thread.sleep(2000);
    }
    @And("I see login page")
    public void iSeeLoginPage() throws InterruptedException {
        driver.findElement(By.tagName("h1")); // error message
        Thread.sleep(2000);
    }
    @And("I input {string} and {string}")
    public void iInputUserNameAndPassword(String username, String password) {
     WebElement elementEmailInput = driver.findElement(usernameField);
     wait.until(ExpectedConditions.visibilityOf(elementEmailInput)).isEnabled();
     elementEmailInput.sendKeys(username);

     WebElement elementPasswordInput = driver.findElement(passwordField);
     elementPasswordInput.isEnabled();
     elementPasswordInput.sendKeys(password);
 }
    @And("I click on log in button")
    public void iClickOnLogInButton() {
        driver.findElement(loginButton).click();
    }
    @Then("I see an error")
    public void iSeeAnError() {
        WebElement elementErrorText = driver.findElement(errorMessage);
        elementErrorText.isDisplayed();
        String actualText = elementErrorText.getText();
        assertEquals(actualText, LOGIN_ERROR);
        driver.close();
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
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/main/section"));
        Thread.sleep(2000);
    }
    @And("Language is set to english")
    public void languageIsSetToEnglish() throws InterruptedException {
        wait.until(visibilityOf(driver.findElement(changeLanguageButton))).isEnabled();
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
    /*@Given("I open Online club website")
    public void iOpenOnlineClubWebsite() {
        driver.get(Settings.OnlineClub_URL);
    }
     */
    @When("I click on Online club")
    public void iClickOnOnlineClub() throws InterruptedException {
        List<WebElement> actualElements = driver.findElements(By.className("nav-item"));
        driver.findElement(By.xpath("//*[@id=\"onlineClub\"]/a")).click();
        Thread.sleep(5000);
    }
    @And("Click on start trial button")
    public void clickOnRadioButton() throws InterruptedException {
        //driver1 = DriverInitializer.initializeDriver(BrowserType.CHROME);
        //driver1.get(Settings.OnlineClub_URL);
        //wait1 = new WebDriverWait(driver1, Duration.ofSeconds(5));
        //wait.until(visibilityOf(driver.findElement(By.tagName("Start your trial now"))));
        Thread.sleep(2000);
        driver1.findElement(By.tagName("Start your trial now")).click();

    }
    @Then("Click on Start trial")
    public void clickOnStartTrial() throws InterruptedException {
        driver1.findElement(By.id("subscribe-btn")).click();
        Thread.sleep(2000);
    }
}
