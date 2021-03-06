//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestFirefox {

    private WebDriver driver;

    // initialize driver
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium WebDriver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    // navigate to a page
    @Test
    public void myTest() {
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
