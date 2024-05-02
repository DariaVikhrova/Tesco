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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static pages.HomePage.*;
import static pages.LoginPage.*;
import static pages.ProductPage.*;
import static pages.SubscriptionPage.startTrialNowText;
import static pages.SubscriptionPage.subscribeButton;

public class TescoTests {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;

    @Before
    public void initializeDriver() {

        driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        driver.get(Settings.TESCO_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.isLoaded();
    }

//    @After
//    public void closeDriver() {
//        driver.quit();
//    }

    @Given("I open Tesco website")
    public void openTescoWebsite() {
        driver.get(Settings.TESCO_URL);
    }

    @And("I accept cookies")
    public void acceptCookiesOnStartPage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(CookiesButton))).isEnabled();
        driver.findElement(CookiesButton).click();
    }

    @When("I click on Sign in button")
    public void iClickOnSignInButton() {
        driver.findElement(signInButtonOnTheHomePage).click();
    }

    @And("I see login page")
    public void iSeeLoginPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/h1"));
        Thread.sleep(3000);
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
        wait.until(visibilityOf(driver.findElement(errorMessage)));
        WebElement elementErrorText = driver.findElement(errorMessage);
        elementErrorText.isDisplayed();
        String actualText = elementErrorText.getText();
        assertEquals(actualText, LOGIN_ERROR);
    }

    @When("I choose categories")
    public void iChooseCategories() throws InterruptedException {

        List<WebElement> actualElements = driver.findElements(superDepartmentCategories);
        Random superdepartmentRand = new Random();
        int superdepartmentList = superdepartmentRand.nextInt(actualElements.size());
        actualElements.get(superdepartmentList).click();
        Thread.sleep(2000);

        List<WebElement> nextElements = driver.findElements(departmentCategories);
        Random departmentRand = new Random();
        int departmentList = departmentRand.nextInt(nextElements.size());
        nextElements.get(departmentList).click();
        Thread.sleep(2000);

        List<WebElement> lastElements = driver.findElements(aisleCategories);
        Random aisleRand = new Random();
        int aisleList = aisleRand.nextInt(lastElements.size());
        lastElements.get(aisleList).click();
        Thread.sleep(2000);
    }

    @Then("I see product list")
    public void iSeeProductList() {
        driver.findElement(rightSideBasket);
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

    @When("I click on Online club")
    public void iClickOnOnlineClub() throws InterruptedException {
        List<WebElement> actualElements = driver.findElements(navBar);
        driver.findElement(onlineClubCategoryLink).click();
    }

    @And("Click on start trial button")
    public void clickOnRadioButton() {
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window((String) handles.toArray()[handles.size()-1]);
        wait.until(visibilityOf(driver.findElement(startTrialNowText)));
        driver.findElement(startTrialNowText).click();
    }

    @Then("Click on Start trial")
    public void clickOnStartTrial() {
        driver.findElement(subscribeButton).click();
    }

    @When("I input {string} in search field")
    public void iInputInSearchField(String searchText) {
        driver.findElement(searchField).sendKeys(searchText);
    }

    @And("I click on the search button")
    public void iClickOnTheSearchButton() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(2000);
    }

    @Then("I see the page with the word {string}")
    public void iSeeThePageWithTheWord(String searchText) {
        wait.until(visibilityOf(driver.findElement(searchResultMessageText)));
        WebElement searchResultText = driver.findElement(searchResultMessageText);
        searchResultText.isDisplayed();
        String actualText = searchResultText.getText();
        assertEquals(actualText, searchResultMessage);
    }
}