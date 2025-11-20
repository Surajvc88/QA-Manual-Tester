package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver, long seconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public String waitForAndGetText(By locator) {
        return waitForVisibility(locator).getText();
    }

    public boolean waitForUrlContains(String value, long seconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.urlContains(value));
        } catch (Exception e) {
            return false;
        }
    }
}
