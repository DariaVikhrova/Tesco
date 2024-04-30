package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverInitializer {
    public static WebDriver initializeDriver(BrowserType browserType) {

       if (browserType ==BrowserType.CHROME) {
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--disable-blink-features=AutomationControlled");
           return new ChromeDriver(options);
       } else {
           return new FirefoxDriver();
       }
    }
}
