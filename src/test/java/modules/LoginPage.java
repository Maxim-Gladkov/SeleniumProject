package modules;

import testbase.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Base {

    WebDriver driver;

    public LoginPage() {
        this.driver = Base.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.login_logo")
    public WebElement pageLogo;

    @FindBy(id = "user-name")
    public WebElement loginField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css = ".error-message-container.error > h3")
    public WebElement error;

    @FindBy(className = "error-button")
    public WebElement closeErrorButton;



    public void fillOutLoginField (String user) {
        loginField.isDisplayed();
        loginField.clear();
        loginField.sendKeys(user);
    }

    public void fillOutPasswordField (String password) {
        passwordField.isDisplayed();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void pushLoginButton() {
        loginButton.isDisplayed();
        loginButton.click();
    }

    public ProductsPage fillOutLoginForm(String user, String password) {
        fillOutLoginField(user);
        fillOutPasswordField(password);
        pushLoginButton();
        return new ProductsPage();
    }

    public ProductsPage positiveLogin() {
        ProductsPage productsPage = fillOutLoginForm(TestData.user, TestData.password);
        return productsPage;
    }

    public String loginWithWrongCredentials() {
        fillOutLoginForm("invalid_user", "invalid_password");
        return getErrorText();
    }

    public String getErrorText() {
        return error.getAttribute("innerText");
    }

    public void closeErrorMessage() {
        closeErrorButton.click();
    }

}
