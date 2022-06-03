//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestChrome {

    private WebDriver driver;

    // initialize driver
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    // navigate to a page

    public void Test() {
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