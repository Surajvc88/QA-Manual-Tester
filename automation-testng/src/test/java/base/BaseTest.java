package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"headless"})
    public void setup(@Optional("false") String headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
