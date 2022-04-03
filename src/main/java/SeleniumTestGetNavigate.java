import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestGetNavigate {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test1() {
        // open google page using get method in browser
        driver.get("https://www.google.com");
        // go to another website using navigate method
        driver.navigate().to("https://www.youtube.com");
        // use back and forward to switch the pages
        driver.navigate().back();
        driver.navigate().forward();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
