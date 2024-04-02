//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SeleniumTestFirefox {

    private WebDriver driver;

    // initialize driver
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium_WebDrivers\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--remote-allow-origins=*");
        options.setBrowserVersion("124.0.1");

        driver = new FirefoxDriver(options);
    }

    // navigate to a page
    @Test
    public void firefoxBrowserTest() {
        driver.get("https://www.google.com");
        /*similar method
         * driver.navigate().to("https://www.google.com");
         * */
    }

    // stop driver and shut down browser
    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }
}
