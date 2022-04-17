import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SeleniumTestPart2 {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void headerTextTest() {
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check text
        String checkedText = "Welcome Back!";
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(), \"Welcome Back!\")]"));
        String headerText = header.getAttribute("textContent");
        assert headerText.equals(checkedText);
    }

    @Test
    public void emailFieldTest() {
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check page elements
        WebElement emailField = driver.findElement(By.id("user[email]"));
        assert emailField.isDisplayed();
    }

    @Test
    public void passwordFieldTest() {
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check page elements
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        assert passwordField.isDisplayed();
    }

    @Test
    public void rememberMeCheckboxTest() {
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check page elements
        WebElement rememberMeCheckbox = driver.findElement(By.id("user[remember_me]"));
        assert rememberMeCheckbox.isDisplayed();
    }

    @Test
    public void signInButtonTest() {
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check page elements
        WebElement signInButton = driver.findElement(By.cssSelector(".form__button-group > input"));
        assert signInButton.isDisplayed();
    }

    @Test
    public void forgotPasswordLinkTest() {
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check correctness of links
        String forgotPassword = "https://courses.ultimateqa.com/users/password/new";
        WebElement forgotPasswordlink = driver.findElement(By.cssSelector("a.form__forgot-password"));
        String forgotPasswordLinkText = forgotPasswordlink.getAttribute("href");
        Assert.assertEquals("Link is not correct", forgotPassword, forgotPasswordLinkText);
    }

    @Test
    public void createNewAccLinkTest() {
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check correctness of links
        String createNewAcc = "https://courses.ultimateqa.com/users/sign_up";
        WebElement createNewAccLink = driver.findElement(By.cssSelector(".sign-in__sign-up > a"));
        String createNewAccLinkText = createNewAccLink.getAttribute("href");
        Assert.assertEquals("Link is not correct", createNewAcc, createNewAccLinkText);
    }

    @Test
    public void remoteSignInTest() {
        Integer checkedSize = 3;
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check that 3 remote signIn options are available
        WebElement remoteSignInList = driver.findElement(By.cssSelector("#main-content > div > div > article > div > ul"));
        List<WebElement> items = remoteSignInList.findElements(By.tagName("li"));
        Integer itemsSize = items.size();
        Assert.assertEquals("There are less than 3 remote signIn options are available", checkedSize, itemsSize);
    }

    @Test
    public void loginTest() {
        String checkedText = "Invalid email or password.";
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //click sign in button with empty logan and password fields
        driver.findElement(By.id("user[email]")).isDisplayed();
        driver.findElement(By.id("user[password]")).isDisplayed();
        WebElement signInButton = driver.findElement(By.cssSelector(".form__button-group > input"));
        signInButton.click();
        //wait 2 seconds until error message will be displayed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //check if error is displayed, check error text
        WebElement error = driver.findElement(By.cssSelector("#notice > ul > li"));
        assert error.isDisplayed();
        String errorText = error.getAttribute("textContent");
        assert errorText.equals(checkedText);
    }

    @Test
    public void createNewAccountTest() {
        String checkedText = "Create a new account";
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //find header and compare text
        driver.findElement(By.cssSelector("#main-content > div > div > aside > a")).click();
        WebElement header = driver.findElement(By.cssSelector("#main-content > div > div > article > h1"));
        String headerText = header.getAttribute("innerText");
        System.out.println(headerText);
        assert checkedText.equals(headerText);
    }

    @After
    public void shutDown(){
        driver.quit();
        driver = null;
    }
}
