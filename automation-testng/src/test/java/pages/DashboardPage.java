package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class DashboardPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By punchInButton = By.id("punchIn");
    private final By toastLocator = By.cssSelector(".toast");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    public void clickPunchIn() {
        wait.waitForClickable(punchInButton).click();
    }

    public String getToastText() {
        String text = wait.waitForAndGetText(toastLocator);
        wait.waitForInvisibility(toastLocator);
        return text;
    }

    public boolean toastContains(String expected) {
        String actual = getToastText();
        return actual != null && actual.toLowerCase().contains(expected.toLowerCase());
    }
}
