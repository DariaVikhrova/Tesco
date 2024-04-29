package tests;

import driver.BrowserType;
import driver.DriverInitializer;
import driver.Settings;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {
    private String expectedTitle;
    private String actualTitle;
    @Test
    public void TitleIsValid(){

        String expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
        WebDriver driver = DriverInitializer.initializeDriver(BrowserType.CHROME);
        driver.get(Settings.TESCO_URL);
        actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }
}
