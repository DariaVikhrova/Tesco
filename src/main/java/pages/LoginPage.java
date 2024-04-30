package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public static final By usernameField = By.id("email");
    public static final By passwordField = By.id("password");
    public static final By loginButton = By.xpath("//*[@id=\"signin-button\"]/span/span");
    public static final By errorMessage = By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div/div[2]/p[1]");
    public static final String LOGIN_ERROR = "Unfortunately we do not recognise those details.";
}
