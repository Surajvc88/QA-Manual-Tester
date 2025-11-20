package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("loginBtn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        wait.waitForVisibility(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        wait.waitForClickable(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return wait.waitForUrlContains("/dashboard", 10);
    }
}
