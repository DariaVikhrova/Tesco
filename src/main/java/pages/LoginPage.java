package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public static final By SignInTitle = By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/h1");
    public static final By usernameField = By.id("email");
    public static final By passwordField = By.id("password");
    public static final By loginButton = By.xpath("//*[@id=\"signin-button\"]/span/span");
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
    public static final By registrationLink = By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/a");

}
