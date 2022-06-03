package testbase;

import modules.LoginPage;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class Base {
    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = openLoginPage();
    }

    @AfterEach
    public void shoutDown() {
        driver.quit();
        driver = null;
    }

    public static LoginPage openLoginPage() {
        driver.get(TestData.baseUrl);
        return new LoginPage();
    }
}
