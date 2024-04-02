//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTestChrome {

    private WebDriver driver;

    // initialize driver
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium_WebDrivers\\new_chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }

    // navigate to a page
    @Test
    public void chromeBrowserTest() {
        driver.get("https://www.google.com");
        // similar method
        // driver.navigate().to("https://www.youtube.com");
    }

    // stop driver and shut down browser
    @AfterEach
    public void stop() {
        driver.quit();
        driver = null;
    }

}