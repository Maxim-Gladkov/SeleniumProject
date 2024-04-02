
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import testbase.*;
import modules.*;
//import org.junit.Assert;
//import org.junit.Test;


public class SeleniumLoginPageTest extends Base {

    @Test
    @Description("positive login")
    public void positiveLogin() {
        ProductsPage productsPage = loginPage.fillOutLoginForm(TestData.user, TestData.password);
        assert productsPage.getHeaderText().equals("Products");
    }

    @Test
    @Description("negative login")
    public void negativeLogin() {
        loginPage.fillOutLoginForm("invalid_user", "invalid_password");
        loginPage.pushLoginButton();
        Assertions.assertEquals(TestData.loginErrorText, loginPage.getErrorText(), "Test is failed!");
//        Assert.assertEquals("Test is failed!", TestData.loginErrorText, loginPage.getErrorText());
    }


    @Test
    @Description("valid user wrong password")
    public void validUserWrongPassword() {
        loginPage.fillOutLoginForm(TestData.user, "invalid_password");
        Assertions.assertEquals(TestData.loginErrorText, loginPage.getErrorText(), "Test is failed!");
    }

    @Test
    public void wrongUserValidPassword() {
        loginPage.fillOutLoginForm("invalid_user", TestData.password);
        Assertions.assertEquals(TestData.loginErrorText, loginPage.getErrorText(), "Test is failed!");
    }

    @Test
    public void emptyUser() {
        loginPage.fillOutLoginForm("", TestData.password);
        Assertions.assertEquals(TestData.emptyUserErrorText, loginPage.getErrorText(), "Test is failed!");
    }

    @Test
    public void emptyPassword() {
        loginPage.fillOutLoginForm(TestData.user, "");
        Assertions.assertEquals(TestData.emptyPasswordErrorText, loginPage.getErrorText(), "Test is failed!");
    }

    @Test
    public void emptyFields() {
        loginPage.fillOutLoginForm("", "");
        Assertions.assertEquals(TestData.emptyUserErrorText, loginPage.getErrorText(), "Test is failed!");
    }

    @Test
    public void positiveLoginAfterError() {
        loginPage.loginWithWrongCredentials();
        Assertions.assertEquals(TestData.loginErrorText, loginPage.getErrorText(), "Test is failed!");
        loginPage.closeErrorMessage();
        Assertions.assertEquals("", loginPage.loginField.getText());
        Assertions.assertEquals("", loginPage.passwordField.getText());
        ProductsPage productsPage = loginPage.positiveLogin();
        assert productsPage.getHeaderText().equals("Products");
    }

    @Test
    public void checkListOfProducts() {
        Assertions.assertNotNull(loginPage.positiveLogin().getListOfItems());
    }

}
