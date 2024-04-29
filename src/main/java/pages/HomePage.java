package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public static final By changeLanguageButton = By.id("utility-header-language-switch-link");
    public static final By signInButton = By.xpath("//a[@class='button button-primary']");
    public static final By superDepartmentCategories = By.xpath("//*[contains(@class,'menu__item--superdepartment')]");
    public static final By departmentCategories = By.xpath("//*[contains(@class,'menu__item--department')]");
    public static final By aisleCategories = By.xpath("//*[contains(@class,'menu__item--aisle')]");
}
