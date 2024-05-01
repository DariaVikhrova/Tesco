package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscriptionPage extends BasePage{
    public SubscriptionPage(WebDriver driver) {
        super(driver);
    }
    public static final By subscribeButton = By.id("subscribe-btn");
    public static final By startTrialNowText = By.linkText("Start your trial now");

}
