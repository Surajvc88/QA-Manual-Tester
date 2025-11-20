package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class PunchInTest extends BaseTest {

    @BeforeClass
    public void loginOnce() {
        LoginPage lp = new LoginPage(driver);
        lp.open(ConfigReader.get("baseUrl"));
        lp.enterUsername(ConfigReader.get("username"));
        lp.enterPassword(ConfigReader.get("password"));
        lp.clickLogin();
    }

    @Test
    public void testPunchInToast() {
        DashboardPage dp = new DashboardPage(driver);
        dp.clickPunchIn();
        String toast = dp.getToastText();
        Assert.assertTrue(toast.toLowerCase().contains("punch"), "Unexpected toast: " + toast);
    }
}
