package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public final static By rightSideBasket = By.xpath("//*[@id=\"mini-trolley\"]/div/div[1]/h2");
    public final static By searchResultMessageText= By.id("results");
    public final static String searchResultMessage = "Results for “cream”";
}
