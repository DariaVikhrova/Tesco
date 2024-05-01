package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public static final By CookiesButton = By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button");
    public static final By changeLanguageButton = By.id("utility-header-language-switch-link");
    public static final By signInButtonOnTheHomePage = By.xpath("//a[@class='button button-primary']");
    public static final By superDepartmentCategories = By.xpath("//*[contains(@class,'menu__item--superdepartment')]");
    public static final By departmentCategories = By.xpath("//*[contains(@class,'menu__item--department')]");
    public static final By aisleCategories = By.xpath("//*[contains(@class,'menu__item--aisle')]");
    public static final By onlineClubCategoryLink =By.xpath("//*[@id=\"onlineClub\"]/a");
    public static final By navBar = By.className("nav-item");
    public static final By searchField = By.xpath("//input[@id='search-input']");
    public static final By searchButton = By.xpath("//*[@id=\"search-form\"]/button");

}
