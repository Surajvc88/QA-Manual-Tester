package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CustomerPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By addCustomerButton = By.id("addCustomer");
    private final By nameField = By.id("custName");
    private final By emailField = By.id("custEmail");
    private final By saveButton = By.id("saveCustomer");
    private final By successMessage = By.cssSelector(".alert-success");

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    public void openAddCustomerForm() {
        wait.waitForClickable(addCustomerButton).click();
    }

    public void fillCustomerForm(String name, String email) {
        wait.waitForVisibility(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSave() {
        wait.waitForClickable(saveButton).click();
    }

    public boolean isCustomerAdded(String expectedText) {
        String actual = wait.waitForAndGetText(successMessage);
        return actual != null && actual.contains(expectedText);
    }
}
