package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            { ConfigReader.get("username"), ConfigReader.get("password") }
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.open(ConfigReader.get("baseUrl"));
        lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLogin();
        Assert.assertTrue(lp.isLoginSuccessful(), "Login failed");
    }
}
