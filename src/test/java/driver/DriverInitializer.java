package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverInitializer {
    public static WebDriver initializeDriver(BrowserType browserType) {
       if (browserType ==BrowserType.CHROME) {
           return new ChromeDriver();
       } else {
           return new FirefoxDriver();
       }
    }
}
