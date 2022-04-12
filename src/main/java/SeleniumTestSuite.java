import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumTestSuite {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testGetNavigate() {
        // open google page using get method in browser
        driver.get("https://www.google.com");
        // go to another website using navigate method
        driver.navigate().to("https://www.youtube.com");
        // use back and forward to switch the pages
        driver.navigate().back();
        driver.navigate().forward();
    }

    @Test
    public void testPageElements() {
        //start browser and open the link
        driver.navigate().to("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        //find and interact with elements
        WebElement linkLogo = driver.findElement(By.xpath("//div[@class=\"logo\"]/a"));
        linkLogo.click();
        driver.navigate().back();

        //find elements on the page
        WebElement phoneNumber = driver.findElement(By.xpath("//div[@class=\"span_3_of_4\"]/ul/li[1]"));
        System.out.println(phoneNumber.getText());
        WebElement emailAddress = driver.findElement(By.linkText("trainer@way2automation.com"));
        System.out.println(emailAddress.getText());
        WebElement skype = driver.findElement(By.xpath("//div[@class=\"span_3_of_4\"]/ul/li[3]"));
        System.out.println(skype.getText());
        WebElement regFormHeader = driver.findElement(By.tagName("h2"));
        System.out.println(regFormHeader.getText());
    }

    @Test
    public void testDropdownList() {
        //start browser and open the link
        driver.navigate().to("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        //find first dropdown list and check if it's displayed
        WebElement dropdownInteraction = driver.findElement(By.cssSelector("#toggleNav > li:nth-child(2) > a"));
        Actions action = new Actions(driver);
        action.moveToElement(dropdownInteraction).build().perform();
        WebElement dropdownList = driver.findElement(By.cssSelector("#toggleNav > li:nth-child(2) > ul"));
        dropdownList.isDisplayed();
    }

    @Test
    public void testInputFields() {
        //start browser and open the link
        driver.navigate().to("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        //find First Name and Last Name fields and input text
        WebElement firstNameField = driver.findElement(By.cssSelector("fieldset > p:nth-child(1) > input"));
        WebElement lastNameField = driver.findElement(By.cssSelector("fieldset > p:nth-child(2) > input"));
        firstNameField.sendKeys("text");
        lastNameField.sendKeys("texttext");
    }

    @Test
    public void testRadioButtons() {
        //start browser and open the link
        driver.navigate().to("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        //find and click on radio buttons
        WebElement singleElement = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[2]/div/label[1]/input"));
        singleElement.click();
        WebElement marriedElement = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[2]/div/label[2]/input"));
        marriedElement.click();
        WebElement divorcedElement = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[2]/div/label[3]/input"));
        divorcedElement.click();
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
