package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public static final By CookiesButton = By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button");
    public void clickOnCookiesButton(){
        driver.findElement(CookiesButton).click();
    }
    public static final By changeLanguageButton = By.id("utility-header-language-switch-link");
    public void clickOnChangeLanguageButton(){
        driver.findElement(changeLanguageButton).click();
    }

    public static final By signInButtonOnTheHomePage = By.xpath("//*[@id=\"utility-header-login-link\"]/span");

    public void clickOnSignInButtonOnTheHomePage(){
        driver.findElement(signInButtonOnTheHomePage).click();
    }
    public static final By superDepartmentCategories = By.xpath("//*[contains(@class,'menu__item--superdepartment')]");
    public static final By departmentCategories = By.xpath("//*[contains(@class,'menu__item--department')]");
    public static final By aisleCategories = By.xpath("//*[contains(@class,'menu__item--aisle')]");
    public static final By onlineClubCategoryLink =By.xpath("//*[@id=\"onlineClub\"]/a");
    public void clickOnOnlineClubCategoryLink(){
        driver.findElement(onlineClubCategoryLink).click();
    }
    public static final By navBar = By.className("nav-item");
    public static final By searchField = By.xpath("//input[@id='search-input']");
    public static final By searchButton = By.xpath("//*[@id=\"search-form\"]/button");
    public void clickOnSearchButton(){
        driver.findElement(searchButton).click();
    }

}
