package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;

public class AddCustomerTest extends BaseTest {

    @DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][] {
            { "AutoCustomer", unique("auto@example.com"), "Customer added" }
        };
    }

    @Test(dataProvider = "customerData")
    public void testAddCustomer(String name, String email, String expected) {
        LoginPage lp = new LoginPage(driver);
        lp.open(ConfigReader.get("baseUrl"));
        lp.enterUsername(ConfigReader.get("username"));
        lp.enterPassword(ConfigReader.get("password"));
        lp.clickLogin();

        CustomerPage cp = new CustomerPage(driver);
        cp.openAddCustomerForm();
        cp.fillCustomerForm(name, email);
        cp.clickSave();
        Assert.assertTrue(cp.isCustomerAdded(expected), "Customer not added");
    }

    private String unique(String base) {
        return base.replace("@", "+" + System.currentTimeMillis() + "@");
    }
}
