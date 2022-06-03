//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumTestPart2 {

    private WebDriver driver;

    @BeforeEach
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
        Assertions.assertEquals(forgotPassword, forgotPasswordLinkText, "Link is not correct");
    }

    @Test
    public void createNewAccLinkTest() {
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //check correctness of links
        String createNewAcc = "https://courses.ultimateqa.com/users/sign_up";
        WebElement createNewAccLink = driver.findElement(By.cssSelector(".sign-in__sign-up > a"));
        String createNewAccLinkText = createNewAccLink.getAttribute("href");
        Assertions.assertEquals(createNewAcc, createNewAccLinkText, "Link is not correct");
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
        Assertions.assertEquals(checkedSize, itemsSize, "There are less than 3 remote signIn options are available");
    }

    @Test
    public void loginTest() {
        String checkedText = "Invalid email or password.";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        //open page
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        //click sign in button with empty logan and password fields
        driver.findElement(By.id("user[email]")).isDisplayed();
        driver.findElement(By.id("user[password]")).isDisplayed();
        WebElement signInButton = driver.findElement(By.cssSelector(".form__button-group > input"));
        signInButton.click();
        //wait 2 seconds, check if error is displayed, check error text

        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement error = driver.findElement(By.cssSelector("#notice > ul > li"));*/

        WebElement error =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#notice > ul > li")));
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

    @AfterEach
    public void shutDown(){
        driver.quit();
        driver = null;
    }
}
